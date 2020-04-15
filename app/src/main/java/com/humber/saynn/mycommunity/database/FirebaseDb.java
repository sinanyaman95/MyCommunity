package com.humber.saynn.mycommunity.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.humber.saynn.mycommunity.R;
import com.humber.saynn.mycommunity.activities.ExploreActivity;
import com.humber.saynn.mycommunity.activities.MainActivity;
import com.humber.saynn.mycommunity.adapters.VerticalUserCommentAdapter;
import com.humber.saynn.mycommunity.entities.Food;
import com.humber.saynn.mycommunity.entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

import androidx.annotation.NonNull;

public class FirebaseDb{
    private FirebaseDatabase db;
    private DatabaseReference mDatabase;
    static String nationality;
    ArrayList<User> tempList;
    private FirebaseDb() {
        db = FirebaseDatabase.getInstance();
        mDatabase = db.getReference();
        tempList = new ArrayList<>();
    }

    public static FirebaseDb getInstance(){
        return new FirebaseDb();
    }

    public void addFood(ArrayList<Food> foods){
        for(Food f: foods){
            addFood(f);
        }
    }

    public void addFood(Food f){
        HashMap<String, Object> map = new HashMap<>();
        map.put("image",f.getImageId());
        map.put("url",f.getUrl());
        map.put("nationality",f.getNationality());
        mDatabase.child("MyCommunity")
                .child("Foods")
                .child(f.getDescription())
                .setValue(map);
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

    public void checkFoodsExist(final ArrayList<Food> foods) {
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (!snapshot.hasChild("Foods")) {
                    // run some code
                    addFood(foods);
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
        nationality = s;
    }

    public String getNationality() {
        return nationality;
    }

    public void getCommentList(final String foodName, final OnGetDataListener listener) {
        listener.onStart();
        DatabaseReference myCommunity = db.getReference("MyCommunity");
        DatabaseReference foods = myCommunity.child("Foods");
        foods.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listener.onSuccess(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public ArrayList<User> getTempList() {
        return tempList;
    }

    public void setTempList(ArrayList<User> tempList) {
        this.tempList = tempList;
    }

    public interface OnGetDataListener {
        //this is for callbacks
        void onSuccess(DataSnapshot dataSnapshot);
        void onStart();
        void onFailure();
    }
}