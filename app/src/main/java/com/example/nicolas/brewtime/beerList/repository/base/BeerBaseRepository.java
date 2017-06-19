package com.example.nicolas.brewtime.beerList.repository.base;


import com.example.nicolas.brewtime.beerList.model.BeerList;

import io.reactivex.Observable;

public interface BeerBaseRepository {

    Observable<BeerList> getBeersFromSharedPrefs();

}
