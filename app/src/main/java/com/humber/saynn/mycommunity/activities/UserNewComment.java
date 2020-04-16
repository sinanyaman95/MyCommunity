package com.humber.saynn.mycommunity.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.humber.saynn.mycommunity.GlobalApplication;
import com.humber.saynn.mycommunity.R;
import com.humber.saynn.mycommunity.database.FirebaseDb;
import com.humber.saynn.mycommunity.entities.User;

public class UserNewComment extends AppCompatActivity {

    TextView foodName;
    TextView username;
    EditText comment;
    Button done;
    String foodNameStr;
    String usernameStr;

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
        done = findViewById(R.id.addCommentButton);
        Intent i = getIntent();
        if(i.hasExtra("foodName")){
            foodNameStr = i.getStringExtra("foodName");
            foodName.setText(foodNameStr);
        }
        usernameStr = ((GlobalApplication)getApplicationContext()).getUserEmail();
        username.setText(usernameStr);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewComment();
                Intent i = new Intent(getApplicationContext(),ExploreActivity.class);
                i.putExtra("food",foodNameStr);
                startActivity(i);
            }
        });
    }

    private void addNewComment() {
        String commentText = comment.getText().toString();
        User u = new User();
        u.setUsername(usernameStr);
        u.setComment(commentText);
        FirebaseDb db = FirebaseDb.getInstance();
        db.addComment(foodNameStr,u);
    }
}
