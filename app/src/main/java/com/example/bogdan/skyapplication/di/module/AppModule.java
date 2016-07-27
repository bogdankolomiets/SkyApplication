package com.example.bogdan.skyapplication.di.module;

import android.content.Context;

import com.example.bogdan.skyapplication.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
}
