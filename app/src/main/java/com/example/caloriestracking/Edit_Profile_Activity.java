package com.example.caloriestracking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Edit_Profile_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Button savebtn = findViewById(R.id.saveButton1);

        BottomNavigationView btv = findViewById(R.id.bottom_edit2);

        // user save edit profile
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("savebtn lick");
                startActivity(new Intent(Edit_Profile_Activity.this, User_Profile_Activity.class));
            }
        });

        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.ac_home){
                    System.out.println("btv_ac_favorite_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                } else if(item.getItemId() == R.id.ac_search){
                    System.out.println("btv_ac_search_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                }else if(item.getItemId() == R.id.ac_favorite){
                    System.out.println("btv_ac_favorite_click");
                    //startActivity(new Intent(Find_Food.this, [home].class));
                }else if(item.getItemId() == R.id.ac_user_page){
                    System.out.println("btv_ac_user_page_click");
                    startActivity(new Intent(Edit_Profile_Activity.this, User_Profile_Activity.class));
                }
                return true;
            }
        });
    }
}