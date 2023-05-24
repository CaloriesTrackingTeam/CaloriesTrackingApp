package com.example.caloriestracking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.caloriestracking.adapter.FoodAdapter;
import com.example.caloriestracking.model.Food;

import java.util.ArrayList;
import java.util.List;

public class Find_Food extends AppCompatActivity {

    RecyclerView rcv;
    List<Food> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_food);

        rcv = findViewById(R.id.rcv_Food);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);   //dạng cột và có 2 cột
        rcv.setLayoutManager(gridLayoutManager);

        FoodAdapter foodAdapter = new FoodAdapter(getListFood());
        rcv.setAdapter(foodAdapter);

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