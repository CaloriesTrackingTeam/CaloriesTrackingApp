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
import com.example.caloriestracking.adapter.FoodAdapter;
import com.example.caloriestracking.model.Food;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Find_Favorite_Food extends AppCompatActivity {
    RecyclerView rcv;
    List<Food> list;
    Button ExerciseButton;
    List<Food> listFavouFood;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_favorite_food);

        list = getListFood();
        ExerciseButton = findViewById(R.id.ExerciseButton);
        sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);	//"MY_APP": chỉ là cái tên của Shared preference;
        editor = sharedPreferences.edit();
        email = sharedPreferences.getString("email", "");

        BottomNavigationView btv = findViewById(R.id.bottom_nav);
        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.ac_home){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(Find_Favorite_Food.this, Home.class));
                } else if(item.getItemId() == R.id.ac_search){
                    System.out.println("btv_ac_search_click");
                    startActivity(new Intent(Find_Favorite_Food.this, Find_Food.class));
                }else if(item.getItemId() == R.id.ac_favorite){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(Find_Favorite_Food.this, Find_Favorite_Food.class));
                }else if(item.getItemId() == R.id.ac_user_page){
                    System.out.println("btv_ac_user_page_click");
                    startActivity(new Intent(Find_Favorite_Food.this, User_Profile_Activity.class));
                }else if(item.getItemId() == R.id.ac_predict){
                    System.out.println("btv_ac_ac_predict_click");
                    //startActivity(new Intent(Find_Favorite_Food.this, [home].class));
                }
                return true;
            }
        });

        //set up reccyle view
        rcv = findViewById(R.id.rcv_Food);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);   //dạng cột và có 2 cột
        rcv.setLayoutManager(gridLayoutManager);

        FoodAdapter foodAdapter = new FoodAdapter(getListFoodFavo(), this, true);
        rcv.setAdapter(foodAdapter);

        //set up search icon click
        ImageView iconSearch = findViewById(R.id.iconSearch);
        iconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterByName();
            }
        });

        ExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Find_Favorite_Food.this, Find_Favorite_Activity.class));
            }
        });
    }

    private void filterByName() {
        EditText edValueSearch = findViewById(R.id.searchValue);
        String value = edValueSearch.getText().toString();
        List<Food> listSearch = new ArrayList<>();
        for (Food item: list) {
            if(item.getFoodName().toLowerCase().contains(value.toLowerCase())){
                listSearch.add(item);
            }
        }

        FoodAdapter foodAdapter = new FoodAdapter(listSearch, this);
        rcv.setAdapter(foodAdapter);
    }

    private List<Food> getListFood() {
        ListDataSource listDataSource = new ListDataSource();
        list = listDataSource.getFoodList();
        return list;
    }

    private List<Food> getListFoodFavo() {
        listFavouFood = new ArrayList<>();

        String listToday = sharedPreferences.getString("LIST_FOOD_FAVORITE"+email, "");

        if(listToday != null) {
            if(listToday.trim().length() > 0){
                if(listToday.charAt(0) == ' '){
                    listToday = listToday.substring(1);
                }
                //list có data r
                String[] listId = listToday.split(" ");
                for (String id: listId) {
                    Food f = getFoodById(Integer.parseInt(id));
                    listFavouFood.add(f);
                }
            }
        }
        return listFavouFood;
    }

    public Food getFoodById(int id){
        for (Food item: list) {
            if(item.getFoodID() == id)
                return item;
        }
        return null;
    }
}