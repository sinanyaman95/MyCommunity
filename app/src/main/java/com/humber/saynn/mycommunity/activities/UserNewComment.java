package com.humber.saynn.mycommunity.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.EditText;
import android.widget.TextView;

import com.humber.saynn.mycommunity.GlobalApplication;
import com.humber.saynn.mycommunity.R;

public class UserNewComment extends AppCompatActivity {

    TextView foodName;
    TextView username;
    EditText comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_new_comment);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*0.9), (int) (height*0.6));
        foodName = findViewById(R.id.userNewFood);
        username = findViewById(R.id.userNewUsername);
        comment = findViewById(R.id.userNewComment);
        String foodNameStr;
        Intent i = getIntent();
        if(i.hasExtra("foodName")){
            foodNameStr = i.getStringExtra("foodName");
            foodName.setText(foodNameStr);
        }
        username.setText(((GlobalApplication)getApplicationContext()).getUserEmail());
    }
}
