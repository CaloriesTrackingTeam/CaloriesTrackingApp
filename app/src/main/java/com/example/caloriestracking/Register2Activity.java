package com.example.caloriestracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Register2Activity extends AppCompatActivity {

    EditText editTextHeight, editTextWeight, editTextAge;
    Spinner dropdown;
    Button btnNext, btnLogin;
    String sex;
    int agee;
    double heightt, weightt;
    boolean valid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        findById_Ele();

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
                if(validData()){
                    //save data to share reference
                    SharedPreferences sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);	//"MY_APP": chỉ là cái tên của Shared preference;
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("age", agee + "");
                    editor.putString("sex", sex);
                    editor.putString("weight", weightt + "");
                    editor.putString("height", heightt + "");

                    editor.commit();

                    startActivity(new Intent(Register2Activity.this, Register3Activity.class));
                }
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

    private boolean validData() {
        //get data
        valid = true;

        String height = editTextHeight.getText().toString();
        String weight = editTextWeight.getText().toString();
        String age = editTextAge.getText().toString();
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Lấy giá trị trục đã chọn từ Spinner
                String selectedValue = parent.getSelectedItem().toString();
                sex = selectedValue;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Xử lý khi không có mục nào được chọn
                Toast.makeText(Register2Activity.this, "please choose sex", Toast.LENGTH_SHORT).show();
                valid = false;
            }
        });
        sex = "other";

        //valid data
        try{
            agee = Integer.parseInt(age);
            if(agee > 150) throw new Exception();
            if(agee < 0) throw new Exception();
        }catch (Exception ex){
            Toast.makeText(Register2Activity.this, "age must be a number  from 1 to 150", Toast.LENGTH_SHORT).show();
            return false;
        }
        try{
            heightt = Double.parseDouble(height);   //cm
            if(heightt >= 300) throw new Exception();
            if(heightt < 0) throw new Exception();
        }catch (Exception ex){
            Toast.makeText(Register2Activity.this, "height must be a number  from 0m to 3m", Toast.LENGTH_SHORT).show();
            return false;
        }
        try{
            weightt = Double.parseDouble(weight);
            if(weightt > 200) throw new Exception();
            if(weightt <= 0) throw new Exception();
        }catch (Exception ex){
            Toast.makeText(Register2Activity.this, "weightt must be a number  from 0 to 200 kg", Toast.LENGTH_SHORT).show();
            return false;
        }
        return valid;
    }

    private void findById_Ele() {
        dropdown = findViewById(R.id.spinnerSex);
        btnNext = (Button) findViewById(R.id.registerButton2);
        btnLogin = (Button) findViewById(R.id.loginButton);

        editTextHeight =  findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextAge =  findViewById(R.id.editTextAge);

    }
}