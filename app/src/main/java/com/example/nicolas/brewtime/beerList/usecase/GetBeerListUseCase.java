package com.example.nicolas.brewtime.beerList.usecase;

import com.example.nicolas.brewtime.beerList.model.BeerList;
import com.example.nicolas.brewtime.beerList.repository.base.BeerBaseRepository;
import com.example.nicolas.brewtime.beerList.usecase.base.GetBeerListBaseUseCase;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class GetBeerListUseCase implements GetBeerListBaseUseCase {

    private BeerBaseRepository repository;
    private UseCaseListener listener;

    public GetBeerListUseCase(BeerBaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getBeers() {
        this.repository.getBeersFromSharedPrefs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BeerList>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull BeerList beerList) {
                        listener.setResponse(beerList);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        listener.error(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        listener.endTask();
                    }
                });
    }

    @Override
    public void clean() {

    }

    @Override
    public void setUseCaseListener(UseCaseListener listener) {
        this.listener=listener;
    }
}
