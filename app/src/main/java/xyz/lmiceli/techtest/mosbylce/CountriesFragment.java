package xyz.lmiceli.techtest.mosbylce;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment;
import java.util.List;
import xyz.lmiceli.techtest.R;
import xyz.lmiceli.techtest.mosbylce.mvp.CountriesPresenter;
import xyz.lmiceli.techtest.mosbylce.mvp.CountriesView;
import xyz.lmiceli.techtest.service.StoreDTO;

public class CountriesFragment
    extends MvpLceFragment<SwipeRefreshLayout, List<StoreDTO>, CountriesView, CountriesPresenter>
    implements CountriesView, SwipeRefreshLayout.OnRefreshListener {

  @BindView(R.id.recyclerView) RecyclerView recyclerView;
  CountriesAdapter adapter;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_countries, container, false);
  }

  @Override public void onViewCreated(View view, Bundle savedInstance) {
    super.onViewCreated(view, savedInstance);
    ButterKnife.bind(this, view);
    // contentView is SwipeRefreshLayout
    contentView.setOnRefreshListener(this);

    // Setup recycler view
    adapter = new CountriesAdapter(getActivity());
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    recyclerView.setAdapter(adapter);
    loadData(false);
  }

  @Override public void loadData(boolean pullToRefresh) {
    presenter.loadCountries(pullToRefresh);
  }

  @Override public void onRefresh() {
    loadData(true);
  }

  @Override public CountriesPresenter createPresenter() {
    return new CountriesPresenter();
  }

  @Override public void setData(List<StoreDTO> data) {
    adapter.setCountries(data);
    adapter.notifyDataSetChanged();
  }

  @Override public void showContent() {
    super.showContent();
    contentView.setRefreshing(false);
  }

  @Override protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
    return "no se que poner aca";
  }

  @Override public void showError(Throwable e, boolean pullToRefresh) {
    super.showError(e, pullToRefresh);
    contentView.setRefreshing(false);
  }

  @Override public void showLoading(boolean pullToRefresh) {
    super.showLoading(pullToRefresh);
    contentView.setRefreshing(pullToRefresh);
  }
}
