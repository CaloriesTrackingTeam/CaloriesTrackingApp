package com.example.caloriestracking.adapter;

import android.content.Context;
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

public class FoodHomeAdapter extends RecyclerView.Adapter<FoodHomeAdapter.FoodHomeViewHolder>{

    private List<Food> listFood;
    private Context context;

    public FoodHomeAdapter(List<Food> listFood, Context context) {
        this.listFood = listFood;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodHomeAdapter.FoodHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_home, parent, false);
        return new FoodHomeAdapter.FoodHomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodHomeAdapter.FoodHomeViewHolder holder, int position) {
        Food f = listFood.get(position);
        if(f == null) return;

        //-----------item_list_home
        holder.NameElement.setText(f.getFoodName());
        holder.InfoNameElement.setText(f.getFoodWeight() + " g - " + f.getFoodCalories() + " calo");
        holder.cardview_Ele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //....
                System.out.println("click food home" + f.getFoodName());
                Toast.makeText(context, "click food home" + f.getFoodName(), Toast.LENGTH_SHORT).show();
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

    public class FoodHomeViewHolder extends RecyclerView.ViewHolder{
        private TextView  NameElement, InfoNameElement;
        private CardView  cardview_Ele;
        public FoodHomeViewHolder(@NonNull View itemView) {
            super(itemView);
            //-----------item_list_home
            NameElement = itemView.findViewById(R.id.NameElement);
            InfoNameElement = itemView.findViewById(R.id.InfoNameElement);
            cardview_Ele = itemView.findViewById(R.id.cardview_Ele);
        }
    }

}
