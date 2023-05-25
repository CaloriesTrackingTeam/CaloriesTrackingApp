package com.example.caloriestracking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.caloriestracking.adapter.FoodAdapter;
import com.example.caloriestracking.model.Food;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Find_Food extends AppCompatActivity {

    RecyclerView rcv;
    List<Food> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_food);

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
                    //startActivity(new Intent(Find_Food.this, [home].class));
                }
                return true;
            }
        });

        //set up reccyle view
        rcv = findViewById(R.id.rcv_Food);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);   //dạng cột và có 2 cột
        rcv.setLayoutManager(gridLayoutManager);

        FoodAdapter foodAdapter = new FoodAdapter(getListFood());
        rcv.setAdapter(foodAdapter);

        //set up search icon click
        ImageView iconSearch = findViewById(R.id.iconSearch);
        iconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterByName();
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

        FoodAdapter foodAdapter = new FoodAdapter(listSearch);
        rcv.setAdapter(foodAdapter);
    }

    private List<Food> getListFood() {
        list = new ArrayList<>();
        list.add(new Food("Pho"));
        list.add(new Food("Bún Bò Huế"));
        list.add(new Food("Bún Đậu Mắm Tôm"));
        list.add(new Food("Hủ Tiếu"));
        list.add(new Food("Cháo Lòng"));
        list.add(new Food("Tiết Canh"));
        list.add(new Food("Food7"));
        list.add(new Food("Food8"));
        list.add(new Food("Food9"));
        list.add(new Food("Pho"));
        list.add(new Food("Bún Bò Huế"));
        list.add(new Food("Bún Đậu Mắm Tôm"));
        list.add(new Food("Hủ Tiếu"));
        list.add(new Food("Cháo Lòng"));
        list.add(new Food("Tiết Canh"));
        list.add(new Food("Food7"));
        list.add(new Food("Food8"));
        list.add(new Food("Food9"));
        list.add(new Food("Pho"));
        list.add(new Food("Bún Bò Huế"));
        list.add(new Food("Bún Đậu Mắm Tôm"));
        list.add(new Food("Hủ Tiếu"));
        list.add(new Food("Cháo Lòng"));
        list.add(new Food("Tiết Canh"));
        list.add(new Food("Food7"));
        list.add(new Food("Food8"));
        list.add(new Food("Food9"));
        list.add(new Food("Pho"));
        list.add(new Food("Bún Bò Huế"));
        list.add(new Food("Bún Đậu Mắm Tôm"));
        list.add(new Food("Hủ Tiếu"));
        list.add(new Food("Cháo Lòng"));
        list.add(new Food("Tiết Canh"));
        list.add(new Food("Food7"));
        list.add(new Food("Food8"));
        list.add(new Food("Food9"));
        return list;
    }
}