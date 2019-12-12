package com.humber.saynn.mycommunity.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.humber.saynn.mycommunity.R;
import com.humber.saynn.mycommunity.adapters.HorizontalFoodAdapter;
import com.humber.saynn.mycommunity.adapters.VerticalFoodAdapter;
import com.humber.saynn.mycommunity.entities.Food;
import com.humber.saynn.mycommunity.entities.FoodContent;

import java.util.ArrayList;

public class FoodBlog extends AppCompatActivity {

    RecyclerView recyclerView;
    VerticalFoodAdapter verticalFoodAdapter;
    ArrayList<Food> foodList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_blog);

        foodList = FoodContent.getInstance().getFoodList();
        verticalFoodAdapter = new VerticalFoodAdapter(this,foodList);
        recyclerView = findViewById(R.id.foodBlogRecycler);
        recyclerView.setAdapter(verticalFoodAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
    }
}
