package com.example.bogdan.skyapplication.ui.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bogdan.skyapplication.App;
import com.example.bogdan.skyapplication.R;
import com.example.bogdan.skyapplication.di.module.MainViewModule;
import com.example.bogdan.skyapplication.ui.main.vo.CityWeatherVO;
import com.example.bogdan.skyapplication.ui.main.presenter.MainPresenter;
import com.example.bogdan.skyapplication.ui.detail.view.DetailActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public class MainActivity extends AppCompatActivity implements MainView, CitiesAdapter.OnCityClickListener {
  private static final int LAYOUT = R.layout.main_layout;

  @BindView(R.id.main_recycler)
  RecyclerView recyclerView;

  @BindView(R.id.toolbar_search_field)
  EditText searchField;

  @Inject
  MainPresenter presenter;

  private Toolbar mToolbar;
  private LinearLayoutManager mLayoutManager;
  private CitiesAdapter mAdapter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    resolveDependecies();
    setContentView(R.layout.main_layout);
    ButterKnife.bind(this);
    initToolbar();
    prepareRecyclerView();
    presenter.onCreate();
  }

  private void resolveDependecies() {
    App.get(this).getAppComponent().plus(new MainViewModule(this)).inject(this);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main_menu, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.search:
        presenter.OnSearchClick(getCity());
        return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  public void showWeatherData(CityWeatherVO weatherData) {
    mAdapter.addCity(weatherData);
  }

  @Override
  public void startCityDetailFragment(String city) {
    Intent intent = new Intent(this, DetailActivity.class);
    intent.putExtra("city", city);
    startActivity(intent);
    finish();
  }

  private void initToolbar() {
    mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
    setSupportActionBar(mToolbar);
  }

  private void prepareRecyclerView() {
    mLayoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(mLayoutManager);
    mAdapter = new CitiesAdapter(this, this);
    recyclerView.setAdapter(mAdapter);
  }

  private boolean isSearchFieldEmpty() {
    return searchField.getText().toString().isEmpty();
  }

  private String getCity() {
    if (isSearchFieldEmpty()) {
      Toast.makeText(this, "Введите пожалуйста название города", Toast.LENGTH_SHORT).show();
      return "";
    }

    return searchField.getText().toString();
  }

  @Override
  public void onClick(String city) {
    startCityDetailFragment(city);
  }
}
