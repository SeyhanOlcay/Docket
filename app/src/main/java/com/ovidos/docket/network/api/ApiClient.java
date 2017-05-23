package com.ovidos.docket.network.api;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ovidos.docket.BuildConfig;
import com.ovidos.docket.models.responseModels.ResponseModel;
import com.ovidos.docket.network.adapters.GsonUTCDateAdapter;
import com.ovidos.docket.utils.Prefs;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by omral on 11.05.2017.
 */

public class ApiClient {
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Gson gson = new GsonBuilder().
            registerTypeAdapter(Date.class, new GsonUTCDateAdapter())
            .create();

    private static GsonConverterFactory converterFactory = GsonConverterFactory.create(gson);

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(converterFactory);

    public static Converter<ResponseBody, ResponseModel> bodyConverter;

    public static ApiService createService(final Context context) {

        final String authToken = Prefs.getToken(context);
        httpClient.interceptors().clear();
        if (authToken != null) {
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Authorization", "Bearer " + authToken)
                            .method(original.method(), original.body());
                    Request request = requestBuilder.build();

                    Response response = chain.proceed(request);
                    if (!response.isSuccessful() && response.code() == 401) {
                        new Handler(Looper.getMainLooper())
                                .post(new Runnable() {
                                    @Override
                                    public void run() {
                                    }
                                });
                    }
                    return  response;
                }
            });
        }

        OkHttpClient client = httpClient.writeTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)
                .build();
        Retrofit retrofit = builder
                .client(client)
                .build();

        bodyConverter = retrofit.responseBodyConverter(ResponseModel.class, new Annotation[0]);

        return retrofit.create(ApiService.class);
    }
}
