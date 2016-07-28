package com.example.bogdan.skyapplication.presenter.vo;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 28.07.16
 */
public class CityVO {
  private int mId;
  private String mName;

  public CityVO(int id, String name) {
    mId = id;
    mName = name;
  }

  public int getId() {
    return mId;
  }

  public String getName() {
    return mName;
  }
}
