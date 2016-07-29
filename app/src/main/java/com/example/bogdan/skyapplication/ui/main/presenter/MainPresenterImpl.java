package com.example.bogdan.skyapplication.ui.main.presenter;

import com.example.bogdan.skyapplication.model.Model;
import com.example.bogdan.skyapplication.model.entity.WeatherData;
import com.example.bogdan.skyapplication.ui.common.BasePresenter;
import com.example.bogdan.skyapplication.ui.main.presenter.mapper.CityWeatherMapper;
import com.example.bogdan.skyapplication.ui.main.vo.CityWeatherVO;
import com.example.bogdan.skyapplication.ui.main.view.MainView;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public class MainPresenterImpl extends BasePresenter implements MainPresenter {
  private MainView mView;
  private final CityWeatherMapper mMapper;

  @Inject
  public MainPresenterImpl(Model model, MainView view, CityWeatherMapper mapper) {
    super(model);
    mView = view;
    mMapper = mapper;
  }

  @Override
  public void onCreate() {
    mModel.getCities().subscribe(new Observer<List<String>>() {
      @Override
      public void onCompleted() {

      }

      @Override
      public void onError(Throwable e) {

      }

      @Override
      public void onNext(List<String> strings) {
        for (String city : strings) {
          showCity(city);
        }
      }
    });
  }

  @Override
  public void OnSearchClick(String city) {
    mView.startCityDetailFragment(city);
  }

  @Override
  public void onResume() {
    onCreate();
  }

  private void showCity(String city) {
    mModel.getCurrentWeatherByCity(city)
        .subscribe(new Observer<WeatherData>() {
          @Override
          public void onCompleted() {

          }

          @Override
          public void onError(Throwable e) {
            e.printStackTrace();
          }

          @Override
          public void onNext(WeatherData data) {
            CityWeatherVO vo = mMapper.transform(data);
            mView.showWeatherData(vo);
          }
        });
  }
}
