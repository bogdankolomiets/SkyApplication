package com.example.bogdan.skyapplication.model.entity;

import com.example.bogdan.skyapplication.model.entity.core.City;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public class ForecastData {
  @SerializedName("city")
  @Expose
  private City mCity;

  @SerializedName("list")
  @Expose
  private List<WeatherData> mData;

  public String getCity() {
    return mCity.getName();
  }

  public List<WeatherData> getData() {
    return mData;
  }

}
