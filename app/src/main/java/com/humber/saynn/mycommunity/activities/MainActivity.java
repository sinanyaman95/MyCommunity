package com.humber.saynn.mycommunity.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.humber.saynn.mycommunity.R;
import com.humber.saynn.mycommunity.fragment.HorizontalFoodFragment;
import com.humber.saynn.mycommunity.fragment.ProfileFragment;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navView;
    FirebaseAuth firebaseAuth;
    Fragment profileFrag;

    String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent mainIntent = getIntent();
        if(mainIntent.hasExtra(LogIn.USER_EMAIL)) userEmail = mainIntent.getStringExtra(LogIn.USER_EMAIL);
        navView = findViewById(R.id.navigation);
        Toolbar toolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);

        navView.setNavigationItemSelectedListener(this);

        drawerLayout = findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar,
                R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        profileFrag = new ProfileFragment(userEmail);

        if(savedInstanceState==null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            fragmentTransaction.replace(R.id.fragmentContainer, profileFrag).commit();
            fragmentTransaction.addToBackStack(null);
            navView.setCheckedItem(R.id.menu_profile);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        profileFrag.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.menu_profile:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer, new ProfileFragment(userEmail)).commit();
                    break;
                case R.id.menu_explore:
                    startActivity(new Intent(this,FoodBlog.class));
                    break;
                case R.id.menu_logout:
                    new AlertDialog.Builder(this)
                            .setTitle("Quitting the App")
                            .setMessage("This will exit the app, Press OK to Exit, Cancel to get back to app")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    firebaseAuth = FirebaseAuth.getInstance();
                                    firebaseAuth.signOut();
                                    Intent a = new Intent(Intent.ACTION_MAIN);
                                    a.addCategory(Intent.CATEGORY_HOME);
                                    a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(a);
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .create()
                            .show();

            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        new AlertDialog.Builder(this)
                .setTitle("Quitting the App")
                .setMessage("This will exit the app, Press OK to Exit, Cancel to get back to app")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent a = new Intent(Intent.ACTION_MAIN);
                        a.addCategory(Intent.CATEGORY_HOME);
                        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(a);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();

    }
}
