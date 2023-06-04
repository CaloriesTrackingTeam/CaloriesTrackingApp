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

public class LoginActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPassword;
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
            }
        });

        // to home activity
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkLogin()){
                    startActivity(new Intent(LoginActivity.this, Home.class));
                }else{
                    Toast.makeText(LoginActivity.this, "wrong user name or password", Toast.LENGTH_SHORT).show();
                }
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