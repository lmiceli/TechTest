package xyz.lmiceli.techtest.service;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class StoreListResponseDTO {
  @SerializedName("stores")
  private List<StoreDTO> stores;

  public List<StoreDTO> getStores() {
    return stores;
  }
}
