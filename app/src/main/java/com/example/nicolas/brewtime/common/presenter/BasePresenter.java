package com.example.nicolas.brewtime.common.presenter;

public interface BasePresenter<T> {
    void onViewAttached(T view);

    void onViewDetached();

    void onDestroy();
}
