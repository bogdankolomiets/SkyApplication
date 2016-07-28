package com.example.bogdan.skyapplication.presenter.vo;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public class CityWeatherVO {
  private String mIcon;
  private String mName;
  private String mDescription;
  private int mTemperature;

  public CityWeatherVO(String icon, String name, String description, int temperature) {
    mIcon = icon;
    mName = name;
    mDescription = description;
    mTemperature = temperature;
  }

  public String getIcon() {
    return mIcon;
  }

  public String getName() {
    return mName;
  }

  public String getDescription() {
    return mDescription;
  }

  public int getTemperature() {
    return mTemperature;
  }
}
