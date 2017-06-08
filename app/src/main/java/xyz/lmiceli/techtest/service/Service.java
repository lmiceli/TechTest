package xyz.lmiceli.techtest.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class Service {

  // Business logic: We use Retrofit to load a list of Countries from a web service
  public interface CountriesApi {

    @GET("catalog/store") Call<StoreListResponseDTO> getStoreList(
        @Query("brandId") String brandId);
  }

  public static CountriesApi getService() {

    String ENDPOINT = "https://www.massimodutti.com/itxrest/2/";

    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    // set your desired log level
    logging.setLevel(HttpLoggingInterceptor.Level.BODY);

    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    // add your other interceptors …

    // add logging as last interceptor
    httpClient.addInterceptor(logging);  // <-- this is the important line!

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(ENDPOINT)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient.build())
        .build();

    // todo no create everytiem
    return retrofit.create(CountriesApi.class);
  }
}
