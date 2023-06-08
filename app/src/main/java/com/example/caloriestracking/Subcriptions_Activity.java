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
import com.squareup.picasso.Picasso;

public class Subcriptions_Activity extends AppCompatActivity {
    ImageView img ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcriptions);

        img = findViewById(R.id.imageUserView);


        SharedPreferences sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Picasso.get()
                .load(sharedPreferences.getString("avatar", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvvM28d4SBcH4SrXJQuSp4RBPLIlvY-HagBA&usqp=CAU"))
                .into(img);

        // button buy premium
        Button buybtn = findViewById(R.id.buyButton);
        buybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Subcriptions_Activity.this, HowToBuyPremium.class));
            }
        });

        BottomNavigationView btv = findViewById(R.id.bottom_nav2);

        TextView usernameview = findViewById(R.id.viewUserName);
        String fullName = sharedPreferences.getString("fullName", "");
        usernameview.setText(fullName);



        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.ac_home){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(Subcriptions_Activity.this, Home.class));
                } else if(item.getItemId() == R.id.ac_search){
                    System.out.println("btv_ac_search_click");
                    startActivity(new Intent(Subcriptions_Activity.this, Find_Food.class));
                }else if(item.getItemId() == R.id.ac_favorite){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(Subcriptions_Activity.this, Find_Favorite_Food.class));
                }else if(item.getItemId() == R.id.ac_user_page){
                    System.out.println("btv_ac_user_page_click");
                    startActivity(new Intent(Subcriptions_Activity.this, User_Profile_Activity.class));
                }else if(item.getItemId() == R.id.ac_predict){
                    System.out.println("btv_ac_ac_predict_click");
                    //startActivity(new Intent(Subcriptions_Activity.this, [home].class));
                }
                return true;
            }
        });
    }
}