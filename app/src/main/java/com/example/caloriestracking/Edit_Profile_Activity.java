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
import android.widget.Toast;

import com.example.caloriestracking.Response.RespPostLogin;
import com.example.caloriestracking.api.ApiService;
import com.example.caloriestracking.model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        emailedit.setEnabled(false);

        // user info default
        String name1 = sharedPreferences.getString("fullName", "");
        String email1 = sharedPreferences.getString("email", "");
        String pass1 = sharedPreferences.getString("password", "");

        //mapp data
        fullnameedit.setText(name1);
        emailedit.setText(email1);
        passedit.setText(pass1);

        Button savebtn = findViewById(R.id.saveButton1);

        BottomNavigationView btv = findViewById(R.id.bottom_edit2);

        // user save edit profile
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("savebtn lick");

                // user info want to change
                String name2 = fullnameedit.getText().toString();
                String email2 = emailedit.getText().toString();
                String pass2 = passedit.getText().toString();

                //To do change name1 -> name2 ; email1 -> email2 ; pass1 -> pass2
                if(validdata(name2, email2, pass2)){

                    //cal api
                    User userNow = getUserInRAM(sharedPreferences);
                    userNow.setFullName(name2);
                    userNow.setEmail(email2);
                    userNow.setPassword(pass2);

                    //update info RAM
                    editor.putString("fullName",  "" + userNow.getFullName());
                    editor.putString("password",  "" + userNow.getPassword());
                    editor.commit();
                    ApiService.apiService.updateUserProfile(userNow).enqueue(new Callback<RespPostLogin>() {
                        @Override
                        public void onResponse(Call<RespPostLogin> call, Response<RespPostLogin> response) {
                            if(response.body().getStatus().equals("success")){
                                Toast.makeText(Edit_Profile_Activity.this, response.body().getStatus(), Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Edit_Profile_Activity.this, User_Profile_Activity.class));
                            }
                        }

                        @Override
                        public void onFailure(Call<RespPostLogin> call, Throwable t) {
                            Toast.makeText(Edit_Profile_Activity.this, "call fail", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
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

    private User getUserInRAM(SharedPreferences sharedPreferences) {
        User user = new User();
        user.setUserID(Integer.parseInt(sharedPreferences.getString("userID", "")));
        user.setFullName(sharedPreferences.getString("fullName", ""));
        user.setAge(Integer.parseInt(sharedPreferences.getString("age", "")));
        user.setWeight(Double.parseDouble(sharedPreferences.getString("weight", "")));
        user.setHeight(Double.parseDouble(sharedPreferences.getString("height", "")));
        user.setSex(sharedPreferences.getString("sex", ""));
        user.setTarget(sharedPreferences.getString("target", ""));
        user.setAvatar(sharedPreferences.getString("avatar", ""));
        user.setEmail(sharedPreferences.getString("email", ""));
        user.setPassword(sharedPreferences.getString("password", ""));
        user.setRole(Integer.parseInt(sharedPreferences.getString("role", "")));
        user.setPremium(Boolean.parseBoolean(sharedPreferences.getString("premium", "")));
        user.setProtein(Double.parseDouble(sharedPreferences.getString("protein", "")));
        user.setFat(Double.parseDouble(sharedPreferences.getString("fat", "")));
        user.setCarbs(Double.parseDouble(sharedPreferences.getString("carbs", "")));
        return user;
    }

    private boolean validdata(String name2, String email2, String pass2) {
        if(name2.trim().length() < 5 || name2.trim().length() > 65){
            Toast.makeText(this, "Name must length from 5 ->  65 characters", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!email2.trim().contains("@") || email2.trim().length() == 0){
            Toast.makeText(this, "email not correct format", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(pass2.trim().length() == 0){
            Toast.makeText(this, "Password not null", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}