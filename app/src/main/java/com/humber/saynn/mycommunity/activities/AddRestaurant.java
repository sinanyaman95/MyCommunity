package com.humber.saynn.mycommunity.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.humber.saynn.mycommunity.R;

public class AddRestaurant extends AppCompatActivity {

    EditText nameText, urlText;
    TextView photoText;
    Button done;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*0.9), (int) (height*0.7));

        nameText = findViewById(R.id.foodNameText);
        urlText = findViewById(R.id.foodURLText);
        photoText = findViewById(R.id.foodImageText);
        done = findViewById(R.id.addDoneButton);
    }
}
