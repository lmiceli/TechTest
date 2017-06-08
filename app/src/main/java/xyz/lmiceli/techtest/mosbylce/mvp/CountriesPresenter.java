package xyz.lmiceli.techtest.mosbylce.mvp;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.lmiceli.techtest.service.Service;
import xyz.lmiceli.techtest.service.StoreListResponseDTO;

public class CountriesPresenter extends MvpBasePresenter<CountriesView> {

  //private Service service;

  public void loadCountries(final boolean pullToRefresh) {

    Callback<StoreListResponseDTO> callback = new Callback<StoreListResponseDTO>() {
      @Override public void onResponse(Call<StoreListResponseDTO> call,
          Response<StoreListResponseDTO> response) {

        /*just to see how view reacts while loading*/
        /*try {
          Thread.sleep(3000L);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }*/

        if (canSetData(response)) {
          getView().setData(response.body().getStores());
          getView().showContent();
        }
      }

      @Override public void onFailure(@NonNull Call<StoreListResponseDTO> call, @NonNull Throwable t) {

        if (isViewAttached()) {
          getView().showError(t.getCause(), pullToRefresh);
        }
      }
    };

    Call<StoreListResponseDTO> call = Service.getService().getStoreList("3");

    call.enqueue(callback);
  }

  private boolean canSetData(Response<StoreListResponseDTO> response) {
    return isViewAttached() && getView() != null && response.body() != null && response.body().getStores() != null;
  }
}