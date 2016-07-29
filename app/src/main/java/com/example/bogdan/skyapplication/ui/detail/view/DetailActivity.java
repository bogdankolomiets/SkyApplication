package com.example.bogdan.skyapplication.ui.detail.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bogdan.skyapplication.App;
import com.example.bogdan.skyapplication.Constants;
import com.example.bogdan.skyapplication.R;
import com.example.bogdan.skyapplication.di.module.DetailViewModule;
import com.example.bogdan.skyapplication.model.entity.ForecastData;
import com.example.bogdan.skyapplication.model.entity.WeatherData;
import com.example.bogdan.skyapplication.ui.detail.presenter.DetailPresenter;
import com.example.bogdan.skyapplication.ui.main.view.MainActivity;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public class DetailActivity extends AppCompatActivity implements DetailView, DetailAdapter.OnItemClickListener {
  private static final int LAYOUT = R.layout.detail_layout;

  @BindView(R.id.detail_city)
  TextView cityView;

  @BindView(R.id.detail_icon)
  ImageView iconView;

  @BindView(R.id.detail_temperature)
  TextView temperatureView;

  @BindView(R.id.detail_pressure)
  TextView pressureView;

  @BindView(R.id.detail_humidity)
  TextView humidityView;

  @BindView(R.id.detail_wind_speed)
  TextView windSpeedView;

  @BindView(R.id.detail_description)
  TextView descriptionView;

  @BindView(R.id.detail_recycler)
  RecyclerView recyclerView;

  @Inject
  DetailPresenter presenter;

  private Toolbar mToolbar;
  private DetailAdapter mAdapter;
  private LinearLayoutManagerWithSmoothScroller mLayoutManager;
  private String mCity;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    resolveDependecies();
    setContentView(LAYOUT);
    ButterKnife.bind(this);
    initToolbar();
    prepareRecyclerView();
    mCity = getIntent().getStringExtra("city");
    setCityName(mCity);
    presenter.onCreate(mCity);
  }

  private void resolveDependecies() {
    App.get(this).getAppComponent().plus(new DetailViewModule(this)).inject(this);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.detail_menu, menu);
    presenter.onCreateOptionsMenu(menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.add:
        presenter.onAddClick(mCity);
        return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public void showForecast(ForecastData data) {
    mAdapter.addData(data.getData());
  }

  @Override
  public void showCurrentWeather(WeatherData data) {
    setupView(data);
  }

  @Override
  public void hideAddBtn(Menu menu) {
    menu.findItem(R.id.add).setVisible(false);
  }

  public void prepareRecyclerView() {
    mLayoutManager = new LinearLayoutManagerWithSmoothScroller(this, LinearLayoutManager.HORIZONTAL, false);
    recyclerView.setLayoutManager(mLayoutManager);
    mAdapter = new DetailAdapter(this, this);
    recyclerView.setAdapter(mAdapter);
  }

  @Override
  public void onClick(WeatherData data, int position) {
    scroolTo(position);
    setupView(data);
  }

  @Override
  public boolean onSupportNavigateUp() {
    startActivity(new Intent(this, MainActivity.class));
    finish();
    return true;
  }

  private void initToolbar() {
    mToolbar = (Toolbar) findViewById(R.id.detail_toolbar);
    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
  }

  private void scroolTo(int position) {
    recyclerView.smoothScrollToPosition(position);
  }

  private void setCityName(String city) {
    cityView.setText(city);
  }

  private void setupView(WeatherData data) {
    Picasso.with(this)
        .load(Constants.HTTP.ICON_BASE_URL + data.getIcon() + ".png")
        .into(iconView);

    temperatureView.setText(getTempText(data));
    pressureView.setText(getPressText(data));
    humidityView.setText(getHumText(data));
    windSpeedView.setText(getWSText(data));
    descriptionView.setText(data.getWeatherDescription());
  }

  private String getTempText(WeatherData data) {
    return data.getTemperature() > 0
        ? "+" + data.getTemperature() + " °C"
        : data.getTemperature() + " °C";
  }

  private String getPressText(WeatherData data) {
    return data.getPressure() + " мм рт. ст.";
  }

  private String getHumText(WeatherData data) {
    return data.getHumidity() + " % влажности";
  }

  private String getWSText(WeatherData data) {
    return data.getWindSpeed() + " м/с";
  }
}
