package com.hfad.vlad.pogodakakiphone.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityResponse {

    @SerializedName("lat") //широта
    private double lat;

    @SerializedName("lon") //долгота
    private double lon;


    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }




}
