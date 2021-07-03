package com.example.backend.service;

import com.example.backend.model.FrontendDto;
import com.example.backend.model.TemperatureDiff;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@Service
@CrossOrigin(origins = "http://localhost:4200")
public class WeatherService {
    private static final String API_KEY = "7941acf170584bbe89982258212806";
    private static int tempDiff;
    RestTemplate restTemplate = new RestTemplate();

    //Using generic [T]ype
    public <T> T getWeather(String city, String date, Class<T> responseType){

        return restTemplate
                .getForObject("http://api.worldweatheronline.com/premium/v1/past-weather.ashx?key="+API_KEY+"&q="
                        +city+"&format=json&date="+date, responseType);


//        System.out.println(result);
//        return tempDiff;
    }
}
