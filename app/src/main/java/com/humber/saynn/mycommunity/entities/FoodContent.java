package com.humber.saynn.mycommunity.entities;

import com.humber.saynn.mycommunity.R;

import java.util.ArrayList;

public class FoodContent {

    private static FoodContent fc_instance;
    ArrayList<Food> foodList;
    private FoodContent(){
        foodList = fillFoodList();
    }

    public static FoodContent getInstance(){
        if(fc_instance == null){
            fc_instance = new FoodContent();
        }
        return fc_instance;
    }

    private ArrayList<Food> fillFoodList() {
        ArrayList<Food> tempFoodList = new ArrayList<>();

        tempFoodList.add(new Food("Food", R.drawable.foodimage));
        tempFoodList.add(new Food("Food", R.drawable.foodimage));
        tempFoodList.add(new Food("Food", R.drawable.foodimage));
        tempFoodList.add(new Food("Food", R.drawable.foodimage));
        tempFoodList.add(new Food("Food", R.drawable.foodimage));
        tempFoodList.add(new Food("Food", R.drawable.foodimage));
        tempFoodList.add(new Food("Food", R.drawable.foodimage));
        tempFoodList.add(new Food("Food", R.drawable.foodimage));
        tempFoodList.add(new Food("Food", R.drawable.foodimage));

        return tempFoodList;

    }

    public ArrayList<Food> getFoodList() {
        return this.foodList;
    }
}
