package com.example.caloriestracking.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.caloriestracking.R;
import com.example.caloriestracking.model.Activity;
import com.example.caloriestracking.model.Food;

import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder> {

    private List<Activity> activityList;

    public ActivityAdapter(List<Activity> activityList) {
        this.activityList = activityList;
    }

    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, int position) {
        Activity a = activityList.get(position);
        if(a == null) return;

        holder.nameEle.setText(a.getActivityName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //....
                System.out.println("click " + a.getActivityName());
            }
        });
    }

    @Override
    public int getItemCount() {
        if(activityList != null){
            return activityList.size();
        }
        return 0;
    }

    public class ActivityViewHolder extends RecyclerView.ViewHolder{
        private TextView nameEle;
        private CardView cardView;
        public ActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            nameEle = itemView.findViewById(R.id.nameEleList);
            cardView = itemView.findViewById(R.id.itemEleRcv);
        }
    }
}
