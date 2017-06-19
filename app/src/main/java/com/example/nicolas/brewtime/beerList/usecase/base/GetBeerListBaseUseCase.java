package com.example.nicolas.brewtime.beerList.usecase.base;

import com.example.nicolas.brewtime.beerList.model.BeerList;

public interface GetBeerListBaseUseCase {

    interface UseCaseListener {
        void setResponse(BeerList result);

        void error(String message);

        void endTask();
    }

    void getBeers();

    void clean();

    void setUseCaseListener(UseCaseListener listener);

}
