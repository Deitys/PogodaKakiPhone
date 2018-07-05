package com.hfad.vlad.pogodakakiphone;

import com.google.gson.annotations.SerializedName;
import com.hfad.vlad.pogodakakiphone.descriptions.CloudsDescription;
import com.hfad.vlad.pogodakakiphone.descriptions.CoordDescription;
import com.hfad.vlad.pogodakakiphone.descriptions.MainDescription;
import com.hfad.vlad.pogodakakiphone.descriptions.SysDescription;
import com.hfad.vlad.pogodakakiphone.descriptions.WeatherDescription;
import com.hfad.vlad.pogodakakiphone.descriptions.WindDescription;

import java.util.List;

public class CurrentWeatherResponse {

    @SerializedName("coord")
    private List<CoordDescription> coord;

    @SerializedName("weather")
    private List<WeatherDescription> weather;

    @SerializedName("base")
    private String base;

    @SerializedName("main")
    private List<MainDescription> main;

    @SerializedName("visibility")
    private long visibility;

    @SerializedName("wind")
    private List<WindDescription> wind;

    @SerializedName("clouds")
    private List<CloudsDescription> clouds;

    @SerializedName("dt")
    private long dt;

    @SerializedName("sys")
    private List<SysDescription> sys;

    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("cod")
    private long cod;

    public List<CoordDescription> getCoord() {
        return coord;
    }

    public void setCoord(List<CoordDescription> coord) {
        this.coord = coord;
    }

    public List<WeatherDescription> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDescription> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public List<MainDescription> getMain() {
        return main;
    }

    public void setMain(List<MainDescription> main) {
        this.main = main;
    }

    public long getVisibility() {
        return visibility;
    }

    public void setVisibility(long visibility) {
        this.visibility = visibility;
    }

    public List<WindDescription> getWind() {
        return wind;
    }

    public void setWind(List<WindDescription> wind) {
        this.wind = wind;
    }

    public List<CloudsDescription> getClouds() {
        return clouds;
    }

    public void setClouds(List<CloudsDescription> clouds) {
        this.clouds = clouds;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public List<SysDescription> getSys() {
        return sys;
    }

    public void setSys(List<SysDescription> sys) {
        this.sys = sys;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }
}
