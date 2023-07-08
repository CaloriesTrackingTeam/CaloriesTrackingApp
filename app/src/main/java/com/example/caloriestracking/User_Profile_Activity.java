package com.example.caloriestracking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caloriestracking.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

public class User_Profile_Activity extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        SharedPreferences sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        img = findViewById(R.id.imageUserView);
        Picasso.get()
                .load(sharedPreferences.getString("avatar", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvvM28d4SBcH4SrXJQuSp4RBPLIlvY-HagBA&usqp=CAU"))
                .into(img);

        Button bmibtn = findViewById((R.id.yourBMIButton));
        Button editbtn = findViewById((R.id.editProfileButton));
        Button subbtn = findViewById((R.id.subscriptionButton));
        Button setbtn = findViewById((R.id.settingButton));
        Button helpbtn = findViewById((R.id.helpCenterButton));
        Button outbtn = findViewById((R.id.logOutButton1));
        Button trackbutton = findViewById((R.id.trackbutton));

        BottomNavigationView btv = findViewById(R.id.bottom_nav2);

        TextView usernameview = findViewById(R.id.viewUserName);
        String fullName = sharedPreferences.getString("fullName", "");
        usernameview.setText(fullName);

        //track button
        trackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("trackbutton lick");
                startActivity(new Intent(User_Profile_Activity.this, ReportTrack.class));
            }
        });

        // user edit BMI
        bmibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("bmibtn lick");
                startActivity(new Intent(User_Profile_Activity.this, ProfileActivity.class));
            }
        });

        // user edit Profile
        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("editbtn lick");
                startActivity(new Intent(User_Profile_Activity.this, Edit_Profile_Activity.class));
            }
        });

        // user Subcriptions
        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("subbtn lick");
                startActivity(new Intent(User_Profile_Activity.this, Subcriptions_Activity.class));
            }
        });

        // user app setting
        setbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("setbtn lick");
                startActivity(new Intent(User_Profile_Activity.this, User_Setting_Activity.class));
            }
        });

        // user use Help Center
        helpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("helpbtn lick");
                startActivity(new Intent(User_Profile_Activity.this, Help_Center_Activity.class));
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
                    startActivity(new Intent(User_Profile_Activity.this, Home.class));
                } else if(item.getItemId() == R.id.ac_search){
                    System.out.println("btv_ac_search_click");
                    startActivity(new Intent(User_Profile_Activity.this, Find_Food.class));
                }else if(item.getItemId() == R.id.ac_favorite){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(User_Profile_Activity.this, Find_Favorite_Food.class));
                }else if(item.getItemId() == R.id.ac_user_page){
                    System.out.println("btv_ac_user_page_click");
                    startActivity(new Intent(User_Profile_Activity.this, User_Profile_Activity.class));
                }else if(item.getItemId() == R.id.ac_predict){
                    System.out.println("btv_ac_ac_predict_click");
                    //startActivity(new Intent(User_Profile_Activity.this, [home].class));
                }
                return true;
            }
        });
    }
}