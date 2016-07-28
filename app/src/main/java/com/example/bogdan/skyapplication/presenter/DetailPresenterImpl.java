package com.example.bogdan.skyapplication.presenter;

import android.os.Bundle;

import com.example.bogdan.skyapplication.model.Model;
import com.example.bogdan.skyapplication.model.entity.ForecastData;
import com.example.bogdan.skyapplication.view.detail.DetailView;

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
}
