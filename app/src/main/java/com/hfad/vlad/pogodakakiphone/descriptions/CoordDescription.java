package com.hfad.vlad.pogodakakiphone.descriptions;

import com.google.gson.annotations.SerializedName;


public class CoordDescription {

    @SerializedName("lat")
    private double lat;

    @SerializedName("lon")
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
