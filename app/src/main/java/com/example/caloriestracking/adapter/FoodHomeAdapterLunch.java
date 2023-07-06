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
import com.example.caloriestracking.model.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodHomeAdapterLunch  extends RecyclerView.Adapter<FoodHomeAdapterLunch.FoodHomeLunchViewHolder>{

    private List<Food> listFood;
    private Context context;
    //-----------
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String email;

    public FoodHomeAdapterLunch(List<Food> listFood, Context context, SharedPreferences sharedPreferences) {
        this.listFood = listFood;
        this.context = context;
        this.sharedPreferences = sharedPreferences;
        editor = sharedPreferences.edit();
        email = sharedPreferences.getString("email", "");
    }


    @NonNull
    @Override
    public FoodHomeLunchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_home, parent, false);
        return new FoodHomeAdapterLunch.FoodHomeLunchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodHomeLunchViewHolder holder, int position) {
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

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "click delete breakfast food " + f.getFoodName(), Toast.LENGTH_SHORT).show();
                deleteFoodIdToListFoodLunchToday(f);
                context.startActivity(new Intent(context, context.getClass()));
            }
        });
    }

    private void deleteFoodIdToListFoodLunchToday(Food foodDetail) {
        String listfavo = sharedPreferences.getString("LIST_FOOD_LUNCH_TODAY"+ email, "");

        if(listfavo != null){
            if(listfavo.trim().length() > 0){   //cắt khoản trống ' ' đầu list
                if(listfavo.charAt(0) == ' '){
                    listfavo = listfavo.substring(1);
                }

                //list có data r
                String[] listId = listfavo.split(" ");
                List<String> stringList = new ArrayList<>();
                for (String id: listId) {
                    //add vào stringList cho dễ delete
                    stringList.add(id);
                }
                //delete food id in list
                if(stringList.contains(foodDetail.getFoodID() + "")){
                    stringList.remove(foodDetail.getFoodID() + "");
                }
                //create list favo again
                listfavo = "";
                for (String id: stringList) {
                    listfavo += " " + id;
                }
                //share lên sharereference lại
                editor.putString("LIST_FOOD_LUNCH_TODAY"+email, listfavo);
                editor.commit();
                Toast.makeText(context, "delete "+foodDetail.getFoodName()+" from lunch success", Toast.LENGTH_SHORT).show();

            }
        }
    }

    @Override
    public int getItemCount() {
        if(listFood != null){
            return listFood.size();
        }
        return 0;
    }

    public class FoodHomeLunchViewHolder extends RecyclerView.ViewHolder{
        private TextView NameElement, InfoNameElement;
        private CardView cardview_Ele;
        private ImageView imgDelete;
        public FoodHomeLunchViewHolder(@NonNull View itemView) {
            super(itemView);
            //-----------item_list_home
            NameElement = itemView.findViewById(R.id.NameElement);
            InfoNameElement = itemView.findViewById(R.id.InfoNameElement);
            cardview_Ele = itemView.findViewById(R.id.cardview_Ele);
            imgDelete = itemView.findViewById(R.id.imgDelete);
        }
    }
}
