package com.example.bogdan.skyapplication.model;

import com.example.bogdan.skyapplication.model.entity.ForecastData;
import com.example.bogdan.skyapplication.model.entity.WeatherData;

import java.util.List;

import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public interface Model {

  Observable<WeatherData> getCurrentWeatherByCity(String city);

  Observable<ForecastData> getWeekForecastByCity(String city);

  Observable<List<String>> getCities();

  void addCity(String city);

  boolean hasCity(String city);
}
