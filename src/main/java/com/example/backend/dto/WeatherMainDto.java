package com.example.backend.dto;

import com.example.backend.APIpojo.Astronomy;
import com.example.backend.APIpojo.Data;

import java.util.List;
//import lombok.Getter;

//@Getter
public class WeatherMainDto {

//    private static WeatherWeatherDto data;
    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
