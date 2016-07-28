package com.example.bogdan.skyapplication.di.module;

import com.example.bogdan.skyapplication.di.ActivityScope;
import com.example.bogdan.skyapplication.model.Model;
import com.example.bogdan.skyapplication.presenter.DetailPresenter;
import com.example.bogdan.skyapplication.presenter.DetailPresenterImpl;
import com.example.bogdan.skyapplication.view.detail.DetailView;

import dagger.Module;
import dagger.Provides;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 28.07.16
 */
@Module
public class DetailViewModule {
  private DetailView mView;

  public DetailViewModule(DetailView view) {
    mView = view;
  }

  @ActivityScope
  @Provides
  DetailPresenter providePresenter(Model model) {
    return new DetailPresenterImpl(model, mView);
  }
}
