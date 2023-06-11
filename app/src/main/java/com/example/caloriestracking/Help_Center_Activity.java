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
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Help_Center_Activity extends AppCompatActivity {
    EditText editTextInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);

        Button sentbtn = findViewById(R.id.sentButton);

        BottomNavigationView btv = findViewById(R.id.bottom_nav2);

        editTextInfo = findViewById(R.id.editTextInfo);

        // user send help email
        sentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("sentbtn lick");
                SharedPreferences sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String email = sharedPreferences.getString("email", "user");
                String feedbackContent = editTextInfo.getText().toString();

                //test
                startActivity(new Intent(Help_Center_Activity.this, Sent_Email_Activity.class));


//                ApiService.apiService.sendFeedback(email, feedbackContent).enqueue(new Callback<RespPostLogin>() {
//                    @Override
//                    public void onResponse(Call<RespPostLogin> call, Response<RespPostLogin> response) {
//                        if(response.body().getMessage().equals("send mail success")){
//                            Toast.makeText(Help_Center_Activity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(Help_Center_Activity.this, Sent_Email_Activity.class));
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<RespPostLogin> call, Throwable t) {
//                        Toast.makeText(Help_Center_Activity.this, "Some error when send mail, try again", Toast.LENGTH_SHORT).show();
//                    }
//                });

            }
        });

        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.ac_home){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(Help_Center_Activity.this, Home.class));
                } else if(item.getItemId() == R.id.ac_search){
                    System.out.println("btv_ac_search_click");
                    startActivity(new Intent(Help_Center_Activity.this, Find_Food.class));
                }else if(item.getItemId() == R.id.ac_favorite){
                    System.out.println("btv_ac_favorite_click");
                    startActivity(new Intent(Help_Center_Activity.this, Find_Favorite_Food.class));
                }else if(item.getItemId() == R.id.ac_user_page){
                    System.out.println("btv_ac_user_page_click");
                    startActivity(new Intent(Help_Center_Activity.this, User_Profile_Activity.class));
                }else if(item.getItemId() == R.id.ac_predict){
                    System.out.println("btv_ac_ac_predict_click");
                    //startActivity(new Intent(Help_Center_Activity.this, [home].class));
                }
                return true;
            }
        });
    }
}