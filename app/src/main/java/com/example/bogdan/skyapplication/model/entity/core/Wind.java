package com.example.bogdan.skyapplication.model.entity.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public class Wind {
  @SerializedName("speed")
  @Expose
  private double mSpeed;

  public double getSpeed() {
    return mSpeed;
  }
}
