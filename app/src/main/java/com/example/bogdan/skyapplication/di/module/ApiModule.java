package com.example.bogdan.skyapplication.di.module;

import com.example.bogdan.skyapplication.api.WeatherApi;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
@Module
public class ApiModule {
  private String mBaseUrl;

  public ApiModule(String baseUrl) {
    mBaseUrl = baseUrl;
  }

  @Singleton
  @Provides
  GsonConverterFactory provideConverterFactory() {
    return GsonConverterFactory.create();
  }

  @Singleton
  @Provides
  RxJavaCallAdapterFactory provideAdapterFactory() {
    return RxJavaCallAdapterFactory.create();
  }

  @Singleton
  @Provides
  Retrofit provideRetrofit(GsonConverterFactory gsonConverterFactory,
                           RxJavaCallAdapterFactory rxJavaCallAdapterFactory) {
    return new Retrofit.Builder()
        .baseUrl(mBaseUrl)
        .addConverterFactory(gsonConverterFactory)
        .addCallAdapterFactory(rxJavaCallAdapterFactory)
        .build();
  }

  @Singleton
  @Provides
  WeatherApi provideApiIntefrace(Retrofit retrofit) {
    return retrofit.create(WeatherApi.class);
  }
}
