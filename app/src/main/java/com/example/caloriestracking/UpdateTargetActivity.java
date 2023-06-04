package com.example.caloriestracking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UpdateTargetActivity extends AppCompatActivity {

    String target;
    int clicklosingWeight, clickgainWeight, clickkeepWeight = 0;
    CardView losingWeight, gainWeight, keepWeight;

    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_target);

        target = "";

        losingWeight = findViewById(R.id.btn_losingWeight);
        gainWeight = findViewById(R.id.btn_GainWeight);
        keepWeight = findViewById(R.id.btn_KeepWeight);

        losingWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicklosingWeightMethod();
            }
        });

        gainWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickgainWeightMethod();
            }
        });

        keepWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickkeepWeightMethod();
            }
        });

        btnNext = findViewById(R.id.nextButton);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(target.equals("")){
                    Toast.makeText(UpdateTargetActivity.this, "You must choose your TARGET !", Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(UpdateTargetActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void clicklosingWeightMethod() {
        System.out.println("losingWeight click");

        clicklosingWeight++;

        Drawable drawable = getResources().getDrawable(R.drawable.button_target);
        Drawable drawableClick = getResources().getDrawable(R.drawable.button_target_click);

        if((clicklosingWeight%2)!= 0){
            losingWeight.setBackground(drawableClick);
            gainWeight.setBackground(drawable);
            keepWeight.setBackground(drawable);

            target = "Losing Weight";

        }else if((clicklosingWeight%2)== 0){
            losingWeight.setBackground(drawable);
            gainWeight.setBackground(drawable);
            keepWeight.setBackground(drawable);

            target = "";
        }
    }

    private void clickgainWeightMethod() {
        System.out.println("gainWeight click");

        clickgainWeight++;

        Drawable drawable = getResources().getDrawable(R.drawable.button_target);
        Drawable drawableClick = getResources().getDrawable(R.drawable.button_target_click);

        if((clickgainWeight%2)!= 0){    //click
            losingWeight.setBackground(drawable);
            gainWeight.setBackground(drawableClick);
            keepWeight.setBackground(drawable);

            target = "Gain Weight";

        }else if((clickgainWeight%2)== 0){
            losingWeight.setBackground(drawable);
            gainWeight.setBackground(drawable);
            keepWeight.setBackground(drawable);

            target = "";
        }
    }

    private void clickkeepWeightMethod() {
        System.out.println("keepWeight click");

        clickkeepWeight++;

        Drawable drawable = getResources().getDrawable(R.drawable.button_target);
        Drawable drawableClick = getResources().getDrawable(R.drawable.button_target_click);

        if((clickkeepWeight%2)!= 0){    //click
            losingWeight.setBackground(drawable);
            gainWeight.setBackground(drawable);
            keepWeight.setBackground(drawableClick);

            target = "Keep Weight";

        }else if((clickkeepWeight%2)== 0){
            losingWeight.setBackground(drawable);
            gainWeight.setBackground(drawable);
            keepWeight.setBackground(drawable);

            target = "";
        }
    }
}