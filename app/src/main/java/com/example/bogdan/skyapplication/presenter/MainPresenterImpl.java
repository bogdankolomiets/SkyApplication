package com.example.bogdan.skyapplication.presenter;

import com.example.bogdan.skyapplication.model.Model;
import com.example.bogdan.skyapplication.view.MainView;

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
  public void OnCityChanged(String city) {
    mModel.getCurrentWeatherByCity(city);
  }
}
