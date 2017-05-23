package com.ovidos.docket.models.responseModels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by omral on 18.05.2017.
 */

public class RssChannelResponseModel extends BaseResponseModel {
    @SerializedName("Name")
    private String name;
    @SerializedName("Publisher")
    private PublisherResponseModel publisher;

    public RssChannelResponseModel(String name, PublisherResponseModel publisher) {
        this.name = name;
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PublisherResponseModel getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherResponseModel publisher) {
        this.publisher = publisher;
    }
}
