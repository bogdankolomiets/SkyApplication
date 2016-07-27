package com.example.bogdan.skyapplication.api;

import com.example.bogdan.skyapplication.model.entity.WeatherData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public interface WeatherApi {

  @GET("weather/")
  Observable<WeatherData> weatherByCity(@Query("q") String city,
                                        @Query("units") String units,
                                        @Query("lang") String language,
                                        @Query("appId") String appId);

}
