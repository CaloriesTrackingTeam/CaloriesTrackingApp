package com.example.caloriestracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnFace = (Button)findViewById(R.id.loginFaceButton);
        Button btnGoogle = (Button)findViewById(R.id.loginGoogleButton);
        Button btnLogin = (Button)findViewById(R.id.loginButton);
        Button btnForgot = (Button)findViewById(R.id.forgotpasswordButton);
        Button btnSignUp = (Button)findViewById(R.id.signupButton);

        // to login Facebook activity
        /*btnFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, [...].class));
            }
        });*/

        // to login Google activity
        /*btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, [...].class));
            }
        });*/

        // to home activity
        /*btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, [...].class));
            }
        });*/

        // to Forgot Password activity
        /*btnForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, [...].class));
            }
        });*/

        // to register activity
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, Register1Activity.class));
            }
        });

    }
}