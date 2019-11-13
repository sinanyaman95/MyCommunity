package com.humber.saynn.mycommunity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChooseNationality extends AppCompatActivity {

    LinearLayout turkishLayout;
    LinearLayout indianLayout;
    LinearLayout chineseLayout;
    LinearLayout pakistaniLayout;
    LinearLayout japaneseLayout;

    TextView turkishText;
    TextView indianText;
    TextView chineseText;
    TextView pakistaniText;
    TextView japaneseText;

    ImageView turkishSelected;
    ImageView indianSelected;
    ImageView chineseSelected;
    ImageView pakistaniSelected;
    ImageView japaneseSelected;

    Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_nationality);

        turkishLayout = findViewById(R.id.turkishLayout);
        indianLayout = findViewById(R.id.indianLayout);
        chineseLayout = findViewById(R.id.chineseLayout);
        pakistaniLayout = findViewById(R.id.pakistaniLayout);
        japaneseLayout = findViewById(R.id.japaneseLayout);

        turkishSelected = findViewById(R.id.turkishSelectedImage);
        indianSelected = findViewById(R.id.indianSelectedImage);
        chineseSelected = findViewById(R.id.chineseSelectedImage);
        pakistaniSelected = findViewById(R.id.pakistaniSelectedImage);
        japaneseSelected = findViewById(R.id.japaneseSelectedImage);

        turkishText = findViewById(R.id.turkishText);
        turkishText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable bgColor = (ColorDrawable)turkishLayout.getBackground();
                if(bgColor.getColor() != ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory)){
                    turkishLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory));
                    turkishSelected.setImageResource(R.drawable.check_image);
                }else{
                    turkishLayout.setBackgroundColor(Color.WHITE);
                }
            }
        });
        indianText = findViewById(R.id.indianText);
        indianText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable bgColor = (ColorDrawable)indianLayout.getBackground();
                if(bgColor.getColor() != ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory)){
                    indianLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory));
                    indianSelected.setImageResource(R.drawable.check_image);
                }else{
                    indianLayout.setBackgroundColor(Color.WHITE);
                }
            }
        });
        chineseText = findViewById(R.id.chineseText);
        chineseText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable bgColor = (ColorDrawable)chineseLayout.getBackground();
                if(bgColor.getColor() != ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory)){
                    chineseLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory));
                    chineseSelected.setImageResource(R.drawable.check_image);
                }else{
                    chineseLayout.setBackgroundColor(Color.WHITE);
                }
            }
        });
        pakistaniText = findViewById(R.id.pakistaniText);
        pakistaniText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable bgColor = (ColorDrawable)pakistaniLayout.getBackground();
                if(bgColor.getColor() != ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory)){
                    pakistaniLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory));
                    pakistaniSelected.setImageResource(R.drawable.check_image);
                }else{
                    pakistaniLayout.setBackgroundColor(Color.WHITE);
                }
            }
        });
        japaneseText = findViewById(R.id.japaneseText);
        japaneseText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable bgColor = (ColorDrawable)japaneseLayout.getBackground();
                if(bgColor.getColor() != ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory)){
                    japaneseLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory));
                    japaneseSelected.setImageResource(R.drawable.check_image);
                }else{
                    japaneseLayout.setBackgroundColor(Color.WHITE);
                }
            }
        });
    }
}
