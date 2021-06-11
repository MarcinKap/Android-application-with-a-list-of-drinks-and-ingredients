package com.example.drinkcreator.apiModels;

import java.util.List;

public class ObjectModelWithListFromApi {
    List<DrinkModelFromApi> drinks;

    public List<DrinkModelFromApi> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<DrinkModelFromApi> drinks) {
        this.drinks = drinks;
    }
}
