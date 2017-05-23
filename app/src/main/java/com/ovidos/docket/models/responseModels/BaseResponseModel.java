package com.ovidos.docket.models.responseModels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by omral on 18.05.2017.
 */

public class BaseResponseModel {
    @SerializedName("Id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
