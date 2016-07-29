package com.example.bogdan.skyapplication.ui.detail.view;

import android.view.Menu;

import com.example.bogdan.skyapplication.model.entity.ForecastData;
import com.example.bogdan.skyapplication.model.entity.WeatherData;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public interface DetailView {

  void showForecast(ForecastData data);

  void showCurrentWeather(WeatherData data);

  void hideAddBtn(Menu menu);
}
