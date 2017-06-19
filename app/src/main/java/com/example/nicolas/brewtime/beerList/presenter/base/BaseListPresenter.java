package com.example.nicolas.brewtime.beerList.presenter.base;

import com.example.nicolas.brewtime.beerList.ui.view.BaseListView;
import com.example.nicolas.brewtime.common.presenter.BasePresenter;

public interface BaseListPresenter extends BasePresenter<BaseListView> {

    void getBeers();

}
