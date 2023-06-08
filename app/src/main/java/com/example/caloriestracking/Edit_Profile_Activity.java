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

public class Edit_Profile_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        SharedPreferences sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        EditText fullnameedit = findViewById(R.id.editTextFullName);
        EditText emailedit = findViewById(R.id.editTextEmail);
        EditText passedit = findViewById(R.id.editTextPassword);

        // user info want to change
        String name2 = fullnameedit.getText().toString();
        String email2 = emailedit.getText().toString();
        String pass2 = passedit.getText().toString();

        // user info default
        String name1 = sharedPreferences.getString("fullName", "");
        String email1 = sharedPreferences.getString("email", "");
        String pass1 = sharedPreferences.getString("password", "");

        Button savebtn = findViewById(R.id.saveButton1);

        BottomNavigationView btv = findViewById(R.id.bottom_edit2);

        // user save edit profile
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("savebtn lick");

                //To do change name1 -> name2 ; email1 -> email2 ; pass1 -> pass2

                //

                startActivity(new Intent(Edit_Profile_Activity.this, User_Profile_Activity.class));
            }
        });

        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.ac_home){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(Edit_Profile_Activity.this, Home.class));
                } else if(item.getItemId() == R.id.ac_search){
                    System.out.println("btv_ac_search_click");
                    startActivity(new Intent(Edit_Profile_Activity.this, Find_Food.class));
                }else if(item.getItemId() == R.id.ac_favorite){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(Edit_Profile_Activity.this, Find_Favorite_Food.class));
                }else if(item.getItemId() == R.id.ac_user_page){
                    System.out.println("btv_ac_user_page_click");
                    startActivity(new Intent(Edit_Profile_Activity.this, User_Profile_Activity.class));
                }else if(item.getItemId() == R.id.ac_user_page){
                    System.out.println("btv_ac_user_page_click");
                    startActivity(new Intent(Edit_Profile_Activity.this, User_Profile_Activity.class));
                }
                return true;
            }
        });
    }
}