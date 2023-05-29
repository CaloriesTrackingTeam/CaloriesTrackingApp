package com.example.caloriestracking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

public class DetailFood extends AppCompatActivity {
    ImageView ArrowBack, tymFood, FoodPicture;
    TextView calory_minute_food, gramCarbsFood, gramProteinFood, gramFatFood, foodDesciption, food_How_to_cook, TvHowToBurnOut;
    BottomNavigationView btv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);

        findById_Ele();

        setupNavBottom();

        //set img from link
        String imageUrl = "https://i-giadinh.vnecdn.net/2021/10/26/saladrauqua-1635240739-5476-1635240778.jpg"; // Thay thế link ảnh thật của bạn
        Picasso.get().load(imageUrl).into(FoodPicture);
    }

    private void findById_Ele() {
        ArrowBack = findViewById(R.id.ArrowBack);
        tymFood = findViewById(R.id.tymFood);
        FoodPicture = findViewById(R.id.FoodPicture);

        calory_minute_food = findViewById(R.id.calory_minute_food);
        gramCarbsFood = findViewById(R.id.gramCarbsFood);
        gramProteinFood = findViewById(R.id.gramProteinFood);
        gramFatFood = findViewById(R.id.gramFatFood);
        foodDesciption = findViewById(R.id.foodDesciption);
        food_How_to_cook = findViewById(R.id.food_How_to_cook);
        TvHowToBurnOut = findViewById(R.id.TvHowToBurnOut);
    }

    private void setupNavBottom() {
        btv = findViewById(R.id.bottom_nav);
        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.ac_home){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(DetailFood.this, Home.class));
                } else if(item.getItemId() == R.id.ac_search){
                    System.out.println("btv_ac_search_click");
                    //startActivity(new Intent(Home.this, Find_Food.class));
                }else if(item.getItemId() == R.id.ac_favorite){
                    System.out.println("btv_ac_favorite_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                }else if(item.getItemId() == R.id.ac_user_page){
                    System.out.println("btv_ac_user_page_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                }else if(item.getItemId() == R.id.ac_predict){
                    System.out.println("btv_ac_ac_predict_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                }
                return true;
            }
        });
    }
}