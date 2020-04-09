package com.humber.saynn.mycommunity.entities;

import com.humber.saynn.mycommunity.R;
import com.humber.saynn.mycommunity.database.FirebaseDb;

import java.util.ArrayList;

public class FoodContent {

    private static FoodContent fc_instance;
    ArrayList<Food> foodList = new ArrayList<>();
    FirebaseDb db = FirebaseDb.getInstance();

    private FoodContent(){
        foodList = fillFoodList();
    }

    public static FoodContent getInstance(){
        if(fc_instance == null){
            fc_instance = new FoodContent();
        }
        return fc_instance;
    }

    private static ArrayList<Food> fillFoodList() {
        ArrayList<Food> tempFoodList = new ArrayList<>();

        //TODO: get and populate list from db
        String url = "https://www.google.com/maps/place/Churrasqueira+Sao+Miguel/@43.7195661,-79.5353751,15z/data=!4m8!1m2!2m1!1srestaurant!3m4!1s0x0:0xfd0d031a63c03b66!8m2!3d43.7207223!4d-79.5369896";
        tempFoodList.add(new Food("Churrasqueira", R.drawable.friedchicken,url));
        tempFoodList.add(new Food("Burger Boy", R.drawable.burgersandwich,"https://www.google.com/maps/place/Burger+Boy/@43.7298735,-79.6043775,15z/data=!4m8!1m2!2m1!1srestaurant!3m4!1s0x0:0xea0062a6e6d11251!8m2!3d43.7311737!4d-79.6006599"));
        tempFoodList.add(new Food("Pizza Nova", R.drawable.pizza,"https://www.google.com/maps/place/Pizza+Nova/@43.7298735,-79.6043775,15z/data=!4m8!1m2!2m1!1srestaurant!3m4!1s0x0:0x6c53e25056d75224!8m2!3d43.7331816!4d-79.5885417"));
        tempFoodList.add(new Food("Al-Aruba", R.drawable.cheese,"https://www.google.com/maps/place/Al-Aruba+Restaurant/@43.7307089,-79.5482199,15z/data=!4m8!1m2!2m1!1srestaurant!3m4!1s0x0:0xaa4eec105e102482!8m2!3d43.7254675!4d-79.5514253"));
        tempFoodList.add(new Food("Da Nang", R.drawable.popcorn,"https://www.google.com/maps/place/Da+Nang+Restaurant/@43.7295251,-79.5198383,14.75z/data=!4m8!1m2!2m1!1srestaurant!3m4!1s0x0:0x75bc4b1b3ff7f89e!8m2!3d43.7409799!4d-79.5130777"));
        tempFoodList.add(new Food("Eggsmart", R.drawable.friedegg,"https://www.google.com/maps/place/Eggsmart/@43.695627,-79.5296338,14.5z/data=!4m8!1m2!2m1!1srestaurant!3m4!1s0x0:0xf2e9e730ce964a3!8m2!3d43.702269!4d-79.5231038"));
        tempFoodList.add(new Food("Azarias", R.drawable.steak,"https://www.google.com/maps/place/Azarias+Restaurant/@43.653531,-79.5122687,13.75z/data=!4m8!1m2!2m1!1srestaurant!3m4!1s0x0:0x803cd3ac3b5427aa!8m2!3d43.6471002!4d-79.5132065"));
        tempFoodList.add(new Food("Alo", R.drawable.biscuit,"https://www.google.com/maps/place/Alo/@43.6525399,-79.4057816,14z/data=!4m8!1m2!2m1!1srestaurant!3m4!1s0x0:0xd05dd320ed94d61b!8m2!3d43.6485908!4d-79.3959779"));
        tempFoodList.add(new Food("Mc Donalds", R.drawable.burgersandwich,"https://www.google.com/maps/place/McDonald%27s/@43.668974,-79.3436474,15z/data=!4m9!1m3!2m2!1srestaurant!6e5!3m4!1s0x0:0xef9f4c49265c1145!8m2!3d43.6764621!4d-79.3585423"));
        tempFoodList.add(new Food("Irish Pub", R.drawable.beer,url));
        tempFoodList.add(new Food("Biscuit", R.drawable.biscuit,url));
        tempFoodList.add(new Food("Beverage", R.drawable.cocacola,url));
        tempFoodList.add(new Food("Beverage", R.drawable.pepsi,url));
        tempFoodList.add(new Food("Desserts", R.drawable.waffle,url));
        tempFoodList.add(new Food("Desserts", R.drawable.donut,url));
        tempFoodList.add(new Food("Desserts", R.drawable.cake,url));
        tempFoodList.add(new Food("Cafe", R.drawable.cappuccino,url));
        tempFoodList.add(new Food("Pub", R.drawable.champagne,url));
        tempFoodList.add(new Food("Pub", R.drawable.beer,url));
        tempFoodList.add(new Food("Christmas", R.drawable.christmascandy,url));
        tempFoodList.add(new Food("Desserts", R.drawable.chocolate,url));
        tempFoodList.add(new Food("Cafe", R.drawable.tea,url));
        tempFoodList.add(new Food("Food", R.drawable.foodimage,url));

        //db.addFood(foodList);
        return tempFoodList;

    }

    public void addFood(Food f){
        if(foodList != null){
            foodList.add(f);
        }
    }

    public ArrayList<Food> getFoodList() {
        return this.foodList;
    }
}
