package com.example.caloriestracking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.caloriestracking.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class User_Setting_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setting);

        Button modebtn = findViewById((R.id.modeButton));
        Button locabtn = findViewById((R.id.locationButton));
        Button notibtn = findViewById((R.id.notiButton));
        Button helpbtn = findViewById((R.id.helpCenterButton2));
        Button outbtn = findViewById((R.id.logOutButton2));

        BottomNavigationView btv = findViewById(R.id.bottom_nav_setting);

        // setting mode
        modebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("modebtn lick");
                //startActivity(new Intent(User_Setting_Activity.this, [...].class));
            }
        });

        // setting location
        locabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("locabtn lick");
                //startActivity(new Intent(User_Setting_Activity.this, [...].class));
            }
        });

        // setting notification
        notibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("notibtn lick");
                //startActivity(new Intent(User_Setting_Activity.this, [...].class));
            }
        });

        // setting Help Center
        helpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("helpbtn lick");
                startActivity(new Intent(User_Setting_Activity.this, Help_Center_Activity.class));
            }
        });

        // user Log out
        outbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("btnFace lick");
                startActivity(new Intent(User_Setting_Activity.this, LoginActivity.class));
            }
        });

        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.ac_home){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(User_Setting_Activity.this, Home.class));
                } else if(item.getItemId() == R.id.ac_search){
                    System.out.println("btv_ac_search_click");
                    startActivity(new Intent(User_Setting_Activity.this, Find_Food.class));
                }else if(item.getItemId() == R.id.ac_favorite){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(User_Setting_Activity.this, Find_Favorite_Food.class));
                }else if(item.getItemId() == R.id.ac_user_page){
                    System.out.println("btv_ac_user_page_click");
                    startActivity(new Intent(User_Setting_Activity.this, User_Profile_Activity.class));
                }else if(item.getItemId() == R.id.ac_predict){
                    System.out.println("btv_ac_ac_predict_click");
                    //startActivity(new Intent(User_Setting_Activity.this, [home].class));
                }
                return true;
            }
        });
    }
}