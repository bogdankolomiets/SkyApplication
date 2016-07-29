package com.example.bogdan.skyapplication;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public class CityDataHelper {
  private static final String CITY_PREFERENCES = "city";

  private final Context mContext;
  private final SharedPreferences mPreferences;

  @Inject
  public CityDataHelper(Context context) {
    mContext = context;
    mPreferences = context.getSharedPreferences(CITY_PREFERENCES, Context.MODE_PRIVATE);
  }

  public void addCity(String name) {
    if (!hasCity(name)) {
      SharedPreferences.Editor editor = mPreferences.edit();
      editor.putString(name, name);
      editor.apply();
    }
  }

  public String getCity(String name) {
    if (hasCity(name)) {
      return mPreferences.getString(name, "");
    }

    return null;
  }

  public List<String> getAllCities() {
    List<String> cities = new ArrayList<>();
    for (Map.Entry<String, ?> entry : mPreferences.getAll().entrySet()) {
      cities.add(entry.getValue().toString());
    }

    return cities;
  }

  public boolean hasCity(String city) {
    return mPreferences.contains(city);
  }

}
