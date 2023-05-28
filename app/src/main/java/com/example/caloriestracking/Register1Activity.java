package com.example.caloriestracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register1Activity extends AppCompatActivity {

    private EditText editTextFullName, editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        ///-------find by id
        Button btnNext = (Button) findViewById(R.id.registerButton1);
        Button btnLogin = (Button) findViewById(R.id.loginButton);

        editTextFullName = findViewById(R.id.editTextFullName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);


        // to second Register Activity
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkValidINfo()){
                    startActivity(new Intent(Register1Activity.this, Register2Activity.class));
                }
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

    private boolean checkValidINfo() {
        String fullname = editTextFullName.getText().toString();
        String email = editTextEmail.getText().toString();
        String pwd = editTextPassword.getText().toString();

        if(fullname.trim().length() < 5 || fullname.trim().length() > 65){
            Toast.makeText(this, "Name must length from 5 ->  65 characters", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(email.trim().contains("@gmail.com") || email.trim().length() == 0){
            Toast.makeText(this, "email not correct format", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(pwd.trim().length() == 0){
            Toast.makeText(this, "Password not null", Toast.LENGTH_SHORT).show();
            return false;
        }

        //save data to RAM
        SharedPreferences sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);	//"MY_APP": chỉ là cái tên của Shared preference;
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("fullName", fullname);
        editor.putString("email", email);
        editor.putString("password", pwd);
        editor.commit();

        return true;
    }
}