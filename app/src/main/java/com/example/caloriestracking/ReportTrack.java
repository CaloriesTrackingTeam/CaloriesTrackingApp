package com.example.caloriestracking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.caloriestracking.adapter.TrackAdapter;
import com.example.caloriestracking.model.Track;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class ReportTrack extends AppCompatActivity {
    private TextView rcmTrack, tvgoalcalo;
    private Button btnBack;
    private RecyclerView rcvTrack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_track);

        //findbyId
        rcmTrack = findViewById(R.id.rcmTrack);
        btnBack = findViewById(R.id.btnBack);
        rcvTrack = findViewById(R.id.rcvTrack);
        tvgoalcalo = findViewById(R.id.tvgoalcalo);
        //findbyId end

        SharedPreferences sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String calogoal = sharedPreferences.getString("CALO_NEED_A_DAY", "");

        //button click
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReportTrack.this, User_Profile_Activity.class));
            }
        });
        //button click end

        //setup recycle view
        List<Track> trackList = getLisrtTrack();
        TrackAdapter trackAdapter = new TrackAdapter(trackList, Float.parseFloat(calogoal));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvTrack.setLayoutManager(linearLayoutManager);
        rcvTrack.setAdapter(trackAdapter);
        //setup recycle view end

        //set goal  -CALO_NEED_A_DAY
        tvgoalcalo.setText("Calo goal/ day: "+calogoal+" calo");

        //tính toán calo để cho recommend
        int more50percent = 0;
        for (Track track: trackList) {
            if(track.getCalo() >= Float.parseFloat(calogoal)) more50percent++;
        }
        more50percent = ( more50percent / trackList.size() ) * 100;
        if(more50percent >= 50){
            rcmTrack.setText("If you stay in this form, you will quickly reach your goal");
        }else{
            rcmTrack.setText("hmm, you don't follow the plan, fighting, keep going... :3 ");
        }
    }

    private List<Track> getLisrtTrack() {
        List<Track> list =new ArrayList<>();
        Random random =new Random();
       for (int i = 1; i <= 30; i++){
           Date date = new Date(Calendar.getInstance().get(Calendar.YEAR) - 1900, 5, i);
            list.add(new Track(date, random.nextInt((2000 - 1500) + 1) + 1500, null));
       }
       return list;
    }
}