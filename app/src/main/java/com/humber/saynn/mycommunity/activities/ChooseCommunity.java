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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_community);

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
                }else{
                    cuisineLayout.setBackgroundColor(Color.WHITE);
                    cuisineSelected.setImageDrawable(null);
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
                }else{
                    musicLayout.setBackgroundColor(Color.WHITE);
                    musicSelected.setImageDrawable(null);
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
                }else{
                    sportsLayout.setBackgroundColor(Color.WHITE);
                    sportsSelected.setImageDrawable(null);
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
                }else{
                    generalLayout.setBackgroundColor(Color.WHITE);
                    generalSelected.setImageDrawable(null);
                }
            }
        });

        continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ChooseNationality.class);
                startActivity(i);
            }
        });

    }
}
