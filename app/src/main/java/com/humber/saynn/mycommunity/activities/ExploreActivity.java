package com.humber.saynn.mycommunity.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.humber.saynn.mycommunity.GlobalApplication;
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
    TextView exploreFoodName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        Log.d("syDebug", "Explore Activity: " + ((GlobalApplication)getApplicationContext()).getUserEmail() );
        db= FirebaseDb.getInstance();
        exploreFoodName = findViewById(R.id.exploreFoodName);
        Intent mainIntent = getIntent();
        if(mainIntent.hasExtra("food")) foodName = mainIntent.getStringExtra("food");
        exploreFoodName.setText(foodName);
        bottomVertical = findViewById(R.id.userCommentRecycler);
        db.getCommentList(foodName, new FirebaseDb.OnGetDataListener() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                userList = new ArrayList<>();
                if(dataSnapshot.child(foodName).exists()){
                    DataSnapshot food = dataSnapshot.child(foodName);
                    for(DataSnapshot ds: food.getChildren()){
                        if(!ds.getKey().equals("image")
                                && !ds.getKey().equals("url")
                                && !ds.getKey().equals("nationality")){
                            User u = new User();
                            u.setUsername(ds.getKey());
                            u.setComment(ds.getValue().toString());
                            userList.add(u);
                        }
                    }
                }
                verticalUserCommentAdapter = new VerticalUserCommentAdapter(getApplicationContext(),userList, foodName);
                bottomVertical.setAdapter(verticalUserCommentAdapter);
                bottomVertical.setLayoutManager(
                        new LinearLayoutManager(getApplicationContext(),
                                LinearLayoutManager.VERTICAL,
                                false));
            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure() {

            }
        });
        foodArrayList = FoodContent.getInstance().getFoodList();
        horizontalFoodAdapter = new HorizontalFoodAdapter(this,foodArrayList);
        topHorizontal = findViewById(R.id.exploreFoodRecycler);
        topHorizontal.setAdapter(horizontalFoodAdapter);
        topHorizontal.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        //verticalUserCommentAdapter = new VerticalUserCommentAdapter(this,userList);
        //bottomVertical.setAdapter(verticalUserCommentAdapter);
        //bottomVertical.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


    }




}
