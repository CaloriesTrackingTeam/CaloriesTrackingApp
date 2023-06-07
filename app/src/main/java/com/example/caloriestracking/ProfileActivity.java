package com.example.caloriestracking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    ImageView profile_img, settingsImg, threesDot;
    TextView tvUserName, tvnumberBMI, tvHeight, tvWeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        findBYId_Ele();

    }

    private void findBYId_Ele() {
        profile_img = findViewById(R.id.profile_img);
        settingsImg = findViewById(R.id.settingsImg);
        threesDot = findViewById(R.id.threesDot);

        tvUserName = findViewById(R.id.tvUserName);
        tvnumberBMI = findViewById(R.id.tvnumberBMI);
        tvHeight = findViewById(R.id.tvHeight);
        tvWeight = findViewById(R.id.tvWeight);

    }
}