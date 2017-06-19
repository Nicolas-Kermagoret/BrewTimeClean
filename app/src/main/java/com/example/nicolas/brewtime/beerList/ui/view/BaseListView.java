package com.example.nicolas.brewtime.beerList.ui.view;

import com.example.nicolas.brewtime.beerList.ui.viewmodel.base.BeerBaseViewModel;

import java.util.List;

public interface BaseListView {

    void onError(String msg);

    void setResponse(List<BeerBaseViewModel> beerBaseViewModels);

    void loading(boolean isLoading);

    void onNoNetwork();

    void setEmptyResponse();

}
