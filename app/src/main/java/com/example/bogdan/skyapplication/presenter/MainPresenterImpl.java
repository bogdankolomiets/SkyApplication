package com.example.bogdan.skyapplication.presenter;

import com.example.bogdan.skyapplication.di.ActivityScope;
import com.example.bogdan.skyapplication.model.Model;
import com.example.bogdan.skyapplication.model.entity.WeatherData;
import com.example.bogdan.skyapplication.presenter.mapper.CityWeatherMapper;
import com.example.bogdan.skyapplication.view.main.MainView;

import javax.inject.Inject;

import rx.Observer;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public class MainPresenterImpl extends BasePresenter implements MainPresenter {
  private MainView mView;
  private final CityWeatherMapper mMapper;

  @Inject
  public MainPresenterImpl(Model model, MainView view, CityWeatherMapper mapper) {
    super(model);
    mView = view;
    mMapper = mapper;
  }

  @Override
  public void onCreate() {

  }

  @Override
  public void OnSearchClick(String city) {
    mView.startCityDetailFragment(city);
  }

  private void showList() {

  }
}
