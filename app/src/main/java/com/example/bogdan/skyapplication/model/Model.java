package com.example.bogdan.skyapplication.model;

import com.example.bogdan.skyapplication.model.entity.WeatherData;

import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public interface Model {

  Observable<WeatherData> getCurrentWeatherByCity(String city);

  Observable<WeatherData> getWeekForecastByCity(String city);
}
