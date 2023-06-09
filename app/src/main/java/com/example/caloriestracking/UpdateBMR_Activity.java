package com.example.caloriestracking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UpdateBMR_Activity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    Button saveBTN;
    int agee;
    double heightt, weightt;
    boolean valid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_bmr);

        SharedPreferences sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //editText = (EditText) findViewById(R.id.rightEditText);     //kcal/day
        editText2 = (EditText) findViewById(R.id.rightEditText2);   //height
        editText3 = (EditText) findViewById(R.id.rightEditText3);   //weight
        editText4 = (EditText) findViewById(R.id.rightEditText4);   //age
        editText5 = (EditText) findViewById(R.id.rightEditText5);   //sex
        //editText6 = (EditText) findViewById(R.id.rightEditText6);   //ko hiểu cái này exercise extensity

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
                try{
                    agee = Integer.parseInt(editText4.getText().toString());
                    heightt = Double.parseDouble(editText2.getText().toString());
                    weightt = Double.parseDouble(editText3.getText().toString());
                    if(validData(heightt+"", weightt+"", agee+"")){
                        //put data lên share reference lại
                        editor.putString("height",  "" + heightt);
                        editor.putString("weight",  "" + weightt);
                        editor.putString("age",  "" + agee);
                        editor.commit();

                        //gọi api cập nhật

                        startActivity(new Intent(UpdateBMR_Activity.this, User_Profile_Activity.class));
                    }
                }catch (Exception ex){
                    Toast.makeText(UpdateBMR_Activity.this, "Some error format", Toast.LENGTH_SHORT).show();
                }

                //
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
    private boolean validData(String height1, String weight1, String age1) {
        //get data
        valid = true;

        String height = height1;
        String weight = weight1;
        String age = age1;

        //valid data
        try{
            agee = Integer.parseInt(age);
            if(agee > 150) throw new Exception();
            if(agee < 0) throw new Exception();
        }catch (Exception ex){
            Toast.makeText(UpdateBMR_Activity.this, "age must be a number  from 1 to 150", Toast.LENGTH_SHORT).show();
            return false;
        }
        try{
            heightt = Double.parseDouble(height);   //cm
            if(heightt >= 300) throw new Exception();
            if(heightt < 0) throw new Exception();
        }catch (Exception ex){
            Toast.makeText(UpdateBMR_Activity.this, "height must be a number  from 0m to 3m", Toast.LENGTH_SHORT).show();
            return false;
        }
        try{
            weightt = Double.parseDouble(weight);
            if(weightt > 200) throw new Exception();
            if(weightt <= 0) throw new Exception();
        }catch (Exception ex){
            Toast.makeText(UpdateBMR_Activity.this, "weightt must be a number  from 0 to 200 kg", Toast.LENGTH_SHORT).show();
            return false;
        }
        return valid;
    }
}