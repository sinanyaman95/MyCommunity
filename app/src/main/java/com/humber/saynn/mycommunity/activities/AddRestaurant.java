package com.humber.saynn.mycommunity.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.humber.saynn.mycommunity.R;
import com.humber.saynn.mycommunity.database.FirebaseDb;
import com.humber.saynn.mycommunity.entities.Food;
import com.humber.saynn.mycommunity.entities.FoodContent;

import java.io.IOException;

public class AddRestaurant extends AppCompatActivity{
    public static final int PICTURE_REQUEST_CODE = 99;
    EditText nameText, urlText;
    TextView photoText;
    Button done;
    Bitmap bitmap;
    Spinner dropdown;
    String foodCountry;
    String[] nationalities = {"turkish","indian","japanese","chinese","pakistani","general"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*0.9), (int) (height*0.7));


        dropdown = findViewById(R.id.countryDropdown);
        ArrayAdapter<String> dropdownAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                nationalities);
        dropdownAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(dropdownAdapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                foodCountry = nationalities[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        nameText = findViewById(R.id.foodNameText);
        urlText = findViewById(R.id.foodURLText);
        photoText = findViewById(R.id.foodImageText);
        photoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImageFile();
            }
        });
        done = findViewById(R.id.addDoneButton);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRestaurant();
            }
        });
    }

    private void addRestaurant() {
        String name = nameText.getText().toString();
        String url = urlText.getText().toString();

        int image = R.drawable.fried_chicken;
        Food f;
        if(!foodCountry.equals("")){
            Log.d("syDebug", "Country: " + foodCountry );
            f = new Food(name,image,url,foodCountry);
            FoodContent fc = FoodContent.getInstance();
            fc.addFood(f);
            //TODO: call this once you handle nationality
            FirebaseDb db = FirebaseDb.getInstance();
            db.addFood(f);
        }
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(i);
    }

    private void chooseImageFile(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),
                PICTURE_REQUEST_CODE);
    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICTURE_REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
