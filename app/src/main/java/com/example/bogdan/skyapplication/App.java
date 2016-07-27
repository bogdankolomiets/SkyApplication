package com.example.bogdan.skyapplication;

import android.app.Application;
import android.content.Context;

import com.example.bogdan.skyapplication.di.component.AppComponent;
import com.example.bogdan.skyapplication.di.component.DaggerAppComponent;
import com.example.bogdan.skyapplication.di.module.AppModule;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public class App extends Application {
  private AppComponent mAppComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    resolveDependencies();
  }

  private void resolveDependencies() {
    mAppComponent = DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .build();
  }

  public static App get(Context context) {
    return (App) context.getApplicationContext();
  }

  public AppComponent getAppComponent() {
    return mAppComponent;
  }
}
