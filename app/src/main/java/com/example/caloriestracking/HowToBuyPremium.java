package com.example.caloriestracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HowToBuyPremium extends AppCompatActivity {
    Button BackTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_buy_premium);
        BackTo = findViewById(R.id.BackTo);
        BackTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //back về profile
                startActivity(new Intent(HowToBuyPremium.this, Home.class));
            }
        });
    }
}