package com.example.caloriestracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Register2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        Spinner dropdown = findViewById(R.id.spinnerSex);
        Button btnNext = (Button) findViewById(R.id.registerButton2);
        Button btnLogin = (Button) findViewById(R.id.loginButton);

        //create a list of items for the spinner.
        String[] items = new String[]{"Male", "Female", "Other"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        // to third Register Activity
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register2Activity.this, Register3Activity.class));
            }
        });

        // to Login Activity
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register2Activity.this, LoginActivity.class));
            }
        });

    }
}