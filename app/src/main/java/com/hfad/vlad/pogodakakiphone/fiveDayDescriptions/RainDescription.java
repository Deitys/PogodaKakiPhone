package com.hfad.vlad.pogodakakiphone.fiveDayDescriptions;

import com.google.gson.annotations.SerializedName;

public class RainDescription {

    @SerializedName("3h")
    private double _3h;

    public double get3h() {
        return _3h;
    }

    public void set3h(double _3h) {
        this._3h = _3h;
    }
}
