package com.example.caloriestracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sent_Email_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent_email);

        Button backbtn = findViewById(R.id.backButton);

        // user get back to home page
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("sentbtn lick");
                startActivity(new Intent(Sent_Email_Activity.this, Home.class));
            }
        });

    }
}