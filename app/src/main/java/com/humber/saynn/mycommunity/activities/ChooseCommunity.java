package com.humber.saynn.mycommunity.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.humber.saynn.mycommunity.R;
import com.humber.saynn.mycommunity.database.FirebaseDb;

import java.util.ArrayList;

public class ChooseCommunity extends AppCompatActivity {

    LinearLayout cuisineLayout;
    LinearLayout musicLayout;
    LinearLayout sportsLayout;
    LinearLayout generalLayout;

    TextView cuisineText;
    TextView musicText;
    TextView sportsText;
    TextView generalText;

    ImageView cuisineSelected;
    ImageView musicSelected;
    ImageView sportsSelected;
    ImageView generalSelected;

    Button continueButton;
    String userEmail;
    boolean cuisine,music,sports,general;
    FirebaseDb db = FirebaseDb.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_community);

        Intent i = getIntent();
        if(i.hasExtra(LogIn.USER_EMAIL)){
            userEmail = i.getStringExtra(LogIn.USER_EMAIL);
        }

        cuisine = false; music = false; sports = false; general = false;
        cuisineLayout = findViewById(R.id.cuisineLayout);
        musicLayout = findViewById(R.id.musicLayout);
        sportsLayout = findViewById(R.id.sportsLayout);
        generalLayout = findViewById(R.id.generalLayout);

        cuisineSelected = findViewById(R.id.cuisineSelected);
        musicSelected = findViewById(R.id.musicSelected);
        sportsSelected = findViewById(R.id.sportsSelected);
        generalSelected = findViewById(R.id.generalSelected);

        cuisineText = findViewById(R.id.cuisineText);
        cuisineLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable bgColor = (ColorDrawable)cuisineLayout.getBackground();
                if(bgColor.getColor() != ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory)){
                    cuisineLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory));
                    cuisineSelected.setImageResource(R.drawable.check_image);
                    cuisine = true;
                }else{
                    cuisineLayout.setBackgroundColor(Color.WHITE);
                    cuisineSelected.setImageDrawable(null);
                    cuisine = false;
                }
            }
        });
        musicText = findViewById(R.id.musicText);
        musicLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable bgColor = (ColorDrawable)musicLayout.getBackground();
                if(bgColor.getColor() != ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory)){
                    musicLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory));
                    musicSelected.setImageResource(R.drawable.check_image);
                    music = true;
                }else{
                    musicLayout.setBackgroundColor(Color.WHITE);
                    musicSelected.setImageDrawable(null);
                    music = false;
                }
            }
        });
        sportsText = findViewById(R.id.sportsText);
        sportsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable bgColor = (ColorDrawable)sportsLayout.getBackground();
                if(bgColor.getColor() != ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory)){
                    sportsLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory));
                    sportsSelected.setImageResource(R.drawable.check_image);
                    sports = true;
                }else{
                    sportsLayout.setBackgroundColor(Color.WHITE);
                    sportsSelected.setImageDrawable(null);
                    sports = false;
                }
            }
        });
        generalText = findViewById(R.id.generalText);
        generalLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable bgColor = (ColorDrawable)generalLayout.getBackground();
                if(bgColor.getColor() != ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory)){
                    generalLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory));
                    generalSelected.setImageResource(R.drawable.check_image);
                    general = true;
                }else{
                    generalLayout.setBackgroundColor(Color.WHITE);
                    generalSelected.setImageDrawable(null);
                    general = false;
                }
            }
        });

        continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserPreference();
                Intent i = new Intent(getApplicationContext(),ChooseNationality.class);
                i.putExtra(LogIn.USER_EMAIL,userEmail);
                startActivity(i);
            }
        });

    }

    private void addUserPreference() {
        ArrayList<String> communitiesSelected = new ArrayList<>();
        if(cuisine) communitiesSelected.add("cuisine");
        if(music) communitiesSelected.add("music");
        if(general) communitiesSelected.add("general");
        if(sports) communitiesSelected.add("sports");

        for(String s: communitiesSelected){
            db.addPreference(s,userEmail);
        }

    }
}
