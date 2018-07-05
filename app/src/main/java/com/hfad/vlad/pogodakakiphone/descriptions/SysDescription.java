package com.hfad.vlad.pogodakakiphone.descriptions;

import com.google.gson.annotations.SerializedName;

public class SysDescription {

    @SerializedName("type")
    private double type;

    @SerializedName("id")
    private double id;

    @SerializedName("message")
    private double message;

    @SerializedName("country")
    private String country;

    @SerializedName("sunrise")
    private double sunrise;

    @SerializedName("sunset")
    private double sunset;


    public double getType() {
        return type;
    }

    public void setType(double type) {
        this.type = type;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getSunrise() {
        return sunrise;
    }

    public void setSunrise(double sunrise) {
        this.sunrise = sunrise;
    }

    public double getSunset() {
        return sunset;
    }

    public void setSunset(double sunset) {
        this.sunset = sunset;
    }
}
