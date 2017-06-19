package com.example.nicolas.brewtime.beerList.ui.viewmodel;

import com.example.nicolas.brewtime.beerList.model.Ingredient;
import com.example.nicolas.brewtime.beerList.ui.viewmodel.base.IngredientBaseViewModel;


public class IngredientViewModel implements IngredientBaseViewModel {

    private String type;
    private String name;
    private String quantity;

    public IngredientViewModel(Ingredient ingredient) {
        this.type = ingredient.getType();
        this.name = ingredient.getName();
        this.quantity = Integer.toString(ingredient.getQuantity()) + "g";
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }
}
