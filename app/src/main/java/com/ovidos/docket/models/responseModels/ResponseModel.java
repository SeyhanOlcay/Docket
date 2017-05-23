package com.ovidos.docket.models.responseModels;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by omral on 11.05.2017.
 */

public class ResponseModel<T> {

    @SerializedName("Status")
    private String status;

    @SerializedName("Message")
    private String message;

    @SerializedName("ErrorCode")
    private int errorCode;

    @SerializedName("Data")
    private T data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public @NonNull
    String getMessage() {
        if (message == null) {
            return "Unknown Error";
        }
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public boolean isSuccessfully() {
        return status != null && status.equals("OK");
    }
}
