package com.example.caloriestracking;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.caloriestracking.Response.RespPostLogin;
import com.example.caloriestracking.api.ApiService;
import com.example.caloriestracking.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register3Activity extends AppCompatActivity {

    String target;
    int clicklosingWeight, clickgainWeight, clickkeepWeight = 0;
    CardView losingWeight, gainWeight, keepWeight;

    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);

        target = "";

        losingWeight = findViewById(R.id.btn_losingWeight);
        gainWeight = findViewById(R.id.btn_GainWeight);
        keepWeight = findViewById(R.id.btn_KeepWeight);

        losingWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicklosingWeightMethod();
            }
        });

        gainWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickgainWeightMethod();
            }
        });

        keepWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickkeepWeightMethod();
            }
        });

        btnNext = findViewById(R.id.nextButton);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(target.equals("")){
                    Toast.makeText(Register3Activity.this, "You must choose your TARGET !", Toast.LENGTH_LONG).show();
                }else{
                    //save target
                    SharedPreferences sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);	//"MY_APP": chỉ là cái tên của Shared preference;
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("target", target + "");

                    editor.commit();

                    //tạo acc
                    User user = createNewAcc(sharedPreferences);

                    //test, xong nhớ xóa
//                    Intent intent = new Intent(Register3Activity.this, LoginActivity.class);
//                    startActivity(intent);
                    //test, xong nhớ xóa

                    ApiService.apiService.createUser(user).enqueue(new Callback<RespPostLogin>() {
                        @Override
                        public void onResponse(Call<RespPostLogin> call, Response<RespPostLogin> response) {
                            if(response.body().getStatus().equals("fail")){
                                Toast.makeText(Register3Activity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(Register3Activity.this, "create success", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Register3Activity.this, LoginActivity.class);
                                startActivity(intent);
                            }

                        }

                        @Override
                        public void onFailure(Call<RespPostLogin> call, Throwable t) {
                            Toast.makeText(Register3Activity.this, "create fail", Toast.LENGTH_SHORT).show();


                        }
                    });


                }
            }
        });
    }

    private User createNewAcc(SharedPreferences sharedPreferences) {
        //(int userID, String fullName, int age, double weight, double height,
        // String sex, String target, String avatar, String email, String password,
        // int role, boolean premium, double carbs, double protein, double fat)
        String fullName = sharedPreferences.getString("fullName", "");
        String email = sharedPreferences.getString("email", "");
        String password = sharedPreferences.getString("password", "");
        String age = sharedPreferences.getString("age", "");
        String sex = sharedPreferences.getString("sex", "");
        String weight = sharedPreferences.getString("weight", "");
        String height = sharedPreferences.getString("height", "");

        User user  = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(password);
        user.setAge(Integer.parseInt(age));
        user.setSex(sex);
        user.setWeight(Double.parseDouble(weight));
        user.setHeight(Double.parseDouble(height));
        user.setTarget(target);
        user.setRole(0);
        user.setPremium(false);
        user.setCarbs(0);
        user.setProtein(0);
        user.setFat(0);
        user.setAvatar("https://nhattientuu.com/wp-content/uploads/2020/08/hinh-anh-cute-72.jpg");

        return user;
    }

    private void clicklosingWeightMethod() {
        System.out.println("losingWeight click");

        clicklosingWeight++;

        Drawable drawable = getResources().getDrawable(R.drawable.button_target);
        Drawable drawableClick = getResources().getDrawable(R.drawable.button_target_click);

        if((clicklosingWeight%2)!= 0){
            losingWeight.setBackground(drawableClick);
            gainWeight.setBackground(drawable);
            keepWeight.setBackground(drawable);

            target = "Losing Weight";

        }else if((clicklosingWeight%2)== 0){
            losingWeight.setBackground(drawable);
            gainWeight.setBackground(drawable);
            keepWeight.setBackground(drawable);

            target = "";
        }
    }

    private void clickgainWeightMethod() {
        System.out.println("gainWeight click");

        clickgainWeight++;

        Drawable drawable = getResources().getDrawable(R.drawable.button_target);
        Drawable drawableClick = getResources().getDrawable(R.drawable.button_target_click);

        if((clickgainWeight%2)!= 0){    //click
            losingWeight.setBackground(drawable);
            gainWeight.setBackground(drawableClick);
            keepWeight.setBackground(drawable);

            target = "Gain Weight";

        }else if((clickgainWeight%2)== 0){
            losingWeight.setBackground(drawable);
            gainWeight.setBackground(drawable);
            keepWeight.setBackground(drawable);

            target = "";
        }
    }

    private void clickkeepWeightMethod() {
        System.out.println("keepWeight click");

        clickkeepWeight++;

        Drawable drawable = getResources().getDrawable(R.drawable.button_target);
        Drawable drawableClick = getResources().getDrawable(R.drawable.button_target_click);

        if((clickkeepWeight%2)!= 0){    //click
            losingWeight.setBackground(drawable);
            gainWeight.setBackground(drawable);
            keepWeight.setBackground(drawableClick);

            target = "Keep Weight";

        }else if((clickkeepWeight%2)== 0){
            losingWeight.setBackground(drawable);
            gainWeight.setBackground(drawable);
            keepWeight.setBackground(drawable);

            target = "";
        }
    }
}