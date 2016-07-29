package com.example.bogdan.skyapplication.ui.main.presenter.mapper;

import com.example.bogdan.skyapplication.di.ActivityScope;
import com.example.bogdan.skyapplication.ui.main.vo.CityWeatherVO;
import com.example.bogdan.skyapplication.model.entity.WeatherData;

import javax.inject.Inject;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
@ActivityScope
public class CityWeatherMapper {

  @Inject
  public CityWeatherMapper() {

  }

  public CityWeatherVO transform(WeatherData weatherData) {
    if (weatherData == null) {
      return null;
    }

    CityWeatherVO vo = new CityWeatherVO(
        weatherData.getIcon(),
        weatherData.getCityName(),
        weatherData.getWeatherDescription(),
        weatherData.getTemperature()
    );

    return vo;
  }
}
