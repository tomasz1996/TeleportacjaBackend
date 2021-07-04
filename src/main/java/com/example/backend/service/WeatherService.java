package com.example.backend.service;

import com.example.backend.dto.WeatherDto;
import com.example.backend.model.FrontendDto;
import com.example.backend.model.TemperatureDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class WeatherService {

    private static final String URL ="http://api.worldweatheronline.com/premium/v1/past-weather.ashx";
    private static final String API_KEY ="7941acf170584bbe89982258212806";

    private static int tempDiff;
    private RestTemplate restTemplate = new RestTemplate();

    public TemperatureDto getWeather(FrontendDto data) {
        String url1 = URL + "?key=" + API_KEY + "&q=" + data.getCity1() + "&format=json&date=" + data.getDate();
        WeatherDto response1 = restTemplate.getForObject(url1, WeatherDto.class
        );

        String url2 = URL + "?key=" + API_KEY + "&q=" + data.getCity2() + "&format=json&date=" + data.getDate();
        WeatherDto response2 = restTemplate.getForObject(url2, WeatherDto.class
        );

        try{
            TemperatureDto tempObject1;
            tempObject1 = TemperatureDto.builder()
                    .temperature(response1.getData().getWeather().get(0).getAvgtempC()
                            - response2.getData().getWeather().get(0).getAvgtempC())
                    .build();

            return tempObject1;
        }catch(NullPointerException e){
            return new TemperatureDto(-999);
        }

    }
}
