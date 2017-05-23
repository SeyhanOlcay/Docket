package com.ovidos.docket.network.api;

import com.ovidos.docket.models.responseModels.BaseResponseModel;
import com.ovidos.docket.models.responseModels.CategoryResponseModel;
import com.ovidos.docket.models.responseModels.CredentialResponseModel;
import com.ovidos.docket.models.responseModels.ResponseModel;
import com.ovidos.docket.models.responseModels.RssChannelResponseModel;
import com.ovidos.docket.models.responseModels.RssItemResponseModel;
import com.ovidos.docket.models.responseModels.RssItemSimpleResponseModel;
import com.ovidos.docket.models.responseModels.UserResponseModel;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by omral on 11.05.2017.
 */

public interface ApiService {

    //region Account

    @FormUrlEncoded
    @POST("token")
    Call<CredentialResponseModel> getToken(@Field("username") String username,
                                           @Field("password") String password,
                                           @Field("grant_type") String grantType);

    //endregion

    //region ApplicationUsers

    @GET("user/me")
    Call<ResponseModel<UserResponseModel>> getUser();

    @GET("users/me/categories")
    Call<ResponseModel<CategoryResponseModel>> getUserCategories();

    @POST("users/me/categories")
    Call<ResponseModel<BaseResponseModel>> addUserCategories(@Query("Id") String id);

    @DELETE("users/me/categories")
    Call<ResponseModel<BaseResponseModel>> deleteUserCategories(@Query("Id") String id);

    @GET("users/me/channels")
    Call<ResponseModel<RssChannelResponseModel>> getUserChannels();

    @POST("users/me/channels")
    Call<ResponseModel<BaseResponseModel>> addUserChannels(@Query("Id") String id);

    @DELETE("users/me/channels")
    Call<ResponseModel<BaseResponseModel>> deleteUserChannels(@Query("Id") String id);

    //endregion

    //region Categories

    @GET("categories/{categoryId}/items?page={page}&size={size}")
    Call<ResponseModel<RssItemSimpleResponseModel>> getCategoryItems(@Path("categoryId") String categoryId,
                                                                     @Path("page") int page,
                                                                     @Path("size") int size);

    @GET("categories")
    Call<ResponseModel<CategoryResponseModel>> getCategories();

    //endregion

    //region RssItems

    @GET("items/{id}")
    Call<ResponseModel<RssItemResponseModel>> getItem(@Path("id") String id);

    @GET("items/search?q={q}&page={page}&size={size}")
    Call<ResponseModel<RssItemSimpleResponseModel>> searchItems(@Path("q") String q,
                                                                @Path("page") int page,
                                                                @Path("size") int size);

    @GET("items/featured?page={page}&size={size}")
    Call<ResponseModel<RssItemSimpleResponseModel>> featuredItems(@Path("page") int page,
                                                                  @Path("size") int size);

    @GET("items/saved?page={page}&size={size}")
    Call<ResponseModel<RssItemSimpleResponseModel>> savedItems(@Path("page") int page,
                                                               @Path("size") int size);

    @POST("items/{id}/read")
    Call<ResponseModel<BaseResponseModel>> readItem(@Path("id") String id);

    @POST("items/{id}/like")
    Call<ResponseModel<BaseResponseModel>> likeItem(@Path("id") String id);

    @DELETE("items/{id}/like")
    Call<ResponseModel<BaseResponseModel>> deleteLikedItem(@Path("id") String id);

    @POST("items/{id}/unlike")
    Call<ResponseModel<BaseResponseModel>> unlikeItem(@Path("id") String id);

    @DELETE("items/{id}/unlike")
    Call<ResponseModel<BaseResponseModel>> deleteUnlikedItem(@Path("id") String id);

    @POST("items/{id}/save")
    Call<ResponseModel<BaseResponseModel>> saveItem(@Path("id") String id);

    @DELETE("items/{id}/save")
    Call<ResponseModel<BaseResponseModel>> deleteSavedItem(@Path("id") String id);

    //endregion

    //region RssChannels

    @GET("channels/{id}/items?page={page}&size={size}")
    Call<ResponseModel<RssItemResponseModel>> getChannelItems(@Path("id") String id,
                                                              @Path("page") int page,
                                                              @Path("size") int size);

    //endregion
}
