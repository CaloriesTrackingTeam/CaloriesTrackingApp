package com.example.caloriestracking.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.caloriestracking.R;
import com.example.caloriestracking.model.Food;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{

    private List<Food> listFood;

    public FoodAdapter(List<Food> listFood) {
        this.listFood = listFood;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food f = listFood.get(position);
        if(f == null) return;

        holder.nameEle.setText(f.getFoodName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //....
                System.out.println("click " + f.getFoodName());
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listFood != null){
            return listFood.size();
        }
        return 0;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{
        private TextView nameEle;
        private CardView cardView;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            nameEle = itemView.findViewById(R.id.nameEleList);
            cardView = itemView.findViewById(R.id.itemEleRcv);
        }
    }

}
