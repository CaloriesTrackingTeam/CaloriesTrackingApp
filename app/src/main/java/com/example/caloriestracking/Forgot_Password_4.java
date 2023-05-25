package com.example.caloriestracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Forgot_Password_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password4);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");

        TextView tv_mail = findViewById(R.id.mailUser);
        tv_mail.setText(email);

        //click button back to login
        Button btnBackLogin = findViewById(R.id.BackToLoginButton);
        btnBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Forgot_Password_4.this, LoginActivity.class));
            }
        });

        //click resend
        TextView tvResend = findViewById(R.id.ResendLink);
        tvResend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call api send email for forgot password again
            }
        });

        //click Contact Us
        TextView tvContactUs = findViewById(R.id.ContactUsLink);
        tvContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Forgot_Password_4.this, [...].class));
            }
        });

    }
}