package com.example.bogdan.skyapplication.di.component;

import com.example.bogdan.skyapplication.di.ActivityScope;
import com.example.bogdan.skyapplication.di.module.DetailViewModule;
import com.example.bogdan.skyapplication.view.detail.DetailActivity;

import dagger.Subcomponent;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 28.07.16
 */
@ActivityScope
@Subcomponent(modules = {DetailViewModule.class})
public interface DetailViewComponent {
  void inject(DetailActivity detailActivity);
}
