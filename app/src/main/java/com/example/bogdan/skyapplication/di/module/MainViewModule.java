package com.example.bogdan.skyapplication.di.module;

import com.example.bogdan.skyapplication.di.ActivityScope;
import com.example.bogdan.skyapplication.model.Model;
import com.example.bogdan.skyapplication.presenter.MainPresenter;
import com.example.bogdan.skyapplication.presenter.MainPresenterImpl;
import com.example.bogdan.skyapplication.presenter.mapper.CityWeatherMapper;
import com.example.bogdan.skyapplication.view.main.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
@Module
public class MainViewModule {
  private MainView mView;

  public MainViewModule(MainView view) {
    mView = view;
  }

  @ActivityScope
  @Provides
  MainPresenter providePresenter(Model model, CityWeatherMapper mapper) {
    return new MainPresenterImpl(model, mView, mapper);
  }
}
