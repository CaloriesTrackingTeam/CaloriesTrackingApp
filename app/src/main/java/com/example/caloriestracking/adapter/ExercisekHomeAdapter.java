package com.example.caloriestracking.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.caloriestracking.R;
import com.example.caloriestracking.model.Exercisek;
import com.example.caloriestracking.model.Food;

import java.util.ArrayList;
import java.util.List;

public class ExercisekHomeAdapter extends RecyclerView.Adapter<ExercisekHomeAdapter.ExercisekHomeViewHolder>{

    private List<Exercisek> listExe;
    private Context context;
    //-----------
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String email;

    public ExercisekHomeAdapter(List<Exercisek> listExe, Context context, SharedPreferences sharedPreferences) {
        this.listExe = listExe;
        this.context = context;
        this.sharedPreferences = sharedPreferences;
        editor = sharedPreferences.edit();
        email = sharedPreferences.getString("email", "");
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

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "click delete breakfast food " + f.getFoodName(), Toast.LENGTH_SHORT).show();
                deleteActivityIdToListActivityToday(f);
                context.startActivity(new Intent(context, context.getClass()));
            }
        });
    }

    private void deleteActivityIdToListActivityToday(Exercisek exercisekDetail) {

        String listfavo = sharedPreferences.getString("LIST_EXCECISE_TODAY"+email, "");
        //vd: " 1 p9" --> execise 1, 9 phút

        if(listfavo != null){
            if(listfavo.trim().length() > 0){
                if(listfavo.charAt(0) == ' '){
                    listfavo = listfavo.substring(1);
                }   // -> "1 p9 2 p1"

                //list có data r
                String[] listId = listfavo.split(" ");  //--> ["1", "p9", "2", "p1"]
                List<String> stringList = new ArrayList<>();
                for (String id: listId) {
                    //add vào stringList cho dễ delete
                    stringList.add(id);
                }
                //delete activity id in list
                if(stringList.contains(exercisekDetail.getExerciseID() + "")){
                    int index = stringList.indexOf(exercisekDetail.getExerciseID() + "");
                    stringList.remove(exercisekDetail.getExerciseID() + "");
                    stringList.remove(index);
                }
                //create list favo again
                listfavo = "";
                for (String id: stringList) {
                    listfavo += " " + id;
                }
                //share lên sharereference lại
                editor.putString("LIST_EXCECISE_TODAY"+email, listfavo);
                editor.commit();
                Toast.makeText(context, "delete "+exercisekDetail.getExerciseName()+" from today success", Toast.LENGTH_SHORT).show();

            }
        }
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
        private ImageView imgDelete;
        public ExercisekHomeViewHolder(@NonNull View itemView) {
            super(itemView);
            //-----------item_list_home
            NameElement = itemView.findViewById(R.id.NameElement);
            InfoNameElement = itemView.findViewById(R.id.InfoNameElement);
            cardview_Ele = itemView.findViewById(R.id.cardview_Ele);
            imgDelete = itemView.findViewById(R.id.imgDelete);
        }
    }
}
