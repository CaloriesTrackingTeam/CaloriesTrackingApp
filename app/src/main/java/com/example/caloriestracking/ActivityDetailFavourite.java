package com.example.caloriestracking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.caloriestracking.ListData.ListDataSource;
import com.example.caloriestracking.model.Exercisek;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ActivityDetailFavourite extends AppCompatActivity {

    Button buttonDeleteFavorite;
    ImageView tymActivity, ActivityPicture, ArrowBack;
    TextView NameActivity, calory_minute_activity, ActivityDesciption, ActivityGuide;
    BottomNavigationView btv;
    Exercisek exercisekDetail;
    List<Exercisek> listExecise;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_favourite);
        listExecise = getListExercise();
        finbyId_Activity();
        setupNavBottom();
        email = sharedPreferences.getString("email", "");

        //fake data input
//        Exercisek exercisek1 = getExeciseById(2);
//        if(exercisek1 != null){
//            exercisekDetail = exercisek1;
//            mapDataToscreen();
//        }

        //intent get id of activity --> find  activity by id
        //map all dta in screen
        Intent intent = getIntent();
        if(intent != null){
            String idActivityClick = intent.getStringExtra("ID_ACTIVITY_CLICK");
            int id = Integer.parseInt(idActivityClick);
            Exercisek exercisek = getExeciseById(id);
            if(exercisek != null){
                exercisekDetail = exercisek;
                mapDataToscreen();
            }
        }

        //click ArrowBack
        ArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityDetailFavourite.this, Find_Favorite_Activity.class));
            }
        });

        //click button favourite
        buttonDeleteFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDetailFavourite.this, Home.class);
                deleteActivityIdToListActivityFavourite();
                startActivity(intent);
            }
        });

    }

    private void deleteActivityIdToListActivityFavourite() {
        String listfavo = sharedPreferences.getString("LIST_ACTIVITY_FAVORITE"+email, "");

        if(listfavo != null){
            if(listfavo.trim().length() > 0){
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
                //delete activity id in list
                if(stringList.contains(exercisekDetail.getExerciseID() + "")){
                    stringList.remove(exercisekDetail.getExerciseID() + "");
                }
                //create list favo again
                listfavo = "";
                for (String id: stringList) {
                    listfavo += " " + id;
                }
                //share lên sharereference lại
                editor.putString("LIST_ACTIVITY_FAVORITE"+email, listfavo);
                editor.commit();
                Toast.makeText(this, "delete "+exercisekDetail.getExerciseName()+" from favourite success", Toast.LENGTH_SHORT).show();

            }
        }
    }

    private void mapDataToscreen() {
        NameActivity.setText(exercisekDetail.getExerciseName());
        calory_minute_activity.setText(exercisekDetail.getExerciseCalories() + " calo/ " + exercisekDetail.getMinutes() + " phút");
        Picasso.get().load(exercisekDetail.getExerciseAvatar()).into(ActivityPicture);
        ActivityDesciption.setText(exercisekDetail.getExerciseDescription());
        ActivityGuide.setText(exercisekDetail.getGuide());
    }

    private Exercisek getExeciseById(int id) {
        for (Exercisek item: listExecise) {
            if(item.getExerciseID() == id)
                return item;
        }
        return null;
    }
    private void finbyId_Activity() {
        buttonDeleteFavorite = findViewById(R.id.buttonDeleteFavorite);

        ArrowBack = findViewById(R.id.ArrowBack);
        tymActivity = findViewById(R.id.tymActivity);
        ActivityPicture = findViewById(R.id.ActivityPicture);

        NameActivity = findViewById(R.id.NameActivity);
        calory_minute_activity = findViewById(R.id.calory_minute_activity);
        ActivityDesciption = findViewById(R.id.ActivityDesciption);
        ActivityGuide = findViewById(R.id.ActivityGuide);

        sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);	//"MY_APP": chỉ là cái tên của Shared preference;
        editor = sharedPreferences.edit();
    }
    private List<Exercisek> getListExercise() {
        listExecise = new ArrayList<>();
        ListDataSource listDataSource = new ListDataSource();
        listExecise = listDataSource.getExercisekList();
        return listExecise;
    }
    private void setupNavBottom() {
        btv = findViewById(R.id.bottom_nav);
        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.ac_home){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(ActivityDetailFavourite.this, Home.class));
                } else if(item.getItemId() == R.id.ac_search){
                    System.out.println("btv_ac_search_click");
                    startActivity(new Intent(ActivityDetailFavourite.this, Find_Food.class));
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