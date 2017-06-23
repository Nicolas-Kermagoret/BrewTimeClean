package com.example.nicolas.brewtime.beerList.ui.viewmodel.base;

import java.io.Serializable;
import java.util.List;

public interface BeerBaseViewModel extends Serializable{

    String getName();

    String getType();

    String getQuantity();

    String getIconPath();

    String getBrewDate();

    String getSecondFermentationDate();

    String getGardeDate();

    String getBottlingDate();

    String getDrinkingDate();

    List<IngredientBaseViewModel> getIngredientList();

}
