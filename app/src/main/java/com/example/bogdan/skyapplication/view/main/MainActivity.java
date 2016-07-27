package com.example.bogdan.skyapplication.view.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.bogdan.skyapplication.App;
import com.example.bogdan.skyapplication.R;
import com.example.bogdan.skyapplication.di.module.MainViewModule;
import com.example.bogdan.skyapplication.model.entity.CityWeatherVO;
import com.example.bogdan.skyapplication.presenter.MainPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public class MainActivity extends AppCompatActivity implements MainView {
  private static final int LAYOUT = R.layout.main_layout;

  @BindView(R.id.main_recycler)
  RecyclerView recyclerView;

  @Inject
  MainPresenter presenter;

  private LinearLayoutManager mLayoutManager;
  private CitiesAdapter mAdapter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    resolveDependecies();
    setContentView(R.layout.main_layout);
    ButterKnife.bind(this);
    prepareRecyclerView();
    presenter.onCreate();
  }

  private void resolveDependecies() {
    App.get(this).getAppComponent().plus(new MainViewModule(this)).inject(this);
  }

  @Override
  public void showWeatherData(CityWeatherVO weatherData) {

  }

  private void prepareRecyclerView() {
    mLayoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(mLayoutManager);
    mAdapter = new CitiesAdapter(this);
    recyclerView.setAdapter(mAdapter);
  }
}
