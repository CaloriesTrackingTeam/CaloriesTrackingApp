package com.example.caloriestracking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.Time;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.caloriestracking.ListData.ListDataSource;
import com.example.caloriestracking.adapter.ExercisekHomeAdapter;
import com.example.caloriestracking.adapter.FoodAdapter;
import com.example.caloriestracking.adapter.FoodHomeAdapter;
import com.example.caloriestracking.adapter.FoodHomeAdapterDinner;
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
    List<Exercisek> listExecise, listActivity;
    List<Food> listBreakfast;
    List<Food> listDinner, list;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        list = getListFood();
        listExecise = getListExercise();
        findByID_Element();
        email= sharedPreferences.getString("email", "");

        try{
            String weight = sharedPreferences.getString("weight", "");
            String target = sharedPreferences.getString("target", "");
            switch (target){
                case "Keep Weight":
                    NumberGoal.setText(weight);
                    break;
                case "Gain Weight":
                    double kg = Double.parseDouble(weight);
                    double targetkg = kg + 5;
                    NumberGoal.setText(targetkg + "");
                    break;
                case "Losing Weight":
                    double kg1 = Double.parseDouble(weight);
                    double targetkg1 = kg1 - 5;
                    NumberGoal.setText(targetkg1 + "");
                    break;
            }
        }catch (Exception ex){

        }

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
        for (Exercisek item: listActivity) {
            totalActivities += item.getExerciseCalories() * item.getMinutes();
        }
        NumberCaloActivities.setText(totalActivities + "");

        //receive: đã nhận (lượng calo đã ăn vào)
        double totalReceive = totalDinner + totalBreakfast;
        NumberReceived.setText(totalReceive + "");

        //consumed: tiêu thụ (lượng calo đã ăn vào - vận động tốn calo)
        double totalconsumed = totalReceive - totalActivities;
        NumberConsumed.setText(totalconsumed + "");

        carbs = Math.ceil(carbs * Math.pow(10, 1)) / Math.pow(10, 1);
        protein = Math.ceil(protein * Math.pow(10, 1)) / Math.pow(10, 1);
        fat = Math.ceil(fat * Math.pow(10, 1)) / Math.pow(10, 1);

        //num carbs
        NumberCarbs.setText(carbs + "");
        //number protetin
        NumberProtein.setText(protein + "");
        //number fat
        NumberFat.setText(fat + "");

        //number calories need a day
        String heightc = sharedPreferences.getString("height", "");
        String weightc = sharedPreferences.getString("weight", "");
        String agec = sharedPreferences.getString("age", "");
        try{
            double heightm = Double.parseDouble(heightc);
            double weightm = Double.parseDouble(weightc);
            int agem = Integer.parseInt(agec);
            String sexc = sharedPreferences.getString("sex", "");

            if(sexc.equals("male")){

            }
            double caloNeed = (6.25 * heightm) + (10 * weightm) - (5 * agem) + 5;
            NumberCaloriesNeed.setText(Math.ceil(caloNeed) + "");
        }catch (Exception ex){

        }

    }

    private void setAddClick() {
        btnAddBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Home.this, "btnAddBreakfast", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Home.this, Find_Today_Food.class);
                editor.putString("LIST_FOOD", "breakfast");
                editor.commit();
                startActivity(intent);
            }
        });

        btnAddActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);	//"MY_APP": chỉ là cái tên của Shared preference;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String premeum = sharedPreferences.getString("premium", "");
                if(premeum.equals("true")){
                    //Toast.makeText(Home.this, "btnAddActivities", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Home.this, Find_Today_Activity.class);
                    //phải qua list activity trc r chọ 1 cái trong list mới tới đây
                    //intent.putExtra("ID_ACTIVITY_CLICK", "1");
                    startActivity(intent);
                }else{
                    Toast.makeText(Home.this, "You must premium account to access", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnAddDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Home.this, "btnAddDinner", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Home.this, Find_Today_Food.class);
                editor.putString("LIST_FOOD", "dinner");
                editor.commit();
                startActivity(intent);
            }
        });
    }

    private void setupRecycleView() {
        //---------list breakfast
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvBreakfast.setLayoutManager(linearLayoutManager);
        FoodHomeAdapter foodAdapterBreakfast = new FoodHomeAdapter(getListFoodBreakfast(), this, sharedPreferences);
        rcvBreakfast.setAdapter(foodAdapterBreakfast);

        //---------list dinner
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        rcvDinner.setLayoutManager(linearLayoutManager2);
        FoodHomeAdapterDinner foodAdapterDinner = new FoodHomeAdapterDinner(getListDinner(), this, sharedPreferences);
        rcvDinner.setAdapter(foodAdapterDinner);

        //------list Execise
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this);
        rcvActivities.setLayoutManager(linearLayoutManager3);
        ExercisekHomeAdapter exercisekHomeAdapter = new ExercisekHomeAdapter(getListActivity(), this, sharedPreferences);
        rcvActivities.setAdapter(exercisekHomeAdapter);
    }

    private List<Exercisek> getListExercise() {
        listExecise = new ArrayList<>();
        ListDataSource listDataSource = new ListDataSource();
        listExecise = listDataSource.getExercisekList();
        return listExecise;
    }
    private List<Food> getListFood() {
        list = new ArrayList<>();
        ListDataSource listDataSource = new ListDataSource();
        list = listDataSource.getFoodList();
        return list;
    }

    private List<Food> getListFoodBreakfast() {
        listBreakfast = new ArrayList<>();

        String listToday = sharedPreferences.getString("LIST_FOOD_BREAKFAST_TODAY"+email, "");

        if(listToday != null && !listToday.equals("")) {
            if(listToday.trim().length() > 0){
                if(listToday.charAt(0) == ' '){
                    listToday = listToday.substring(1);
                }
                //list có data r
                String[] listId = listToday.split(" ");
                for (String id: listId) {
                    Food f = getFoodById(Integer.parseInt(id));
                    listBreakfast.add(f);
                }
            }
        }
        return listBreakfast;
    }

    public Food getFoodById(int id){
        for (Food item: list) {
            if(item.getFoodID() == id)
                return item;
        }
        return null;
    }

    public Exercisek getExeciseById(int id){
        for (Exercisek item: listExecise) {
            if(item.getExerciseID() == id)
                return item;
        }
        return null;
    }

    private List<Food> getListDinner() {
        listDinner = new ArrayList<>();//
        String listToday = sharedPreferences.getString("LIST_FOOD_DINNER_TODAY"+email, "");

        if(listToday != null && !listToday.equals("")) {
            if(listToday.trim().length() > 0){
                if(listToday.charAt(0) == ' '){
                    listToday = listToday.substring(1);
                }
                //list có data r
                String[] listId = listToday.split(" ");
                for (String id: listId) {
                    Food f = getFoodById(Integer.parseInt(id));
                    listDinner.add(f);
                }
            }
        }
        return listDinner;
    }

    private List<Exercisek> getListActivity(){
        listActivity = new ArrayList<>();
        String listToday = sharedPreferences.getString("LIST_EXCECISE_TODAY"+email, "");
        //vd: " 1 p9" --> execise 1, 9 phút

        if(listToday != null && !listToday.equals("")) {
            if(listToday.trim().length() > 0){
                if(listToday.charAt(0) == ' '){
                    listToday = listToday.substring(1);
                }    //--> "1 p9"
                //list có data r
                String[] listId = listToday.split(" "); //--> ["1", "p9"]
                Exercisek f = null;
                for (int i = 0; i < listId.length; i++) {
                    if(i % 2 == 0){ //đang là id
                        f = getExeciseById(Integer.parseInt(listId[i]));
                        //cập nhật minutes
                        String minutesCaculate = listId[i+1];   //p10
                        minutesCaculate = minutesCaculate.substring(1); //"10"
                        int minutesCaculateInt = Integer.parseInt(minutesCaculate); //10
                        f.setMinutes(minutesCaculateInt);

                        listActivity.add(f);
                    }
                }
            }
        }
        return listActivity;
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

        String todayNow = dayofmonth + " th" + (month  +1);
        today.setText(todayNow);
        sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);	//"MY_APP": chỉ là cái tên của Shared preference;
        editor = sharedPreferences.edit();

        String email = sharedPreferences.getString("email", "");
        String todayINApp = sharedPreferences.getString("TODAY", "");
        if(todayINApp != null){
            if(!todayINApp.equals(todayNow)){
                //qua ngày mới -> reset hết
                editor.putString("LIST_FOOD_BREAKFAST_TODAY" + email, "");
                editor.putString("LIST_FOOD_DINNER_TODAY" + email, "");
                editor.putString("LIST_EXCECISE_TODAY" + email, "");
                editor.commit();
            }
        }

        editor.putString("TODAY", todayNow);
        editor.commit();
    }

    private void setupNavBottom() {
        btv = findViewById(R.id.bottom_nav);
        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.ac_home){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(Home.this, Home.class));
                } else if(item.getItemId() == R.id.ac_search){
                    System.out.println("btv_ac_search_click");
                    startActivity(new Intent(Home.this, Find_Food.class));
                }else if(item.getItemId() == R.id.ac_favorite){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(Home.this, Find_Favorite_Food.class));
                }else if(item.getItemId() == R.id.ac_user_page){
                    System.out.println("btv_ac_user_page_click");
                    startActivity(new Intent(Home.this, User_Profile_Activity.class));
                }else if(item.getItemId() == R.id.ac_predict){
                    System.out.println("btv_ac_ac_predict_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                }
                return true;
            }
        });
    }
}