package com.example.caloriestracking.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.caloriestracking.ActivityDetail;
import com.example.caloriestracking.ActivityDetailFavourite;
import com.example.caloriestracking.DetailFood;
import com.example.caloriestracking.R;
import com.example.caloriestracking.model.Activity;
import com.example.caloriestracking.model.Food;

import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder> {

    private List<Activity> activityList;
    private Context context;
    private boolean listFavo;
    public ActivityAdapter(List<Activity> activityList, Context context) {
        this.activityList = activityList;
        this.context = context;
        listFavo = false;
    }

    public ActivityAdapter(List<Activity> activityList, Context context, boolean listFavo) {
        this.activityList = activityList;
        this.context = context;
        this.listFavo = listFavo;
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
                System.out.println("click " + a.getActivityName() + "- id:" + a.getActivityID());

                if(listFavo == true){
                    Intent intent = new Intent(context, ActivityDetailFavourite.class);
                    intent.putExtra("ID_ACTIVITY_CLICK", a.getActivityID() + "");
                    context.startActivity(intent);
                }else{
                    Intent intent = new Intent(context, ActivityDetail.class);
                    intent.putExtra("ID_ACTIVITY_CLICK", a.getActivityID() + "");
                    context.startActivity(intent);
                }
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
