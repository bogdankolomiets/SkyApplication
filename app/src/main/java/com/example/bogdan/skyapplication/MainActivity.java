package com.example.bogdan.skyapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.bogdan.skyapplication.model.entity.WeatherData;
import com.example.bogdan.skyapplication.view.MainView;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public class MainActivity extends AppCompatActivity implements MainView {
  private static final int LAYOUT = R.layout.main_layout;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_layout);
  }

  @Override
  public void showWeatherData(WeatherData weatherData) {

  }
}
