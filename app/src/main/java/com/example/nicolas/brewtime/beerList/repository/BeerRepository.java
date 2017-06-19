package com.example.nicolas.brewtime.beerList.repository;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.nicolas.brewtime.beerList.model.BeerList;
import com.example.nicolas.brewtime.beerList.repository.base.BeerBaseRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

public class BeerRepository implements BeerBaseRepository{

    public final static String prefsName = "beerData";
    public final static String sharedPrefName = "beerList";

    Context context;

    public BeerRepository(Context context) {
        this.context = context;
    }

    @Override
    public Observable<BeerList> getBeersFromSharedPrefs() {
        return Observable.create(new ObservableOnSubscribe<BeerList>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<BeerList> e) throws Exception {
                SharedPreferences sharedPreferences = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
                String jsonBeer = sharedPreferences.getString(sharedPrefName, "");
                Gson gson = new GsonBuilder().create();

                e.onNext(gson.fromJson(jsonBeer, BeerList.class));
                e.onComplete();
            }
        });
    }
}
