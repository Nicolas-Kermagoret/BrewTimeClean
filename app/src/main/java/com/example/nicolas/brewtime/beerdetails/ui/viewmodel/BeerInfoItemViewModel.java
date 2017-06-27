package com.example.nicolas.brewtime.beerdetails.ui.viewmodel;

import com.example.nicolas.brewtime.beerdetails.ui.viewmodel.base.BeerInfoItemBaseViewModel;


public class BeerInfoItemViewModel implements BeerInfoItemBaseViewModel {

    String info;
    String value;

    public BeerInfoItemViewModel(String info, String value) {
        this.info = info;
        this.value = value;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
