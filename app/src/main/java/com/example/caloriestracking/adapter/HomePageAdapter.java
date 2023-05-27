package com.example.caloriestracking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.caloriestracking.R;
import com.example.caloriestracking.model.Food;

import java.util.List;

public class HomePageAdapter extends RecyclerView.Adapter<HomePageViewHolder> {

    Context context;
    List<Food> foods;

    public HomePageAdapter(Context context, List<Food> foods) {
        this.context = context;
        this.foods = foods;
    }

    @NonNull
    @Override
    public HomePageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomePageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view_home_page,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageViewHolder holder, int position) {
        holder.textView.setText(foods.get(position).getFoodName());
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }
}
