package xyz.lmiceli.techtest.mosbylce;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;
import xyz.lmiceli.techtest.R;
import xyz.lmiceli.techtest.service.StoreDTO;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.StoreVH> {

  public List<StoreDTO> getCountries() {
    return countries;
  }

  private List<StoreDTO> countries = new ArrayList<>();
  private FragmentActivity activity;

  public CountriesAdapter(FragmentActivity activity) {

    this.activity = activity;
  }

  @Override public StoreVH onCreateViewHolder(ViewGroup parent, int viewType) {

    LayoutInflater inflater = LayoutInflater.from(parent.getContext());

    return new StoreVH(inflater.inflate(R.layout.row_store, parent, false));
  }

  @Override public void onBindViewHolder(StoreVH holder, int position) {
    holder.name.setText(countries.get(position).getCountryName());
  }

  @Override public int getItemCount() {
    return countries.size();
  }

  public void setCountries(List<StoreDTO> countries) {
    this.countries = countries;
    notifyDataSetChanged();
  }

  public class StoreVH extends RecyclerView.ViewHolder {

    @BindView(R.id.row_store_name) TextView name;

    public StoreVH(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
