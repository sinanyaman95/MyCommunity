package com.humber.saynn.mycommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    EditText emailEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailEditText = findViewById(R.id.emailEditText);
        Intent intent = getIntent();
        if (intent.hasExtra("email")) {
            String emailEntered = intent.getStringExtra("email");
            emailEditText.setText(emailEntered);
        }

    }
}
