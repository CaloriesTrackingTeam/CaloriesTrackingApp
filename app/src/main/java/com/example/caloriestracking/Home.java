package com.example.caloriestracking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.caloriestracking.adapter.ExercisekHomeAdapter;
import com.example.caloriestracking.adapter.FoodAdapter;
import com.example.caloriestracking.adapter.FoodHomeAdapter;
import com.example.caloriestracking.model.Exercisek;
import com.example.caloriestracking.model.Food;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Home extends AppCompatActivity {
    TextView NumberReceived, NumberCaloriesNeed, NumberConsumed, NumberCarbs, NumberFat, NumberWaterNeed,
            NumberCaloBreakfast, NumberCaloDinner, NumberCaloActivities, NumberGoal
            , NumberProtein, today;
    ImageView btnAddBreakfast, btnAddDinner, btnAddActivities;
    BottomNavigationView btv;
    RecyclerView rcvBreakfast, rcvDinner, rcvActivities;
    List<Exercisek> listExecise;
    List<Food> listBreakfast;
    List<Food> listDinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findByID_Element();

        setupNavBottom();

        setupRecycleView();
        
        setAddClick();
        
        caculateInfoCalories();
    }

    private void caculateInfoCalories() {
        double carbs = 0, protein = 0, fat = 0;
        //calo breakfast
        double totalBreakfast = 0;
        for (Food item: listBreakfast) {
            totalBreakfast += item.getFoodCalories();
            if(item.getFoodCarbs() != 0) carbs += item.getFoodCarbs();
            if(item.getFoodProtein() != 0) protein += item.getFoodProtein();
            if(item.getFoodFat() != 0) fat += item.getFoodFat();
        }
        NumberCaloBreakfast.setText(totalBreakfast + "");

        //calo Dinner
        double totalDinner = 0;
        for (Food item: listDinner) {
            totalDinner += item.getFoodCalories();
            if(item.getFoodCarbs() != 0) carbs += item.getFoodCarbs();
            if(item.getFoodProtein() != 0) protein += item.getFoodProtein();
            if(item.getFoodFat() != 0) fat += item.getFoodFat();
        }
        NumberCaloDinner.setText(totalDinner + "");

        //calo Activities
        double totalActivities = 0;
        for (Exercisek item: listExecise) {
            totalActivities += item.getExerciseCalories();
        }
        NumberCaloActivities.setText(totalActivities + "");

        //receive: đã nhận (lượng calo đã ăn vào)
        double totalReceive = totalDinner + totalBreakfast;
        NumberReceived.setText(totalReceive + "");

        //consumed: tiêu thụ (lượng calo đã ăn vào)
        double totalconsumed = totalReceive - totalActivities;
        NumberConsumed.setText(totalconsumed + "");

        //num carbs
        NumberCarbs.setText(carbs + "");
        //number protetin
        NumberProtein.setText(protein + "");
        //number fat
        NumberFat.setText(fat + "");
    }

    private void setAddClick() {
        btnAddBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home.this, "btnAddBreakfast", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Home.this, [...].class);
//                startActivity(intent);
            }
        });

        btnAddActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home.this, "btnAddActivities", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Home.this, [...].class);
//                startActivity(intent);
            }
        });

        btnAddDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home.this, "btnAddDinner", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Home.this, [...].class);
//                startActivity(intent);
            }
        });
    }

    private void setupRecycleView() {
        //---------list breakfast
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvBreakfast.setLayoutManager(linearLayoutManager);
        FoodHomeAdapter foodAdapterBreakfast = new FoodHomeAdapter(getListFoodBreakfast(), this);
        rcvBreakfast.setAdapter(foodAdapterBreakfast);

        //---------list dinner
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        rcvDinner.setLayoutManager(linearLayoutManager2);
        FoodHomeAdapter foodAdapterDinner = new FoodHomeAdapter(getListDinner(), this);
        rcvDinner.setAdapter(foodAdapterDinner);

        //------list Execise
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this);
        rcvActivities.setLayoutManager(linearLayoutManager3);
        ExercisekHomeAdapter exercisekHomeAdapter = new ExercisekHomeAdapter(getListExercise(), this);
        rcvActivities.setAdapter(exercisekHomeAdapter);
    }

    private List<Exercisek> getListExercise() {
        listExecise = new ArrayList<>();
        listExecise.add(new Exercisek("walk", 100, 15));
        listExecise.add(new Exercisek("push up", 100, 15));
        listExecise.add(new Exercisek("plank", 100, 15));
        listExecise.add(new Exercisek("run", 100, 15));

        return listExecise;
    }

    private List<Food> getListFoodBreakfast() {
        listBreakfast = new ArrayList<>();
        listBreakfast.add(new Food("Pho", 200, 300));
        listBreakfast.add(new Food("Bun Bo Hue", 200, 300));
        listBreakfast.add(new Food("Com Tam", 200, 300));
        listBreakfast.add(new Food("Trung tran", 200, 300));

        return listBreakfast;
    }

    private List<Food> getListDinner() {
        listDinner = new ArrayList<>();
        listDinner.add(new Food("Pho", 200, 300));
        listDinner.add(new Food("Bun Bo Hue", 200, 300));
        listDinner.add(new Food("Trung tran", 200, 300));

        return listDinner;
    }

    private void findByID_Element() {
        NumberReceived = findViewById(R.id.NumberReceived);
        NumberCaloriesNeed = findViewById(R.id.NumberCaloriesNeed);
        NumberConsumed = findViewById(R.id.NumberConsumed);
        NumberCarbs = findViewById(R.id.NumberCarbs);
        NumberFat = findViewById(R.id.NumberFat);
        NumberWaterNeed = findViewById(R.id.NumberWaterNeed);
        NumberCaloBreakfast = findViewById(R.id.NumberCaloBreakfast);
        NumberCaloDinner = findViewById(R.id.NumberCaloDinner);
        NumberCaloActivities = findViewById(R.id.NumberCaloActivities);
        NumberGoal = findViewById(R.id.NumberGoal);
        NumberProtein = findViewById(R.id.NumberProtein);

        btnAddBreakfast = findViewById(R.id.btnAddBreakfast);
        btnAddDinner = findViewById(R.id.btnAddDinner);
        btnAddActivities = findViewById(R.id.btnAddActivities);

        rcvBreakfast = findViewById(R.id.rcvBreakfast);
        rcvDinner = findViewById(R.id.rcvDinner);
        rcvActivities = findViewById(R.id.rcvActivities);

        today = findViewById(R.id.today);
        Calendar cal = Calendar.getInstance();
        int dayofmonth = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);

        today.setText(dayofmonth + " th" + (month  +1));
    }

    private void setupNavBottom() {
        btv = findViewById(R.id.bottom_nav);
        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.ac_home){
                    System.out.println("btv_ac_favorite_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                } else if(item.getItemId() == R.id.ac_search){
                    System.out.println("btv_ac_search_click");
                    startActivity(new Intent(Home.this, Find_Food.class));
                }else if(item.getItemId() == R.id.ac_favorite){
                    System.out.println("btv_ac_favorite_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                }else if(item.getItemId() == R.id.ac_user_page){
                    System.out.println("btv_ac_user_page_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                }else if(item.getItemId() == R.id.ac_predict){
                    System.out.println("btv_ac_ac_predict_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                }
                return true;
            }
        });
    }
}