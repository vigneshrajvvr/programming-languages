package com.vvr.rest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PinCode {
    @SerializedName("Message")
    private String message;

    @SerializedName("Status")
    private String status;

    @SerializedName("PostOffice")
    private List<PostOffice> postOffices;

    public PinCode() {
    }

    public PinCode(String message, String status, List<PostOffice> postOffices) {
        this.message = message;
        this.status = status;
        this.postOffices = postOffices;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PostOffice> getPostOffices() {
        return postOffices;
    }

    public void setPostOffices(List<PostOffice> postOffices) {
        this.postOffices = postOffices;
    }
}
