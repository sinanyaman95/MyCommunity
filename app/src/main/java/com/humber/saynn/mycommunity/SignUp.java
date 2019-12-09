package com.humber.saynn.mycommunity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    EditText emailEditText, nameEditText, surnameEditText, passwordEditText, usernameEditText;
    Button signUpButton;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFirebaseAuth = FirebaseAuth.getInstance();

        emailEditText = findViewById(R.id.emailEditText);
        nameEditText = findViewById(R.id.nameEditText);
        surnameEditText = findViewById(R.id.surnameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        usernameEditText = findViewById(R.id.usernameEditText);
        signUpButton = findViewById(R.id.signUpButton);

        Intent intent = getIntent();
        if (intent.hasExtra("email")) {
            String emailEntered = intent.getStringExtra("email");
            emailEditText.setText(emailEntered);
        }

    }

    public void registerAccount(View v){
        String email = emailEditText.getText().toString();
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String name = nameEditText.getText().toString();
        String surname = surnameEditText.getText().toString();

        if(email.isEmpty()){
            emailEditText.setError("Please enter email");
            emailEditText.requestFocus();
        }else if(username.isEmpty()){
            usernameEditText.setError("Please enter username");
            usernameEditText.requestFocus();
        }else if(password.isEmpty()){
            passwordEditText.setError("Please enter password");
            passwordEditText.requestFocus();
        }else if(name.isEmpty() || surname.isEmpty()){
            Toast.makeText(getApplicationContext(),"Fields are empty.",Toast.LENGTH_SHORT).show();
            nameEditText.requestFocus();
        }else {
            mFirebaseAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),task.getException()+"",Toast.LENGTH_SHORT).show();
                            }else{
                                Intent i = new Intent(getApplicationContext(),ChooseCommunity.class);
                                startActivity(i);
                            }
                        }
                    });
        }
    }
}
