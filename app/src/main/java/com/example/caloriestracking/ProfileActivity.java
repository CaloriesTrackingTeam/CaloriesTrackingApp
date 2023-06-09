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

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {
    ImageView profile_img, settingsImg, threesDot;
    TextView tvUserName, tvnumberBMI, tvHeight, tvWeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        findBYId_Ele();

        SharedPreferences sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        BottomNavigationView btv = findViewById(R.id.bottom_nav2);
        TextView viewbmi = findViewById(R.id.tvnumberBMI);
        TextView viewh = findViewById(R.id.tvHeight);
        TextView vieww = findViewById(R.id.tvWeight);
        Button nextbtn = findViewById(R.id.nextbtn);

        int weight =Integer.parseInt(sharedPreferences.getString("weight", "")) ;
        int height =Integer.parseInt(sharedPreferences.getString("height", "")) ;

        viewbmi.setText((int) calculateBMI(weight, height));
        viewh.setText(height + " cm");
        vieww.setText(weight + " kg");

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, UpdateBMR_Activity.class));
            }
        });

        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.ac_home){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(ProfileActivity.this, Home.class));
                } else if(item.getItemId() == R.id.ac_search){
                    System.out.println("btv_ac_search_click");
                    startActivity(new Intent(ProfileActivity.this, Find_Food.class));
                }else if(item.getItemId() == R.id.ac_favorite){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(ProfileActivity.this, Find_Favorite_Food.class));
                }else if(item.getItemId() == R.id.ac_user_page){
                    System.out.println("btv_ac_user_page_click");
                    startActivity(new Intent(ProfileActivity.this, User_Profile_Activity.class));
                }else if(item.getItemId() == R.id.ac_predict){
                    System.out.println("btv_ac_ac_predict_click");
                    //startActivity(new Intent(User_Profile_Activity.this, [home].class));
                }
                return true;
            }
        });

    }

    private void findBYId_Ele() {
        profile_img = findViewById(R.id.profile_img);
        settingsImg = findViewById(R.id.settingsImg);
        threesDot = findViewById(R.id.threesDot);

        tvUserName = findViewById(R.id.tvUserName);
        tvnumberBMI = findViewById(R.id.tvnumberBMI);
        tvHeight = findViewById(R.id.tvHeight);
        tvWeight = findViewById(R.id.tvWeight);

    }

    public double calculateBMI(double weight, double height){
        return weight / height * height;
    }
}