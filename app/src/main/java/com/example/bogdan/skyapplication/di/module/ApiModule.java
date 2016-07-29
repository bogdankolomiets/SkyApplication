package com.example.bogdan.skyapplication.di.module;

import android.content.Context;

import com.example.bogdan.skyapplication.App;
import com.example.bogdan.skyapplication.HttpUtils;
import com.example.bogdan.skyapplication.api.WeatherApi;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
  OkHttpClient provideOkHttpClient(App app) {
    return new OkHttpClient
        .Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .cache(new Cache(app.getCacheDir(), 10 * 1024 * 1024)) // 10 MB
        .addInterceptor(new Interceptor() {
          @Override
          public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            if (HttpUtils.isNetworkAvailable(app)) {
              request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build();
            } else {
              request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build();
            }

            return chain.proceed(request);
          }
        })
        .build();
  }

  @Singleton
  @Provides
  Retrofit provideRetrofit(GsonConverterFactory gsonConverterFactory,
                           RxJavaCallAdapterFactory rxJavaCallAdapterFactory,
                           OkHttpClient client) {
    return new Retrofit.Builder()
        .baseUrl(mBaseUrl)
        .addConverterFactory(gsonConverterFactory)
        .addCallAdapterFactory(rxJavaCallAdapterFactory)
        .client(client)
        .build();
  }

  @Singleton
  @Provides
  WeatherApi provideApiIntefrace(Retrofit retrofit) {
    return retrofit.create(WeatherApi.class);
  }
}
