package com.example.caloriestracking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateBMR_Activity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    Button saveBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_bmr);

        editText = (EditText) findViewById(R.id.rightEditText);
        editText2 = (EditText) findViewById(R.id.rightEditText2);
        editText3 = (EditText) findViewById(R.id.rightEditText3);
        editText4 = (EditText) findViewById(R.id.rightEditText4);
        editText5 = (EditText) findViewById(R.id.rightEditText5);
        editText6 = (EditText) findViewById(R.id.rightEditText6);

        saveBTN = (Button) findViewById(R.id.savebtn);

        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}