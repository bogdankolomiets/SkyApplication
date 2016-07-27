package com.example.bogdan.skyapplication.presenter;

import com.example.bogdan.skyapplication.model.Model;

import rx.subscriptions.CompositeSubscription;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public abstract class BasePresenter {
  private CompositeSubscription mCompositeSubscription = new CompositeSubscription();
  protected final Model mModel;

  public BasePresenter(Model model) {
    mModel = model;
  }
}
