package com.example.nicolas.brewtime.beerList.ui.viewmodel.base;

import java.io.Serializable;

public interface IngredientBaseViewModel extends Serializable{

    String getType();
    String getName();
    String getQuantity();

}
