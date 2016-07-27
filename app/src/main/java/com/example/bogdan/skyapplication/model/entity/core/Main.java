package com.example.bogdan.skyapplication.model.entity.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public class Main {
  @SerializedName("temp")
  @Expose
  private double mTemperature;

  @SerializedName("pressure")
  @Expose
  private double mPressure;

  @SerializedName("humidity")
  @Expose
  private int mHumidity;

  public int getTemperature() {
    return (int) mTemperature;
  }

  public int getPressure() {
    return (int) mPressure;
  }

  public int getHumidity() {
    return mHumidity;
  }
}
