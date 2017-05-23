package com.ovidos.docket.core;

import android.app.Application;

import com.ovidos.docket.network.api.ApiClient;
import com.ovidos.docket.network.api.ApiService;

/**
 * Created by omral on 11.05.2017.
 */

public class DocketApplication extends Application {
    private ApiService mApiService;

    @Override
    public void onCreate() {
        super.onCreate();
        refreshApiService();
    }

    public ApiService getApiService() {
        return mApiService;
    }

    public void setApiService(ApiService apiService) {
        mApiService = apiService;
    }

    public void refreshApiService() {
        mApiService = ApiClient.createService(this);
    }
}