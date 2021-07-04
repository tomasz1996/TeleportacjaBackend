package com.example.backend.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TemperatureDto {
    private int temperature;

    public TemperatureDto(int temperature) {
        this.temperature = temperature;
    }
}
