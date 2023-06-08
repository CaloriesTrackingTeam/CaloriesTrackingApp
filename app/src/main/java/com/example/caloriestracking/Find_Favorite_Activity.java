package com.example.caloriestracking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.caloriestracking.ListData.ListDataSource;
import com.example.caloriestracking.adapter.ActivityAdapter;
import com.example.caloriestracking.model.Activity;
import com.example.caloriestracking.model.Food;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Find_Favorite_Activity extends AppCompatActivity {
    RecyclerView rcv;

    List<Activity> list, listFavouActi;
    Button FoodButton;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_favorite);

        list = getActivityList();
        sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);	//"MY_APP": chỉ là cái tên của Shared preference;
        editor = sharedPreferences.edit();

        BottomNavigationView btv = findViewById(R.id.bottom_nav);
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
                    startActivity(new Intent(Find_Favorite_Activity.this, User_Profile_Activity.class));
                }
                return true;
            }
        });

        //set up reccyle view
        rcv = findViewById(R.id.rcv_Activity);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);   //dạng cột và có 2 cột
        rcv.setLayoutManager(gridLayoutManager);

        ActivityAdapter activityAdapter = new ActivityAdapter(getListActiFavo(), this, true);
        rcv.setAdapter(activityAdapter);

        //set up search icon click
        ImageView iconSearch = findViewById(R.id.iconSearch);
        iconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterByName();
            }
        });
        FoodButton = findViewById(R.id.FoodButton);
        FoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Find_Favorite_Activity.this, Find_Favorite_Food.class));
            }
        });
    }

    private void filterByName() {
        EditText edValueSearch = findViewById(R.id.searchValue);
        String value = edValueSearch.getText().toString();
        List<Activity> listSearch = new ArrayList<>();
        for (Activity item: list) {
            if(item.getActivityName().toLowerCase().contains(value.toLowerCase())){
                listSearch.add(item);
            }
        }

        ActivityAdapter activityAdapter = new ActivityAdapter(listSearch, this);
        rcv.setAdapter(activityAdapter);
    }

    private List<Activity> getActivityList(){
        ListDataSource listDataSource = new ListDataSource();
        list = listDataSource.getActivityList();
        return list;
    }

    private List<Activity> getListActiFavo() {
        listFavouActi = new ArrayList<>();

        String listToday = sharedPreferences.getString("LIST_ACTIVITY_FAVORITE", "");

        if(listToday != null) {
            if(listToday.trim().length() > 0){
                if(listToday.charAt(0) == ' '){
                    listToday = listToday.substring(1);
                }
                //list có data r
                String[] listId = listToday.split(" ");
                for (String id: listId) {
                    Activity f = getActiById(Integer.parseInt(id));
                    listFavouActi.add(f);
                }
            }
        }
        return listFavouActi;
    }

    public Activity getActiById(int id){
        for (Activity item: list) {
            if(item.getActivityID() == id)
                return item;
        }
        return null;
    }
}