package com.example.bogdan.skyapplication.ui.detail.vo;

import java.util.List;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 28.07.16
 */
public class ForecastDataVO {
  private CityVO mCity;
  private List<DetailWeatherVO> mData;

  public ForecastDataVO(CityVO city, List<DetailWeatherVO> data) {
    mCity = city;
    mData = data;
  }

  public CityVO getCity() {
    return mCity;
  }

  public List<DetailWeatherVO> getData() {
    return mData;
  }
}
