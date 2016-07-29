package com.example.bogdan.skyapplication.ui.detail.presenter;

import android.view.Menu;

import com.example.bogdan.skyapplication.model.Model;
import com.example.bogdan.skyapplication.model.entity.ForecastData;
import com.example.bogdan.skyapplication.model.entity.WeatherData;
import com.example.bogdan.skyapplication.ui.common.BasePresenter;
import com.example.bogdan.skyapplication.ui.detail.view.DetailView;

import javax.inject.Inject;

import rx.Observer;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 28.07.16
 */
public class DetailPresenterImpl extends BasePresenter implements DetailPresenter {
  private DetailView mView;
  private String mCity;

  @Inject
  public DetailPresenterImpl(Model model, DetailView view) {
    super(model);
    mView = view;
  }

  @Override
  public void onCreate(String city) {
    mCity = city;
    getCurrentWeather(city);
    mModel
        .getWeekForecastByCity(city)
        .subscribe(new Observer<ForecastData>() {
          @Override
          public void onCompleted() {

          }

          @Override
          public void onError(Throwable e) {
            e.printStackTrace();
          }

          @Override
          public void onNext(ForecastData forecastData) {
            mView.showForecast(forecastData);
          }
        });
  }

  @Override
  public void onAddClick(String city) {
    mModel.addCity(city);
  }

  @Override
  public void onCreateOptionsMenu(Menu menu) {
    if (mModel.hasCity(mCity)) {
      mView.hideAddBtn(menu);
    }
  }

  private void getCurrentWeather(String city) {
    mModel.getCurrentWeatherByCity(city)
        .subscribe(new Observer<WeatherData>() {
          @Override
          public void onCompleted() {

          }

          @Override
          public void onError(Throwable e) {

          }

          @Override
          public void onNext(WeatherData data) {
            mView.showCurrentWeather(data);
          }
        });
  }
}
