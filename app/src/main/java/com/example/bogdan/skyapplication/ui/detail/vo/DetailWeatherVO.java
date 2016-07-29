package com.example.bogdan.skyapplication.ui.detail.vo;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 28.07.16
 */
public class DetailWeatherVO {
  private final String mIconUrl;
  private final String mTemperature;
  private final String mPressure;
  private final String mHumidity;
  private final String mWindSpeed;
  private final String mDescription;

  private DetailWeatherVO(Builder builder) {
    mIconUrl = builder.mIconUrl;
    mTemperature = builder.mTemperature;
    mPressure = builder.mPressure;
    mHumidity = builder.mHumidity;
    mWindSpeed = builder.mWindSpeed;
    mDescription = builder.mDescription;
  }

  public String getIcon() {
    return mIconUrl;
  }

  public String getTemperature() {
    return mTemperature;
  }

  public String getPressure() {
    return mPressure;
  }

  public String getHumidity() {
    return mHumidity;
  }

  public String getWindSpeed() {
    return mWindSpeed;
  }

  public String getDescription() {
    return mDescription;
  }

  public static class Builder {
    private String mIconUrl;
    private String mTemperature;
    private String mPressure;
    private String mHumidity;
    private String mWindSpeed;
    private String mDescription;

    public Builder() {

    }

    public Builder icon(String url) {
      mIconUrl = url;
      return this;
    }

    public Builder temperature(int temperature) {
      if (temperature > 0) {
        mTemperature = "+" + temperature + " °C";
        return this;
      }
      mTemperature = temperature + " °C";
      return this;
    }

    public Builder pressure(int pressure) {
      mPressure = pressure + " мм рт. ст.";
      return this;
    }

    public Builder humidity(int humidity) {
      mHumidity = humidity + " % влажности";
      return this;
    }

    public Builder windSpeed(double speed) {
      mWindSpeed = speed + " м/с";
      return this;
    }

    public Builder description(String description) {
      mDescription = description;
      return this;
    }

    public DetailWeatherVO build() {
      return new DetailWeatherVO(this);
    }
  }
}
