package com.example.backend.APIpojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    private String date;
    private List<Astronomy> astronomy;
    private String maxtempC;
    private String maxtempf;
    private String mintempC;
    private String mintempF;
    private String avgtempc;
    private String avgtempF;
    private String totalSnow_cm;
    private String sunHour;
    private String uvIndex;
    private List<Hourly> hourly;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Astronomy> getAstronomy() {
        return astronomy;
    }

    public void setAstronomy(List<Astronomy> astronomy) {
        this.astronomy = astronomy;
    }

    public String getMaxtempC() {
        return maxtempC;
    }

    public void setMaxtempC(String maxtempC) {
        this.maxtempC = maxtempC;
    }

    public String getMaxtempf() {
        return maxtempf;
    }

    public void setMaxtempf(String maxtempf) {
        this.maxtempf = maxtempf;
    }

    public String getMintempC() {
        return mintempC;
    }

    public void setMintempC(String mintempC) {
        this.mintempC = mintempC;
    }

    public String getMintempF() {
        return mintempF;
    }

    public void setMintempF(String mintempF) {
        this.mintempF = mintempF;
    }

    public String getAvgtempc() {
        return avgtempc;
    }

    public void setAvgtempc(String avgtempc) {
        this.avgtempc = avgtempc;
    }

    public String getAvgtempF() {
        return avgtempF;
    }

    public void setAvgtempF(String avgtempF) {
        this.avgtempF = avgtempF;
    }

    public String getTotalSnow_cm() {
        return totalSnow_cm;
    }

    public void setTotalSnow_cm(String totalSnow_cm) {
        this.totalSnow_cm = totalSnow_cm;
    }

    public String getSunHour() {
        return sunHour;
    }

    public void setSunHour(String sunHour) {
        this.sunHour = sunHour;
    }

    public String getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(String uvIndex) {
        this.uvIndex = uvIndex;
    }

    public List<Hourly> getHourly() {
        return hourly;
    }

    public void setHourly(List<Hourly> hourly) {
        this.hourly = hourly;
    }
}
