package com.example.backend.controller;

import com.example.backend.APIpojo.Data;
//import com.example.backend.Temperature;
import com.example.backend.dto.WeatherMainDto;
import com.example.backend.model.FrontendDto;
import com.example.backend.model.TemperatureDiff;
import com.example.backend.service.WeatherService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @PostMapping("/api/temp/calculate")
    //change return to object WeatherDto
    @JsonIgnoreProperties(ignoreUnknown = true)
    public TemperatureDiff getTemperature(@RequestBody FrontendDto data) {
        System.out.println("data is: "+ data);

        //Use WeatherMainDto Pojo to assign
        WeatherMainDto WeatherMainDto1 = weatherService.getWeather(data.getCity1(), data.getDate(), WeatherMainDto.class);
        WeatherMainDto WeatherMainDto2 = weatherService.getWeather(data.getCity2(), data.getDate(),  WeatherMainDto.class);

        RestTemplate restTemplate = new RestTemplate();
        String result1  = restTemplate.getForObject("http://api.worldweatheronline.com/premium/v1/past-weather.ashx?key=7941acf170584bbe89982258212806&q="
                +data.getCity1()+"&format=json&date="+data.getDate(), String.class);

        String result2 = restTemplate.getForObject("http://api.worldweatheronline.com/premium/v1/past-weather.ashx?key=7941acf170584bbe89982258212806&q="
                +data.getCity2()+"&format=json&date="+data.getDate(), String.class);

//        Data myData = new ObjectMapper().readValue(result1, Data.class);
//        System.out.println(myData.getWeather());


//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        Data langs = objectMapper.readValue(result1, Data.class);
//        System.out.println(langs.getWeather());

//        WeatherDto obiekt1 = WeatherDto.builder().weather(weatherMainDto)
//                build();

//  -----------------cheating method (using the String response)--------------
       int tempDiff;
        if(findTemp(result1) == -999 || findTemp(result2) == -999){
            tempDiff = -999;
        }else{
            tempDiff= findTemp(result1) -  findTemp(result2);
        }
        return new TemperatureDiff(tempDiff);
    }

    public static int findTemp(String result){
        int tempNumber = -999;
        int avgIndex = result.indexOf("avgtempC");

        if(avgIndex == -1) return tempNumber;

        if(result.charAt(avgIndex + 12) == '\"'){
            tempNumber = Integer.parseInt(result.substring(avgIndex+11,avgIndex+12));
        }else if (result.charAt(avgIndex + 13) == '\"'){
            tempNumber = Integer.parseInt(result.substring(avgIndex+11,avgIndex+13));
        }else if(result.charAt(avgIndex + 14) == '\"'){
            tempNumber = Integer.parseInt(result.substring(avgIndex+11,avgIndex+14));
        }else{
            return -999;
        }
        return tempNumber;
    }
}















//        int tempDiff;
//        if(findTemp(result1) == -999 || findTemp(result2) == -999){
//            tempDiff = -999;
//        }else{
//            tempDiff= findTemp(result1) -  findTemp(result2);
//        }
//        return new Temperature(tempDiff);
//    }
//
//    public static int findTemp(String result){
//        int tempNumber = -999;
//        int avgIndex = result.indexOf("avgtempC");
//
//        if(avgIndex == -1) {
//            return tempNumber;
//        }
//
//        if(result.charAt(avgIndex + 12) == '\"'){
//            tempNumber = Integer.parseInt(result.substring(avgIndex+11,avgIndex+12));
//        }else if (result.charAt(avgIndex + 13) == '\"'){
//            tempNumber = Integer.parseInt(result.substring(avgIndex+11,avgIndex+13));
//        }else if(result.charAt(avgIndex + 14) == '\"'){
//            tempNumber = Integer.parseInt(result.substring(avgIndex+11,avgIndex+14));
//        }else{
//            return -999;
//        }
//        return tempNumber;