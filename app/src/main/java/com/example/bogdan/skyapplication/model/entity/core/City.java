package com.example.bogdan.skyapplication.model.entity.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public class City {
  @SerializedName("id")
  @Expose
  private int mId;

  @SerializedName("name")
  @Expose
  private String mName;

  public int getId() {
    return mId;
  }

  public String getName() {
    return mName;
  }
}
