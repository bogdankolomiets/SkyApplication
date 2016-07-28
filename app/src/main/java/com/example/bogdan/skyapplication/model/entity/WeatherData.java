package com.example.bogdan.skyapplication.model.entity;

import com.example.bogdan.skyapplication.model.entity.core.Main;
import com.example.bogdan.skyapplication.model.entity.core.Weather;
import com.example.bogdan.skyapplication.model.entity.core.Wind;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public class WeatherData {
  @SerializedName("dt_txt")
  @Expose
  private String mDateTxt;

  @SerializedName("dt")
  @Expose
  private long mDate;

  @SerializedName("id")
  @Expose
  private int mCityId;

  @SerializedName("name")
  @Expose
  private String mCityName;

  @SerializedName("weather")
  @Expose
  private List<Weather> mWeatherData;

  @SerializedName("main")
  @Expose
  private Main mMainData;

  @SerializedName("wind")
  @Expose
  private Wind mWindData;

  public String getWeatherDescription() {
    return mWeatherData.get(0).getDescription();
  }

  public int getTemperature() {
    return mMainData.getTemperature();
  }

  public int getPressure() {
    return mMainData.getPressure();
  }

  public int getHumidity() {
    return mMainData.getHumidity();
  }

  public double getWindSpeed() {
    return mWindData.getSpeed();
  }

  public String getIcon() {
    return mWeatherData.get(0).getIcon();
  }

  public String getCityName() {
    return mCityName;
  }

  public long getData() {
    return mDate;
  }

  public String getDateTxt() {
    return mDateTxt;
  }
}
