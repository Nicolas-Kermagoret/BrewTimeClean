package com.example.nicolas.brewtime.beerList.ui.viewmodel;

import com.example.nicolas.brewtime.beerList.model.Beer;
import com.example.nicolas.brewtime.beerList.model.BeerList;
import com.example.nicolas.brewtime.beerList.model.Ingredient;
import com.example.nicolas.brewtime.beerList.ui.viewmodel.base.BeerBaseViewModel;
import com.example.nicolas.brewtime.beerList.ui.viewmodel.base.IngredientBaseViewModel;

import java.util.ArrayList;
import java.util.List;


public class BeerViewModel implements BeerBaseViewModel {

    private String name;
    private String type;
    private String quantity;
    private String iconPath;

    private String brewDate;
    private String secondFermentationDate;
    private String gardeDate;
    private String bottlingDate;
    private String drinkingDate;

    private List<IngredientBaseViewModel> ingredientList;

    public BeerViewModel(Beer beer) {

        this.name = beer.getName();
        this.type = beer.getType();
        this.quantity = Integer.toString(beer.getQuantity()) +"L";
        this.iconPath = "beer_icon_"+ this.type.toLowerCase();
        this.brewDate = beer.getBrewDate();
        this.secondFermentationDate = beer.getSecondFermentationDate();
        this.gardeDate = beer.getGardeDate();
        this.bottlingDate = beer.getBottlingDate();
        this.drinkingDate = beer.getDrinkingDate();

        this.ingredientList = new ArrayList<>();

        for (Ingredient ingredient : beer.getIngredientList()){
            ingredientList.add(new IngredientViewModel(ingredient));
        }
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getIconPath() {
        return iconPath;
    }

    public String getBrewDate() {
        return brewDate;
    }

    public String getSecondFermentationDate() {
        return secondFermentationDate;
    }

    public String getGardeDate() {
        return gardeDate;
    }

    public String getBottlingDate() {
        return bottlingDate;
    }

    public String getDrinkingDate() {
        return drinkingDate;
    }

    public List<IngredientBaseViewModel> getIngredientList() {
        return ingredientList;
    }
}
