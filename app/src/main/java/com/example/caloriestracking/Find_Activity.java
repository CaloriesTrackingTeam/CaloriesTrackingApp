package com.example.caloriestracking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.caloriestracking.ListData.ListDataSource;
import com.example.caloriestracking.adapter.ActivityAdapter;
import com.example.caloriestracking.adapter.FoodAdapter;
import com.example.caloriestracking.model.Activity;
import com.example.caloriestracking.model.Exercisek;
import com.example.caloriestracking.model.Food;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Find_Activity extends AppCompatActivity {

    RecyclerView rcv;

    List<Activity> list;
    Button FoodButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        BottomNavigationView btv = findViewById(R.id.bottom_nav);
        FoodButton = findViewById(R.id.FoodButton);
        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.ac_home){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(Find_Activity.this, Home.class));
                } else if(item.getItemId() == R.id.ac_search){
                    System.out.println("btv_ac_search_click");
                    startActivity(new Intent(Find_Activity.this, Find_Food.class));
                }else if(item.getItemId() == R.id.ac_favorite){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(Find_Activity.this, Find_Favorite_Food.class));
                }else if(item.getItemId() == R.id.ac_user_page){
                    System.out.println("btv_ac_user_page_click");
                    startActivity(new Intent(Find_Activity.this, User_Profile_Activity.class));
                }else if(item.getItemId() == R.id.ac_predict){
                    System.out.println("btv_ac_ac_predict_click");
                    //startActivity(new Intent(Find_Activity.this, [home].class));
                }
                return true;
            }
        });

        //set up reccyle view
        rcv = findViewById(R.id.rcv_Activity);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);   //dạng cột và có 2 cột
        rcv.setLayoutManager(gridLayoutManager);

        ActivityAdapter activityAdapter = new ActivityAdapter(getActivityList(), this);
        rcv.setAdapter(activityAdapter);

        //set up search icon click
        ImageView iconSearch = findViewById(R.id.iconSearch);
        iconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterByName();
            }
        });

        FoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Find_Activity.this, Find_Food.class));
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

//    private List<Activity> getActivityList(){
//        list = new ArrayList<>();
//        list.add(new Activity("Walk"));
//        list.add(new Activity("Run"));
//        list.add(new Activity("Jump"));
//        list.add(new Activity("Fly"));
//        list.add(new Activity("Riding"));
//        list.add(new Activity("Push up"));
//        list.add(new Activity("Push out"));
//        list.add(new Activity("Push on"));
//        list.add(new Activity("Push Left"));
//        list.add(new Activity("Push Right"));
//        list.add(new Activity("Push Down"));
//        list.add(new Activity("Jumping Jack"));
//        list.add(new Activity("Jumping Tony"));
//        list.add(new Activity("Jumping Elsa"));
//        list.add(new Activity("Jumping Elizabeth"));
//        list.add(new Activity("Jumping John"));
//        list.add(new Activity("Plank"));
//        list.add(new Activity("Riding Horse"));
//        list.add(new Activity("Swimming"));
//        return list;
//    }

    private List<Activity> getActivityList() {
        list = new ArrayList<>();
        ListDataSource listDataSource = new ListDataSource();
        list = listDataSource.getActivityList();
        return list;
    }

}