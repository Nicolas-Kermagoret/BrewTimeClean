package com.example.nicolas.brewtime.beerList.model;

import java.util.List;

public class Beer {

    private String name;
    private String type;
    private int quantity;

    private String brewDate;
    private String secondFermentationDate;
    private String gardeDate;
    private String bottlingDate;
    private String drinkingDate;

    private List<Ingredient> ingredientList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrewDate() {
        return brewDate;
    }

    public void setBrewDate(String brewDate) {
        this.brewDate = brewDate;
    }

    public String getSecondFermentationDate() {
        return secondFermentationDate;
    }

    public void setSecondFermentationDate(String secondFermentationDate) {
        this.secondFermentationDate = secondFermentationDate;
    }

    public String getGardeDate() {
        return gardeDate;
    }

    public void setGardeDate(String gardeDate) {
        this.gardeDate = gardeDate;
    }

    public String getBottlingDate() {
        return bottlingDate;
    }

    public void setBottlingDate(String bottlingDate) {
        this.bottlingDate = bottlingDate;
    }

    public String getDrinkingDate() {
        return drinkingDate;
    }

    public void setDrinkingDate(String drinkingDate) {
        this.drinkingDate = drinkingDate;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
