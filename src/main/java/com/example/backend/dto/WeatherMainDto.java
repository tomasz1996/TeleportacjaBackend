package com.example.backend.dto;
import java.util.ArrayList;
import lombok.Getter;

@Getter
public class WeatherMainDto {
    private ArrayList<WeatherWeatherDto> weather;
}
