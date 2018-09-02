package com.hfad.vlad.pogodakakiphone.EventBus;


import java.util.ArrayList;

public class TempEvent {


    private ArrayList<String> allDayEvent = new ArrayList<>();
    private String checkDayEvent;
    private ArrayList<Double> maxTempEvent = new ArrayList<>();
    private ArrayList<Double> minTempEvent = new ArrayList<>();
    private String descriptionDayEvent;

    public String getDescriptionDayEvent() {
        return descriptionDayEvent;
    }

    public void setDescriptionDayEvent(String descriptionDayEvent) {
        this.descriptionDayEvent = descriptionDayEvent;
    }

    public ArrayList<String> getAllDayEvent() {
        return allDayEvent;
    }

    public void setAllDayEvent(ArrayList<String> allDayEvent) {
        this.allDayEvent = allDayEvent;
    }

    public String getCheckDayEvent() {
        return checkDayEvent;
    }

    public void setCheckDayEvent(String checkDayEvent) {
        this.checkDayEvent = checkDayEvent;
    }





    public ArrayList<Double> getMaxTempEvent() {
        return maxTempEvent;
    }

    public void setMaxTempEvent(ArrayList<Double> maxTempEvent) {
        this.maxTempEvent = maxTempEvent;
    }

    public ArrayList<Double> getMinTempEvent() {
        return minTempEvent;
    }

    public void setMinTempEvent(ArrayList<Double> minTempEvent) {
        this.minTempEvent = minTempEvent;
    }
}
