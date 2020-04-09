package com.humber.saynn.mycommunity.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.humber.saynn.mycommunity.R;
import com.humber.saynn.mycommunity.database.FirebaseDb;

import java.util.ArrayList;

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
    String userEmail;
    boolean turkish, indian, chinese, pakistani, japanese;
    FirebaseDb db = FirebaseDb.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_nationality);
        Intent i = getIntent();
        if(i.hasExtra(LogIn.USER_EMAIL)) userEmail = i.getStringExtra(LogIn.USER_EMAIL);

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

        continueButton = findViewById(R.id.continueButton);

        turkishText = findViewById(R.id.turkishText);
        turkishLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable bgColor = (ColorDrawable)turkishLayout.getBackground();
                if(bgColor.getColor() != ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory)){
                    turkishLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory));
                    turkishSelected.setImageResource(R.drawable.check_image);
                    turkish = true;
                }else{
                    turkishLayout.setBackgroundColor(Color.WHITE);
                    turkishSelected.setImageDrawable(null);
                    turkish = false;
                }
            }
        });
        indianText = findViewById(R.id.indianText);
        indianLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable bgColor = (ColorDrawable)indianLayout.getBackground();
                if(bgColor.getColor() != ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory)){
                    indianLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory));
                    indianSelected.setImageResource(R.drawable.check_image);
                    indian = true;
                }else{
                    indianLayout.setBackgroundColor(Color.WHITE);
                    indianSelected.setImageDrawable(null);
                    indian = false;
                }
            }
        });
        chineseText = findViewById(R.id.chineseText);
        chineseLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable bgColor = (ColorDrawable)chineseLayout.getBackground();
                if(bgColor.getColor() != ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory)){
                    chineseLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory));
                    chineseSelected.setImageResource(R.drawable.check_image);
                    chinese = true;
                }else{
                    chineseLayout.setBackgroundColor(Color.WHITE);
                    chineseSelected.setImageDrawable(null);
                    chinese = false;
                }
            }
        });
        pakistaniText = findViewById(R.id.pakistaniText);
        pakistaniLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable bgColor = (ColorDrawable)pakistaniLayout.getBackground();
                if(bgColor.getColor() != ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory)){
                    pakistaniLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory));
                    pakistaniSelected.setImageResource(R.drawable.check_image);
                    pakistani = true;
                }else{
                    pakistaniLayout.setBackgroundColor(Color.WHITE);
                    pakistaniSelected.setImageDrawable(null);
                    pakistani = false;
                }
            }
        });
        japaneseText = findViewById(R.id.japaneseText);
        japaneseLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable bgColor = (ColorDrawable)japaneseLayout.getBackground();
                if(bgColor.getColor() != ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory)){
                    japaneseLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.selectedCategory));
                    japaneseSelected.setImageResource(R.drawable.check_image);
                    japanese = true;
                }else{
                    japaneseLayout.setBackgroundColor(Color.WHITE);
                    japaneseSelected.setImageDrawable(null);
                    japanese = false;
                }
            }
        });
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserPreference();
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra(LogIn.USER_EMAIL,userEmail);
                startActivity(i);
            }
        });
    }

    private void addUserPreference() {
        ArrayList<String> communitiesSelected = new ArrayList<>();
        if(turkish) communitiesSelected.add("turkish");
        if(indian) communitiesSelected.add("indian");
        if(chinese) communitiesSelected.add("chinese");
        if(japanese) communitiesSelected.add("japanese");
        if(pakistani) communitiesSelected.add("pakistani");

        for(String s: communitiesSelected){
            db.addCommunity(s,userEmail);
        }

    }
}
