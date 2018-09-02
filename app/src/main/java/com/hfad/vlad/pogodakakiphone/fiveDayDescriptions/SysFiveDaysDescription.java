package com.hfad.vlad.pogodakakiphone.fiveDayDescriptions;

import com.google.gson.annotations.SerializedName;

public class SysFiveDaysDescription {
    @SerializedName("pod")
    private String pod;

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }
}
