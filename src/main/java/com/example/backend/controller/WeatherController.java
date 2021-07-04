package com.example.backend.controller;

//import com.example.backend.Temperature;
import com.example.backend.model.FrontendDto;
import com.example.backend.model.TemperatureDto;
import com.example.backend.service.WeatherService;
        import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class WeatherController {

    @Autowired
    WeatherService service;


    @PostMapping("/api/temp/calculate")
    public TemperatureDto getTemperature(@RequestBody FrontendDto data) {
        return service.getWeather(data);
    }

}





//  -----------------cheating method (using the String response)--------------
//       int tempDiff;
//        if(findTemp(result1) == -999 || findTemp(result2) == -999){
//            tempDiff = -999;
//        }else{
//            tempDiff= findTemp(result1) -  findTemp(result2);
//        }
//        return new TemperatureDiff(tempDiff);
//    }
//
//    public static int findTemp(String result){
//        int tempNumber = -999;
//        int avgIndex = result.indexOf("avgtempC");
//
//        if(avgIndex == -1) return tempNumber;
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
//    }
//}
