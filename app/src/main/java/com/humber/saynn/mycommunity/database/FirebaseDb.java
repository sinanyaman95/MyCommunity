package com.humber.saynn.mycommunity.database;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.humber.saynn.mycommunity.entities.Food;

import androidx.annotation.NonNull;

public class FirebaseDb {
    private DatabaseReference mDatabase;

    private FirebaseDb() {
        this.mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public static FirebaseDb getInstance(){
        return new FirebaseDb();
    }

    public void AddFood(String foodId, Food newFood){
        mDatabase.child("foods").child(foodId).setValue(newFood);
    }

    public void checkUserExists(final String fullEmail) {
        final String userEmail = getEmailAddress(fullEmail);
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (!snapshot.hasChild(userEmail)) {
                    // run some code
                    addUser(fullEmail,userEmail);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private String getEmailAddress(String email) {
        int indexAt = email.indexOf('@');
        if(indexAt != -1){
            return email.substring(0,indexAt);
        }else{
            return null;
        }
    }

    public void addUser(String fullEmail,String userEmail){
        mDatabase.child("MyCommunity")
                .child("Users")
                .child(userEmail)
                .child("email").setValue(fullEmail);
    }

    public DatabaseReference getReference() {
        return mDatabase;
    }


    public void addPreference(String s, String email) {
        String userEmail = getEmailAddress(email);
        if(userEmail != null){
            mDatabase.child("MyCommunity")
                    .child("Users")
                    .child(userEmail)
                    .child("Preferences")
                    .child(s).setValue("true");
        }


    }

    public void addCommunity(String s, String email) {
        String userEmail = getEmailAddress(email);
        if(userEmail != null){
            mDatabase.child("MyCommunity")
                    .child("Users")
                    .child(userEmail)
                    .child("Nationalities")
                    .child(s).setValue("true");
        }
    }
}