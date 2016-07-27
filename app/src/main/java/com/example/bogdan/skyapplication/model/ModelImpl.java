package com.example.bogdan.skyapplication.model;

import com.example.bogdan.skyapplication.model.entity.ForecastData;
import com.example.bogdan.skyapplication.model.entity.WeatherData;

import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public class ModelImpl implements Model {

  @Override
  public Observable<WeatherData> getCurrentWeatherByCity(String city) {
    return null;
  }

  @Override
  public Observable<ForecastData> getWeekForecastByCity(String city) {
    return null;
  }
}
