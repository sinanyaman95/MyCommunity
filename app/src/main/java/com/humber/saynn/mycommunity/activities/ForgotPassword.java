package com.humber.saynn.mycommunity.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.humber.saynn.mycommunity.R;

public class ForgotPassword extends AppCompatActivity {

    Button sendEmail;
    EditText emailText;
    FirebaseAuth firebaseAuth;
    ProgressDialog progress;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        firebaseAuth = FirebaseAuth.getInstance();
        sendEmail = findViewById(R.id.sendEmail);
        emailText = findViewById(R.id.emailEditTextPw);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int w = dm.widthPixels;
        int h = dm.heightPixels;

        int newWidth = (int) (w*0.9);
        int newHeight = (int) (h*0.6);

        getWindow().setLayout(newWidth,newHeight);

    }

    public void sendEmail(View v){
        String email = emailText.getText().toString();
        progress = new ProgressDialog(this);
        progress.setTitle("Please Wait");
        progress.setMessage("Sending reset link");
        progress.setCancelable(false);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.show();
        firebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Can't send email.",Toast.LENGTH_SHORT).show();
                        }else{
                            progress.cancel();
                            Toast.makeText(getApplicationContext(),"Password is sent to your email.",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

}
