package com.example.caloriestracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.caloriestracking.Response.RespPostLogin;
import com.example.caloriestracking.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Forgot_Password_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password3);

        EditText ed_email = findViewById(R.id.editTextEmail2);
        String email = ed_email.getText().toString();

        TextView tv_login = findViewById(R.id.loginLink);
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Forgot_Password_3.this, LoginActivity.class));
            }
        });

        TextView tv_signup = findViewById(R.id.SignupLink);
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Forgot_Password_3.this, Register1Activity.class));
            }
        });

        Button send = findViewById(R.id.SendButton);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Forgot_Password_3.this, Forgot_Password_4.class);
                String email = ed_email.getText().toString();
                intent.putExtra("email", email);
                ApiService.apiService.resetpass(email).enqueue(new Callback<RespPostLogin>() {
                    @Override
                    public void onResponse(Call<RespPostLogin> call, Response<RespPostLogin> response) {
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<RespPostLogin> call, Throwable t) {
                        Toast.makeText(Forgot_Password_3.this, "some error, please try again", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}