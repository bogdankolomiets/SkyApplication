package com.example.bogdan.skyapplication.model;

import com.example.bogdan.skyapplication.Constants;
import com.example.bogdan.skyapplication.api.WeatherApi;
import com.example.bogdan.skyapplication.model.entity.ForecastData;
import com.example.bogdan.skyapplication.model.entity.WeatherData;

import javax.inject.Inject;

import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public class ModelImpl implements Model {
  private final Observable.Transformer mSchedulerTransformer;
  private final WeatherApi mApiInterface;

  @Inject
  public ModelImpl(Observable.Transformer schedulerTransformer, WeatherApi apiInterface) {
    mSchedulerTransformer = schedulerTransformer;
    mApiInterface = apiInterface;
  }

  @Override
  public Observable<WeatherData> getCurrentWeatherByCity(String city) {
    return mApiInterface
        .currentWeatherByCity(city, Constants.HTTP.UNITS, "ru", Constants.HTTP.APPID)
        .compose(applySchedulers());

  }

  @Override
  public Observable<ForecastData> getWeekForecastByCity(String city) {
    return mApiInterface
        .weekForecastByCity(city, Constants.HTTP.UNITS, "ru", Constants.HTTP.APPID)
        .compose(applySchedulers());
  }

  @SuppressWarnings("unchecked")
  private <T> Observable.Transformer<T, T> applySchedulers() {
    return (Observable.Transformer<T, T>) mSchedulerTransformer;
  }
}
