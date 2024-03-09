package com.nidaonder.weatherapi.controller;

import com.nidaonder.weatherapi.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/weather")
@Slf4j
@RequiredArgsConstructor
public class WeatherController {

    //TODO disable H2 db@@@@@@@@@@@@@@@@@@@@@@@@@@@
    private final WeatherService weatherService;

    @GetMapping("/daily/{city}")
    public ResponseEntity<JSONObject> getDailyWeather(@PathVariable String city){
        return weatherService.getDailyWeather(city);
    }

    @GetMapping("/weekly/{city}")
    public ResponseEntity<JSONObject> getWeeklyWeather(@PathVariable String city){
        return weatherService.getWeeklyWeather(city);
    }

    @GetMapping("/monthly/{city}")
    public ResponseEntity<JSONObject> getMonthlyWeather(@PathVariable String city){
        return weatherService.getMonthlyWeather(city);
    }

}
