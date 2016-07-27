package com.example.bogdan.skyapplication.presenter;

import com.example.bogdan.skyapplication.model.Model;
import com.example.bogdan.skyapplication.model.entity.WeatherData;
import com.example.bogdan.skyapplication.view.MainView;

import rx.Observer;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public class MainPresenterImpl extends BasePresenter implements MainPresenter {
  private MainView mView;

  public MainPresenterImpl(Model model, MainView view) {
    super(model);
    mView = view;
  }

  @Override
  public void onCreate() {

  }

  @Override
  public void OnSearchClick(String city) {
    mModel
        .getCurrentWeatherByCity(city)
        .subscribe(new Observer<WeatherData>() {
          @Override
          public void onCompleted() {

          }

          @Override
          public void onError(Throwable e) {
            e.printStackTrace();
          }

          @Override
          public void onNext(WeatherData weatherData) {
            mView.showWeatherData(weatherData);
          }
        });
  }
}
