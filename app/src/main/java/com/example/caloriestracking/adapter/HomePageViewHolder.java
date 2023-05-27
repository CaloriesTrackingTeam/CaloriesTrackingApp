package com.example.caloriestracking.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.caloriestracking.R;

public class HomePageViewHolder extends RecyclerView.ViewHolder {

    TextView textView;

    public HomePageViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textview);
    }
}
