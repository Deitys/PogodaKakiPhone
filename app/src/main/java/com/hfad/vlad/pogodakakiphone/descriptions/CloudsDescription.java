package com.hfad.vlad.pogodakakiphone.descriptions;

import com.google.gson.annotations.SerializedName;

public class CloudsDescription {

    @SerializedName("all")
    private double all;


    public double getAll() {
        return all;
    }

    public void setAll(double all) {
        this.all = all;
    }
}
