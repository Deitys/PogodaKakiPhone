package com.hfad.vlad.pogodakakiphone.models;

import com.google.gson.annotations.SerializedName;
import com.hfad.vlad.pogodakakiphone.fiveDayDescriptions.CityDescription;
import com.hfad.vlad.pogodakakiphone.fiveDayDescriptions.ListDescription;

import java.util.List;

public class FiveDaysWeatherResponse {

    @SerializedName("cod")
    private String cod;

    @SerializedName("message")
    private double message;

    @SerializedName("cnt")
    private int cnt;

    @SerializedName("list")
    private List<ListDescription> list;

    @SerializedName("city")
    private CityDescription city;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<ListDescription> getList() {
        return list;
    }

    public void setList(List<ListDescription> list) {
        this.list = list;
    }

    public CityDescription getCity() {
        return city;
    }

    public void setCity(CityDescription city) {
        this.city = city;
    }
}
