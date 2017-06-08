package xyz.lmiceli.techtest.mosbylce.mvp;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import java.util.List;
import xyz.lmiceli.techtest.service.StoreDTO;

// View interface
public interface CountriesView extends MvpLceView<List<StoreDTO>> {
  // MvpLceView already defines LCE methods:
  //
  // void showLoading(boolean pullToRefresh)
  // void showError(Throwable t, boolean pullToRefresh)
  // void setData(List<Country> data)
  // void showContent()
}
