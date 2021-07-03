package com.example.backend.model;

public class TemperatureDiff {
    private int temperature;

    public TemperatureDiff(int temperature){
        this.temperature = temperature;
    }
    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
