package com.vvr.rest;

import com.google.gson.annotations.SerializedName;

public class PostOffice
{
    @SerializedName("Name")
    private String name;

    @SerializedName("Description")
    private String description;

    @SerializedName("BranchType")
    private String branchType;

    @SerializedName("DeliveryStatus")
    private String deliveryStatus;

    @SerializedName("Circle")
    private String circle;

    @SerializedName("District")
    private String district;

    @SerializedName("Division")
    private String Division;

    @SerializedName("Region")
    private String region;

    @SerializedName("Block")
    private String block;

    @SerializedName("State")
    private String state;

    @SerializedName("Country")
    private String country;

    @SerializedName("Pincode")
    private String pincode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBranchType() {
        return branchType;
    }

    public void setBranchType(String branchType) {
        this.branchType = branchType;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
