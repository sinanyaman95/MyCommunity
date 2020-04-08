package com.humber.saynn.mycommunity.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.humber.saynn.mycommunity.R;
import com.humber.saynn.mycommunity.adapters.HorizontalFoodAdapter;
import com.humber.saynn.mycommunity.adapters.VerticalUserCommentAdapter;
import com.humber.saynn.mycommunity.entities.Food;
import com.humber.saynn.mycommunity.entities.FoodContent;
import com.humber.saynn.mycommunity.entities.User;

import java.util.ArrayList;

public class ExploreActivity extends AppCompatActivity {

    RecyclerView topHorizontal;
    RecyclerView bottomVertical;
    ArrayList<Food> foodArrayList;
    HorizontalFoodAdapter horizontalFoodAdapter;
    ArrayList<User> userList;
    VerticalUserCommentAdapter verticalUserCommentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        foodArrayList = FoodContent.getInstance().getFoodList();
        userList = fillUsers();
        horizontalFoodAdapter = new HorizontalFoodAdapter(this,foodArrayList);
        verticalUserCommentAdapter = new VerticalUserCommentAdapter(this,userList);
        topHorizontal = findViewById(R.id.exploreFoodRecycler);
        topHorizontal.setAdapter(horizontalFoodAdapter);
        topHorizontal.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        bottomVertical = findViewById(R.id.userCommentRecycler);
        bottomVertical.setAdapter(verticalUserCommentAdapter);
        bottomVertical.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }

    private ArrayList<User> fillUsers() {

        ArrayList<User> tempUserList = new ArrayList<>();

        //TODO: get reviews from db with food id and user id

        tempUserList.add(new User("syaman","I really liked this food which can be found in ..... Restaurant"));
        tempUserList.add(new User("bishey","Clean, delicious"));
        tempUserList.add(new User("nav","Didn't like it tbh."));
        tempUserList.add(new User("syaman","I really liked this food which can be found in ..... Restaurant"));
        tempUserList.add(new User("syaman","I really liked this food which can be found in ..... Restaurant"));
        tempUserList.add(new User("syaman","I really liked this food which can be found in ..... Restaurant"));
        tempUserList.add(new User("syaman","I really liked this food which can be found in ..... Restaurant"));
        tempUserList.add(new User("syaman","I really liked this food which can be found in ..... Restaurant"));
        tempUserList.add(new User("syaman","I really liked this food which can be found in ..... Restaurant"));
        tempUserList.add(new User("syaman","I really liked this food which can be found in ..... Restaurant"));
        tempUserList.add(new User("syaman","I really liked this food which can be found in ..... Restaurant"));
        tempUserList.add(new User("syaman","I really liked this food which can be found in ..... Restaurant"));


        return tempUserList;
    }
}
