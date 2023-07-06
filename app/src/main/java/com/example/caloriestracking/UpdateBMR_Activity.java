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

import com.example.caloriestracking.Response.RespPostLogin;
import com.example.caloriestracking.api.ApiService;
import com.example.caloriestracking.model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateBMR_Activity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText tvtarget;
    Button saveBTN;
    int agee, targett;
    double heightt, weightt;
    boolean valid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_bmr);

        SharedPreferences sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //find by id
        //editText = (EditText) findViewById(R.id.rightEditText);     //kcal/day
        editText2 = (EditText) findViewById(R.id.rightEditText2);   //height
        editText3 = (EditText) findViewById(R.id.rightEditText3);   //weight
        editText4 = (EditText) findViewById(R.id.rightEditText4);   //age
        editText5 = (EditText) findViewById(R.id.rightEditText5);   //sex
        tvtarget = (EditText) findViewById(R.id.tvtarget);

        saveBTN = (Button) findViewById(R.id.savebtn);

        BottomNavigationView btv = findViewById(R.id.bottom_nav2);

        //get data from share reference to map data to screen
        String height = sharedPreferences.getString("height", "");
        String weight = sharedPreferences.getString("weight", "");
        String age = sharedPreferences.getString("age","");
        String tagretU = sharedPreferences.getString("target","");

        editText2.setText(height);
        editText3.setText(weight);
        editText4.setText(age);
        switch (tagretU){
            case "Losing Weight":
                tvtarget.setText(1+"");
                break;
            case "Keep Weight":
                tvtarget.setText(2+"");
                break;
            case "Gain Weight":
                tvtarget.setText(3+"");
                break;
        }

        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //To Do update new user infor here
                try{
                    agee = Integer.parseInt(editText4.getText().toString());
                    heightt = Double.parseDouble(editText2.getText().toString());
                    weightt = Double.parseDouble(editText3.getText().toString());

                    if(validData(heightt+"", weightt+"", agee+"")){
                        //cal api
                        User userNow = getUserInRAM(sharedPreferences);
                        userNow.setHeight(heightt);
                        userNow.setWeight(weightt);
                        userNow.setAge(agee);
                        String tagrettt = "";
                        switch (targett){
                            case 1:
                                tagrettt = "Losing Weight";
                                break;
                            case 2:
                                tagrettt = "Keep Weight";
                                break;
                            case 3:
                                tagrettt = "Gain Weight";
                                break;
                        }
                        userNow.setTarget(tagrettt);

                        //put data lên share reference lại
                        editor.putString("height",  "" + heightt);
                        editor.putString("weight",  "" + weightt);
                        editor.putString("age",  "" + agee);
                        editor.putString("target",  tagrettt);
                        editor.commit();


                        //test
//                        startActivity(new Intent(UpdateBMR_Activity.this, User_Profile_Activity.class));
                        //test


                        //gọi api cập nhật
                        ApiService.apiService.updateUserProfile(userNow).enqueue(new Callback<RespPostLogin>() {
                            @Override
                            public void onResponse(Call<RespPostLogin> call, Response<RespPostLogin> response) {
                                if(response.body().getStatus().equals("success")){
                                    Toast.makeText(UpdateBMR_Activity.this, response.body().getStatus(), Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(UpdateBMR_Activity.this, User_Profile_Activity.class));
                                }
                            }

                            @Override
                            public void onFailure(Call<RespPostLogin> call, Throwable t) {
                                Toast.makeText(UpdateBMR_Activity.this, "call fail", Toast.LENGTH_SHORT).show();

                            }
                        });
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
        try{
            String[] listint = {"1", "2", "3"};
            targett = Integer.parseInt(tvtarget.getText().toString());
            boolean check = false;
            switch (targett){
                case 1:
                    check = true;
                    break;
                case 2:
                    check = true;
                    break;
                case 3:
                    check = true;
                    break;
                default:
                    check = false;
                    break;
            }
            if(check == false) throw new Exception();

        }catch (Exception ex){
            Toast.makeText(UpdateBMR_Activity.this, "target must be a number in 1(losing), 2(keep), 3(gain) weight ", Toast.LENGTH_SHORT).show();
            return false;
        }
        return valid;
    }
}