package com.hfad.vlad.pogodakakiphone.fiveDayDescriptions;

import com.google.gson.annotations.SerializedName;
import com.hfad.vlad.pogodakakiphone.descriptions.CloudsDescription;
import com.hfad.vlad.pogodakakiphone.descriptions.WeatherDescription;

import java.util.List;

public class ListDescription {
    @SerializedName("dt")
    private long dt;

    @SerializedName("main")
    private MainFiveDaysDescription main;

    @SerializedName("weather")
    private List<WeatherDescription> weather;

    @SerializedName("clouds")
    private CloudsDescription clouds;

    @SerializedName("wind")
    private WindDescription wind;

    @SerializedName("sys")
    private SysFiveDaysDescription sys;

    @SerializedName("dt_txt")
    private String dtTxt;

    @SerializedName("rain")
    private RainDescription rain;

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public MainFiveDaysDescription getMain() {
        return main;
    }

    public void setMain(MainFiveDaysDescription main) {
        this.main = main;
    }

    public List<WeatherDescription> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDescription> weather) {
        this.weather = weather;
    }

    public CloudsDescription getClouds() {
        return clouds;
    }

    public void setClouds(CloudsDescription clouds) {
        this.clouds = clouds;
    }

    public WindDescription getWind() {
        return wind;
    }

    public void setWind(WindDescription wind) {
        this.wind = wind;
    }

    public SysFiveDaysDescription getSys() {
        return sys;
    }

    public void setSys(SysFiveDaysDescription sys) {
        this.sys = sys;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

    public RainDescription getRain() {
        return rain;
    }

    public void setRain(RainDescription rain) {
        this.rain = rain;
    }
}
