package com.example.bogdan.skyapplication.di.component;

import com.example.bogdan.skyapplication.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

}
