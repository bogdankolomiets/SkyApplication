package com.example.bogdan.skyapplication.di.component;

import com.example.bogdan.skyapplication.di.module.ApiModule;
import com.example.bogdan.skyapplication.di.module.AppModule;
import com.example.bogdan.skyapplication.di.module.DetailViewModule;
import com.example.bogdan.skyapplication.di.module.MainViewModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
  MainViewComponent plus(MainViewModule mainViewModule);
  DetailViewComponent plus(DetailViewModule detailViewModule);
}
