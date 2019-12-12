package com.humber.saynn.mycommunity.database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.humber.saynn.mycommunity.entities.Food;

public class FirebaseDb {
    private DatabaseReference mDatabase;

    public FirebaseDb() {
        this.mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void AddFood(String foodId, Food newFood){
        mDatabase.child("foods").child(foodId).setValue(newFood);
    }
}