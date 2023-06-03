package com.example.caloriestracking.adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.caloriestracking.DetailFood;
import com.example.caloriestracking.Home;
import com.example.caloriestracking.LoginActivity;
import com.example.caloriestracking.R;
import com.example.caloriestracking.model.Food;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{
    //find food screen
    private List<Food> listFood;
    private Context context;

    public FoodAdapter(List<Food> listFood, Context context) {
        this.listFood = listFood;
        this.context = context;
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
                System.out.println("click " + f.getFoodName() + "- id:" + f.getFoodID());

                Intent intent = new Intent(context, DetailFood.class);
                intent.putExtra("ID_FOOD_CLICK", f.getFoodID() + "");
                context.startActivity(intent);

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
