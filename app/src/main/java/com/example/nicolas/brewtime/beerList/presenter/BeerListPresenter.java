package com.example.nicolas.brewtime.beerList.presenter;

import com.example.nicolas.brewtime.beerList.model.Beer;
import com.example.nicolas.brewtime.beerList.model.BeerList;
import com.example.nicolas.brewtime.beerList.presenter.base.BaseListPresenter;
import com.example.nicolas.brewtime.beerList.ui.view.BaseListView;
import com.example.nicolas.brewtime.beerList.ui.viewmodel.BeerViewModel;
import com.example.nicolas.brewtime.beerList.ui.viewmodel.base.BeerBaseViewModel;
import com.example.nicolas.brewtime.beerList.usecase.base.GetBeerListBaseUseCase;

import java.util.ArrayList;
import java.util.List;


public class BeerListPresenter implements BaseListPresenter, GetBeerListBaseUseCase.UseCaseListener {

    private GetBeerListBaseUseCase useCase;
    private BaseListView view;

    public BeerListPresenter(GetBeerListBaseUseCase useCase, BaseListView view) {
        this.useCase = useCase;
        this.useCase.setUseCaseListener(this);
    }

    @Override
    public void onViewAttached(BaseListView view) {
        this.view=view;
    }

    @Override
    public void onViewDetached() {
        this.view=null;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void getBeers() {
        this.useCase.getBeers();
    }

    @Override
    public void setResponse(BeerList result) {
        List<BeerBaseViewModel> beerViewModels = new ArrayList<>();
        for(Beer beer: result.getBeerList()){
            beerViewModels.add(new BeerViewModel(beer));
        }
        view.setResponse(beerViewModels);

    }

    @Override
    public void error(String message) {

    }

    @Override
    public void endTask() {

    }
}
