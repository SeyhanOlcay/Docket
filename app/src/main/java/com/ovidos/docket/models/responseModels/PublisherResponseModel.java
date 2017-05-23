package com.ovidos.docket.models.responseModels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by omral on 18.05.2017.
 */

public class PublisherResponseModel extends BaseResponseModel {
    @SerializedName("Name")
    private String name;
    @SerializedName("LogoUrl")
    private String logoUrl;

    public PublisherResponseModel(String name, String logoUrl) {
        this.name = name;
        this.logoUrl = logoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
