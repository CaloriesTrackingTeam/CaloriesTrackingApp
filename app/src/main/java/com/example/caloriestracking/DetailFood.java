package com.example.caloriestracking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.caloriestracking.ListData.ListDataSource;
import com.example.caloriestracking.model.Food;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailFood extends AppCompatActivity {
    ImageView ArrowBack, tymFood, FoodPicture;
    TextView calory_minute_food, gramCarbsFood, gramProteinFood, gramFatFood, foodDesciption,
            food_How_to_cook, TvHowToBurnOut, NameFood;
    BottomNavigationView btv;
    Button buttonFavorite;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    List<Food> list;
    Food foodDetail;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);
        list = getListFood();

        findById_Ele();
        email = sharedPreferences.getString("email", "");

        setupNavBottom();

        //intent get id of food --> find  food by id
        //map all dta in screen
        Intent intent = getIntent();
        if(intent != null){
            String idFoodClick = intent.getStringExtra("ID_FOOD_CLICK");
            int id = Integer.parseInt(idFoodClick);
            Food food = getFoodById(id);
            if(food != null){
                foodDetail = food;
                mapDataToscreen();
            }
        }

        //click ArrowBack
        ArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailFood.this, Find_Food.class));
            }
        });

        //tymFood
        tymFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save id food to share reference
                saveFoodIdToListFoodFavourite();
                //startActivity(new Intent(DetailFood.this, Home.class));
            }
        });

        //click button favourite
        buttonFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailFood.this, Home.class);
                saveFoodIdToListFoodFavourite();
                startActivity(intent);
            }
        });
    }

    private void saveFoodIdToListFoodFavourite() {
        String listFavo = sharedPreferences.getString("LIST_FOOD_FAVORITE"+email, "");

        if(listFavo != null){
            if(listFavo.trim().length() > 0){
                if(listFavo.charAt(0) == ' '){
                    listFavo = listFavo.substring(1);
                }
                //list có data r
                String[] listId = listFavo.split(" ");
                boolean same = false;
                for (String id: listId) {
                    if(id.equals(foodDetail.getFoodID() + "")){
                        same = true;
                    }
                }

                if(same == false){
                    listFavo += " " + foodDetail.getFoodID();
                    editor.putString("LIST_FOOD_FAVORITE"+email, listFavo);
                    editor.commit();
                    Toast.makeText(this, "Save "+foodDetail.getFoodName()+" to favourite Food success", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Food "+foodDetail.getFoodName()+" already in favourite Food", Toast.LENGTH_SHORT).show();
                }
            }else{
                //list chua có gì
                listFavo += " " + foodDetail.getFoodID();
                editor.putString("LIST_FOOD_FAVORITE"+email, listFavo);
                editor.commit();
                Toast.makeText(this, "Save "+foodDetail.getFoodName()+" to favourite Food success", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void mapDataToscreen() {
        calory_minute_food.setText(foodDetail.getFoodCalories() + " calo/ " + foodDetail.getFoodWeight() + " gram");
        Picasso.get().load(foodDetail.getFoodAvatar()).into(FoodPicture);
        gramCarbsFood.setText(foodDetail.getFoodCarbs() + "");
        gramProteinFood.setText(foodDetail.getFoodProtein() + "");
        gramFatFood.setText(foodDetail.getFoodFat() + "");
        foodDesciption.setText(foodDetail.getFoodDescription());
        food_How_to_cook.setText(foodDetail.getRecipe());
        NameFood.setText(foodDetail.getFoodName());
    }

    public Food getFoodById(int id){
        for (Food item: list) {
            if(item.getFoodID() == id)
                return item;
        }
        return null;
    }

    private void findById_Ele() {
        NameFood = findViewById(R.id.NameFood);
        ArrowBack = findViewById(R.id.ArrowBack);
        tymFood = findViewById(R.id.tymFood);
        FoodPicture = findViewById(R.id.FoodPicture);

        calory_minute_food = findViewById(R.id.calory_minute_food);
        gramCarbsFood = findViewById(R.id.gramCarbsFood);
        gramProteinFood = findViewById(R.id.gramProteinFood);
        gramFatFood = findViewById(R.id.gramFatFood);
        foodDesciption = findViewById(R.id.foodDesciption);
        food_How_to_cook = findViewById(R.id.food_How_to_cook);
        TvHowToBurnOut = findViewById(R.id.TvHowToBurnOut);

        buttonFavorite = findViewById(R.id.buttonFavorite);

        sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);	//"MY_APP": chỉ là cái tên của Shared preference;
        editor = sharedPreferences.edit();
    }

    private List<Food> getListFood() {
        list = new ArrayList<>();
        ListDataSource listDataSource = new ListDataSource();
        list = listDataSource.getFoodList();
        return list;
    }
    private void setupNavBottom() {
        btv = findViewById(R.id.bottom_nav);
        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.ac_home){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(DetailFood.this, Home.class));
                } else if(item.getItemId() == R.id.ac_search){
                    System.out.println("btv_ac_search_click");
                    startActivity(new Intent(DetailFood.this, Find_Food.class));
                }else if(item.getItemId() == R.id.ac_favorite){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(DetailFood.this, Find_Favorite_Food.class));
                }else if(item.getItemId() == R.id.ac_user_page){
                    System.out.println("btv_ac_user_page_click");
                    startActivity(new Intent(DetailFood.this, User_Profile_Activity.class));
                }else if(item.getItemId() == R.id.ac_predict){
                    System.out.println("btv_ac_ac_predict_click");
                    //startActivity(new Intent(DetailFood.this, [home].class));
                }
                return true;
            }
        });
    }
}