package com.example.caloriestracking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.caloriestracking.adapter.HomePageAdapter;
import com.example.caloriestracking.model.Food;

import java.util.ArrayList;
import java.util.List;

public class UserHomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page);

        RecyclerView recyclerView = findViewById(R.id.recyclerview1);

        List<Food> foods = new ArrayList<Food>();
        foods.add(new Food("Dumpling"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new HomePageAdapter(getApplicationContext(),foods));
    }
}