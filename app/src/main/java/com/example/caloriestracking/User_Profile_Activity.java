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

public class User_Profile_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Button bmibtn = findViewById((R.id.yourBMIButton));
        Button editbtn = findViewById((R.id.editProfileButton));
        Button subbtn = findViewById((R.id.subscriptionButton));
        Button setbtn = findViewById((R.id.settingButton));
        Button helpbtn = findViewById((R.id.helpCenterButton));
        Button outbtn = findViewById((R.id.logOutButton1));

        BottomNavigationView btv = findViewById(R.id.bottom_nav2);

        // user edit BMI
        bmibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("bmibtn lick");
                //startActivity(new Intent(User_Profile_Activity.this, [...].class));
            }
        });

        // user edit Profile
        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("editbtn lick");
                //startActivity(new Intent(User_Profile_Activity.this, [...].class));
            }
        });

        // user Subcriptions
        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("subbtn lick");
                //startActivity(new Intent(User_Profile_Activity.this, [...].class));
            }
        });

        // user app setting
        setbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("setbtn lick");
                //startActivity(new Intent(User_Profile_Activity.this, [...].class));
            }
        });

        // user use Help Center
        helpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("helpbtn lick");
                //startActivity(new Intent(User_Profile_Activity.this, [...].class));
            }
        });

        // user Log out
        outbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("btnFace lick");
                startActivity(new Intent(User_Profile_Activity.this, LoginActivity.class));
            }
        });

        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.ac_home){
                    System.out.println("btv_ac_favorite_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                } else if(item.getItemId() == R.id.ac_search){
                    System.out.println("btv_ac_search_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                }else if(item.getItemId() == R.id.ac_favorite){
                    System.out.println("btv_ac_favorite_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                }else if(item.getItemId() == R.id.ac_user_page){
                    System.out.println("btv_ac_user_page_click");
                    startActivity(new Intent(User_Profile_Activity.this, User_Profile_Activity.class));
                }
                return true;
            }
        });
    }
}