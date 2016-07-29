package com.example.bogdan.skyapplication.ui.detail.presenter;

import android.view.Menu;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 28.07.16
 */
public interface DetailPresenter {
  void onCreate(String city);

  void onAddClick(String city);

  void onCreateOptionsMenu(Menu menu);
}
