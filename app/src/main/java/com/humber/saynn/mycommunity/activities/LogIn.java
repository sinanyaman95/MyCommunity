package com.humber.saynn.mycommunity.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.humber.saynn.mycommunity.R;
import com.humber.saynn.mycommunity.database.FirebaseDb;

import java.util.HashMap;

public class LogIn extends AppCompatActivity {

    public static final String USER_EMAIL = "user_email";
    private static final String USER_REGISTER = "user_register";
    private static final String USER_COUNTER = "user_counter";


    Button signUpButton;
    EditText emailEditText,passwordEditText;
    private FirebaseAuth.AuthStateListener authStateListener;
    FirebaseAuth firebaseAuth;
    TextView forgotPasswordText;
    String userEmail;
    FirebaseDb db = FirebaseDb.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        emailEditText = findViewById(R.id.emailEditTextLogin);
        passwordEditText = findViewById(R.id.passwordEditTextLogin);
        forgotPasswordText =findViewById(R.id.forgotPasswordText);
        signUpButton = findViewById(R.id.signUpButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignUp.class);
                String tempEmail = emailEditText.getText().toString();
                if (!emailEditText.getText().toString().equals("")) {
                    i.putExtra("email", emailEditText.getText().toString());
                }
                startActivity(i);
            }
        });

        authStateListener = new FirebaseAuth.AuthStateListener() {
            final FirebaseUser user = firebaseAuth.getCurrentUser();

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (user != null) {
                    Toast.makeText(getApplicationContext(),"Welcome Back!",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    public void signIn(View v){
        final String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if(email.isEmpty()){
            emailEditText.setError("Please enter email");
            emailEditText.requestFocus();
        }else if(password.isEmpty()){
            passwordEditText.setError("Please enter password");
            passwordEditText.requestFocus();
        }else{
            firebaseAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(LogIn.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Login can't be completed.",Toast.LENGTH_SHORT).show();
                            }else{
                                Intent i = new Intent(getApplicationContext(), ChooseCommunity.class);
                                i.putExtra(USER_EMAIL,emailEditText.getText().toString());;
                                db.checkUserExists(emailEditText.getText().toString());
                                startActivity(i);
                            }
                        }
                    });
        }
    }

    public void forgotPassword(View v){
        Intent i = new Intent(this,ForgotPassword.class);
        startActivity(i);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //firebaseAuth.addAuthStateListener(authStateListener);
    }
}
