package com.humber.saynn.mycommunity.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.humber.saynn.mycommunity.R;
import com.humber.saynn.mycommunity.adapters.HorizontalFoodAdapter;
import com.humber.saynn.mycommunity.adapters.VerticalUserCommentAdapter;
import com.humber.saynn.mycommunity.database.FirebaseDb;
import com.humber.saynn.mycommunity.entities.Food;
import com.humber.saynn.mycommunity.entities.FoodContent;
import com.humber.saynn.mycommunity.entities.User;

import java.util.ArrayList;

public class ExploreActivity extends AppCompatActivity {

    RecyclerView topHorizontal;
    RecyclerView bottomVertical;
    ArrayList<Food> foodArrayList;
    HorizontalFoodAdapter horizontalFoodAdapter;
    VerticalUserCommentAdapter verticalUserCommentAdapter;
    String foodName;
    FirebaseDb db;
    ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        userList = new ArrayList<>();
        db= FirebaseDb.getInstance();

        Intent mainIntent = getIntent();
        if(mainIntent.hasExtra("food")) foodName = mainIntent.getStringExtra("food");

        userList = db.getUserCommentList(foodName);
        foodArrayList = FoodContent.getInstance().getFoodList();
        horizontalFoodAdapter = new HorizontalFoodAdapter(this,foodArrayList);
        topHorizontal = findViewById(R.id.exploreFoodRecycler);
        topHorizontal.setAdapter(horizontalFoodAdapter);
        topHorizontal.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        verticalUserCommentAdapter = new VerticalUserCommentAdapter(this,userList);
        bottomVertical = findViewById(R.id.userCommentRecycler);
        bottomVertical.setAdapter(verticalUserCommentAdapter);
        bottomVertical.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


    }


}
