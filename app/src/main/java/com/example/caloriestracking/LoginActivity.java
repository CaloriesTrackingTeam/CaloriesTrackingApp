package com.example.caloriestracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.caloriestracking.Response.RespLoginNormal;
import com.example.caloriestracking.Response.ResponseLogin;
import com.example.caloriestracking.api.ApiService;
import com.example.caloriestracking.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPassword;
    SharedPreferences sharedPreferences;	//"MY_APP": chỉ là cái tên của Shared preference;
    SharedPreferences.Editor editor ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LinearLayout btnFace = findViewById(R.id.loginFaceButton);
        LinearLayout btnGoogle = findViewById(R.id.loginGoogleButton);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        Button btnLogin = (Button)findViewById(R.id.loginButton);
        Button btnForgot = (Button)findViewById(R.id.forgotpasswordButton);
        Button btnSignUp = (Button)findViewById(R.id.signupButton);

        //create share reference
        SharedPreferences sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);	//"MY_APP": chỉ là cái tên của Shared preference;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("USER_ID", "1");
        editor.commit();

        // to login Facebook activity
        btnFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("btnFace lick");
                //startActivity(new Intent(LoginActivity.this, [...].class));
            }
        });

        // to login Google activity
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("btnGoogle lick");
                //startActivity(new Intent(LoginActivity.this, [...].class));
                ApiService.apiService.loginT3().enqueue(new Callback<ResponseLogin>() {
                    @Override
                    public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                        System.out.println(response.toString());
                    }

                    @Override
                    public void onFailure(Call<ResponseLogin> call, Throwable t) {
                        System.out.println("call fail");
                        Toast.makeText(LoginActivity.this, "Some error when login google", Toast.LENGTH_SHORT);
                    }
                });
            }
        });

        // to home activity
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailInput = editTextEmail.getText().toString();
                String pwdInput = editTextPassword.getText().toString();

                ApiService.apiService.checkLogin(emailInput, pwdInput).enqueue(new Callback<RespLoginNormal>() {
                    @Override
                    public void onResponse(Call<RespLoginNormal> call, Response<RespLoginNormal> response) {
                        Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        if(response.body().getStatus().equals("fail")){
                            Toast.makeText(LoginActivity.this, "wrong user name or password", Toast.LENGTH_SHORT).show();
                        }else{
                            //save all data to share reference
                            User user = response.body().getData();
                            editor.putString("userID", "" + user.getUserID());
                            editor.putString("fullName",  "" + user.getFullName());
                            editor.putString("age",  "" + user.getAge());
                            editor.putString("weight",  "" + user.getWeight());
                            editor.putString("height",  "" + user.getHeight());
                            editor.putString("sex",  "" + user.getSex());
                            editor.putString("target",  "" + user.getTarget());
                            editor.putString("avatar",  "" + user.getAvatar());
                            editor.putString("email",  "" + user.getEmail());
                            editor.putString("password",  "" + user.getPassword());
                            editor.putString("role",  "" + user.getRole());
                            editor.putString("premium",  "" + user.isPremium());
                            editor.putString("protein",  "" + user.getProtein());
                            editor.putString("fat",  "" + user.getFat());
                            editor.putString("carbs",  "" + user.getCarbs());
                            editor.commit();

                            startActivity(new Intent(LoginActivity.this, Home.class));
                        }
                    }

                    @Override
                    public void onFailure(Call<RespLoginNormal> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "wrong user name or password", Toast.LENGTH_SHORT).show();
                    }
                });
//                if(checkLogin()){
//                    startActivity(new Intent(LoginActivity.this, Home.class));
//                }else{
//                    Toast.makeText(LoginActivity.this, "wrong user name or password", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        // to Forgot Password activity
        btnForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, Forgot_Password_3.class));
            }
        });

        // to register activity
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, Register1Activity.class));
            }
        });

    }
    private boolean checkLogin() {
        SharedPreferences sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);	//"MY_APP": chỉ là cái tên của Shared preference;
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String emailInput = editTextEmail.getText().toString();
        String pwdInput = editTextPassword.getText().toString();

        String email = sharedPreferences.getString("email", "");
        String password = sharedPreferences.getString("password", "");

        if(emailInput.equals(email) && pwdInput.equals(password)){
            return true;
        }
        return false;
    }
}