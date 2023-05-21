package com.example.caloriestracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        Button btnNext = (Button) findViewById(R.id.registerButton1);
        Button btnLogin = (Button) findViewById(R.id.loginButton);

        // to second Register Activity
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register1Activity.this, Register2Activity.class));
            }
        });

        // to Login Activity
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register1Activity.this, LoginActivity.class));
            }
        });

    }
}