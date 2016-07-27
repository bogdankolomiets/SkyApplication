package com.example.bogdan.skyapplication.di.module;

import android.content.Context;

import com.example.bogdan.skyapplication.App;
import com.example.bogdan.skyapplication.CityDataHelper;
import com.example.bogdan.skyapplication.api.WeatherApi;
import com.example.bogdan.skyapplication.model.Model;
import com.example.bogdan.skyapplication.model.ModelImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
@Module
public class AppModule {
  private App mApplication;

  public AppModule(App application) {
    mApplication = application;
  }

  @Singleton
  @Provides
  Context provideApplication() {
    return mApplication;
  }

  @Singleton
  @Provides
  Observable.Transformer provideSchedulerTransformer() {
    return o -> ((Observable) o).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .unsubscribeOn(Schedulers.io());
  }

  @Singleton
  @Provides
  CityDataHelper provideCityDataHelper(App application) {
    return new CityDataHelper(application);
  }

  @Singleton
  @Provides
  Model provideModel(Observable.Transformer schedulerTransformer, WeatherApi api) {
    return new ModelImpl(schedulerTransformer, api);
  }
}
