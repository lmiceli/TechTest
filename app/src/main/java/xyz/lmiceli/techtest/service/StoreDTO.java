package xyz.lmiceli.techtest.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class StoreDTO implements Parcelable {
  @SerializedName("id")
  private Long id;

  // ISO-369-1 country code
  // ---- Info is FALSE, follows ISO 3166-1
  @SerializedName("countryCode")
  private String countryCode;

  // Name of the country
  @SerializedName("countryName")
  private String countryName;

  // Value of DOMAIN_NAME configuration
  @SerializedName("hostname")
  private String hostName;

  /*@SerializedName("continent")
  private Continent continent;
*/
  @SerializedName("isNew")
  private Boolean isNew;

  // If false, the client should show the stores categories and products, but do not allow the user
  // to put products from the store in the shopping cart
  @SerializedName("isOpenForSale")
  private Boolean isOpenForSale;

  // Indicates the type for the store.
  /*@SerializedName("type")
  private StoreType type;
*/
  // The store supported languages. The first language in the supportedLanguages array is the
  // default language.
  /*@SerializedName("supportedLanguages")
  private List<LanguageDTO> supportedLanguages;
*/
  @SerializedName("directory")
  private String directory;

  // The catalogs associated to this store
  /*@SerializedName("catalogs")
  private List<CatalogDTO> catalogs;
*/
  /*@SerializedName("details")
  private StoreDetailsDTO storeDetails;
*/
  @SerializedName("imageBaseUrl")
  private String imageBaseUrl;

  @SerializedName("ffmcenter")
  private Long ffmcenter;

  /*@SerializedName("configurations")
  List<ConfigurationDTO> configurations;
*/
  public Long getId() {
    return id;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public String getCountryName() {
    return countryName;
  }

  public String getHostName() {
    return hostName;
  }

  //public Continent getContinent() {
  //  return continent;
  //}

  public Boolean getNew() {
    return isNew;
  }

  public Boolean getOpenForSale() {
    return isOpenForSale;
  }

  //public StoreType getType() {
  //  return type;
  //}

  //public List<LanguageDTO> getSupportedLanguages() {
  //  return supportedLanguages;
  //}

  public String getDirectory() {
    return directory;
  }

  //public List<CatalogDTO> getCatalogs() {
  //  return catalogs;
  //}
  //
  //public StoreDetailsDTO getStoreDetails() {
  //  return storeDetails;
  //}

  public void setId(Long id) {
    this.id = id;
  }

  //public List<ConfigurationDTO> getConfigurations() {
  //  return configurations;
  //}
  //
  //public void setConfigurations(
  //    List<ConfigurationDTO> configurations) {
  //  this.configurations = configurations;
  //}
  //
  //public void setSupportedLanguages(
  //    List<LanguageDTO> supportedLanguages) {
  //  this.supportedLanguages = supportedLanguages;
  //}

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getImageBaseUrl() {
    return imageBaseUrl;
  }

  public StoreDTO() {
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeValue(this.id);
    dest.writeString(this.countryCode);
    //dest.writeTypedList(this.supportedLanguages);
  }

  protected StoreDTO(Parcel in) {
    this.id = (Long) in.readValue(Long.class.getClassLoader());
    this.countryCode = in.readString();
    //this.supportedLanguages = in.createTypedArrayList(LanguageDTO.CREATOR);
  }

  public static final Creator<StoreDTO> CREATOR = new Creator<StoreDTO>() {
    @Override
    public StoreDTO createFromParcel(Parcel source) {
      return new StoreDTO(source);
    }

    @Override
    public StoreDTO[] newArray(int size) {
      return new StoreDTO[size];
    }
  };

  public Long getFfmcenter() {
    return ffmcenter;
  }

  public void setFfmcenter(Long ffmcenter) {
    this.ffmcenter = ffmcenter;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }
}
