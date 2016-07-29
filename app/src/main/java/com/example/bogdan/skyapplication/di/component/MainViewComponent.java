package com.example.bogdan.skyapplication.di.component;

import com.example.bogdan.skyapplication.di.ActivityScope;
import com.example.bogdan.skyapplication.di.module.MainViewModule;
import com.example.bogdan.skyapplication.ui.main.view.MainActivity;

import dagger.Subcomponent;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
@ActivityScope
@Subcomponent(modules = {MainViewModule.class})
public interface MainViewComponent {
  void inject(MainActivity mainActivity);
}
