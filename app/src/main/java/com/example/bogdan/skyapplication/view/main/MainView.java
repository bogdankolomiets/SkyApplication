package com.example.bogdan.skyapplication.view.main;

import com.example.bogdan.skyapplication.presenter.vo.CityWeatherVO;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public interface MainView {

  void showWeatherData(CityWeatherVO weatherData);

  void startCityDetailFragment(String city);
}
