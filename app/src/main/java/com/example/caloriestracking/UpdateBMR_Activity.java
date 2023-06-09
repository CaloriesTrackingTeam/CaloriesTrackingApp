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
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UpdateBMR_Activity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    Button saveBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_bmr);

        SharedPreferences sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editText = (EditText) findViewById(R.id.rightEditText);
        editText2 = (EditText) findViewById(R.id.rightEditText2);
        editText3 = (EditText) findViewById(R.id.rightEditText3);
        editText4 = (EditText) findViewById(R.id.rightEditText4);
        editText5 = (EditText) findViewById(R.id.rightEditText5);
        editText6 = (EditText) findViewById(R.id.rightEditText6);

        saveBTN = (Button) findViewById(R.id.savebtn);

        BottomNavigationView btv = findViewById(R.id.bottom_nav2);

        String height = sharedPreferences.getString("height", "");
        String weight = sharedPreferences.getString("weight", "");
        String age = sharedPreferences.getString("age","");

        editText2.setText(height);
        editText3.setText(weight);
        editText4.setText(age);

        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //To Do update new user infor here

                //
                startActivity(new Intent(UpdateBMR_Activity.this, User_Profile_Activity.class));
            }
        });

        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.ac_home){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(UpdateBMR_Activity.this, Home.class));
                } else if(item.getItemId() == R.id.ac_search){
                    System.out.println("btv_ac_search_click");
                    startActivity(new Intent(UpdateBMR_Activity.this, Find_Food.class));
                }else if(item.getItemId() == R.id.ac_favorite){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(UpdateBMR_Activity.this, Find_Favorite_Food.class));
                }else if(item.getItemId() == R.id.ac_user_page){
                    System.out.println("btv_ac_user_page_click");
                    startActivity(new Intent(UpdateBMR_Activity.this, User_Profile_Activity.class));
                }else if(item.getItemId() == R.id.ac_predict){
                    System.out.println("btv_ac_ac_predict_click");
                    //startActivity(new Intent(UpdateBMR_Activity.this, [home].class));
                }
                return true;
            }
        });

    }
}