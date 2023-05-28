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
import com.example.caloriestracking.model.Exercisek;
import com.example.caloriestracking.model.Food;

import java.util.List;

public class ExercisekHomeAdapter extends RecyclerView.Adapter<ExercisekHomeAdapter.ExercisekHomeViewHolder>{

    private List<Exercisek> listExe;
    private Context context;

    public ExercisekHomeAdapter(List<Exercisek> listExe, Context context) {
        this.listExe = listExe;
        this.context = context;
    }

    @NonNull
    @Override
    public ExercisekHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_home, parent, false);
        return new ExercisekHomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExercisekHomeViewHolder holder, int position) {
        Exercisek f = listExe.get(position);
        if(f == null) return;

        //-----------item_list_home
        holder.NameElement.setText(f.getExerciseName());
        holder.InfoNameElement.setText(f.getExerciseCalories() + " kcal - " + f.getMinutes() + " minutes");
        holder.cardview_Ele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //....
                System.out.println("click execise home" + f.getExerciseName());
                Toast.makeText(context, "click execise home" + f.getExerciseName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listExe != null){
            return listExe.size();
        }
        return 0;
    }

    public class ExercisekHomeViewHolder extends RecyclerView.ViewHolder{
        private TextView NameElement, InfoNameElement;
        private CardView cardview_Ele;
        public ExercisekHomeViewHolder(@NonNull View itemView) {
            super(itemView);
            //-----------item_list_home
            NameElement = itemView.findViewById(R.id.NameElement);
            InfoNameElement = itemView.findViewById(R.id.InfoNameElement);
            cardview_Ele = itemView.findViewById(R.id.cardview_Ele);
        }
    }
}
