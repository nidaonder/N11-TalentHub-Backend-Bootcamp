package com.nidaonder.weatherapi.service;

import com.nidaonder.weatherapi.exception.ErrorMessage;
import com.nidaonder.weatherapi.exception.DataParseException;
import com.nidaonder.weatherapi.exception.NoMatchFoundException;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class WeatherService {

    @Value("${weather-api.api.key}")
    private String API_KEY;

    @Value("${weather-api.base.url}")
    private String BASE_URL;

    private final RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<JSONObject> getDailyWeather(String city){
        String url = BASE_URL + "/forecast.json" + "?key=" + API_KEY + "&q=" + city + "&days=1&aqi=no&alerts=no";
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(response.getBody());
            return ResponseEntity.ok().body(json);
        } catch (HttpClientErrorException e) {
            throw new NoMatchFoundException(ErrorMessage.NO_MATCH_FOUND);
        } catch (ParseException e) {
            throw new DataParseException(ErrorMessage.INVALID_JSON_FORMAT);
        }
    }

    public ResponseEntity<JSONObject> getWeeklyWeather(String city){
        String url = BASE_URL + "/forecast.json" + "?key=" + API_KEY + "&q=" + city + "&days=7&aqi=no&alerts=no";
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(response.getBody());
            return ResponseEntity.ok().body(json);
        } catch (HttpClientErrorException e) {
            throw new NoMatchFoundException(ErrorMessage.NO_MATCH_FOUND);
        } catch (ParseException e) {
            throw new DataParseException(ErrorMessage.INVALID_JSON_FORMAT);
        }

    }

    public ResponseEntity<JSONObject> getMonthlyWeather(String city){
        String url = BASE_URL + "/future.json" + "?key=" + API_KEY + "&q=" + city + "&dt=" + LocalDate.now().plusMonths(1);
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(response.getBody());
            return ResponseEntity.ok().body(json);
        } catch (HttpClientErrorException e) {
            throw new NoMatchFoundException(ErrorMessage.NO_MATCH_FOUND);
        } catch (ParseException e) {
            throw new DataParseException(ErrorMessage.INVALID_JSON_FORMAT);
        }
    }
}
