package com.ovidos.docket.models.responseModels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by omral on 18.05.2017.
 */

public class CategoryResponseModel extends BaseResponseModel {

    @SerializedName("Name")
    public String name;

    public CategoryResponseModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
