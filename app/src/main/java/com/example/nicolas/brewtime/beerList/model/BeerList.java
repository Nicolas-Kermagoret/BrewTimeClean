package com.example.nicolas.brewtime.beerList.model;

import java.util.List;

public class BeerList {

    private int size;
    private List<Beer> beerList;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Beer> getBeerList() {
        return beerList;
    }

    public void setBeerList(List<Beer> beerList) {
        this.beerList = beerList;
    }
}
