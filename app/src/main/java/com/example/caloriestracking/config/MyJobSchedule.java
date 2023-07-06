package com.example.caloriestracking.config;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.caloriestracking.Response.RespPostLogin;
import com.example.caloriestracking.api.ApiService;
import com.example.caloriestracking.model.Track;
import com.example.caloriestracking.model.User;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyJobSchedule extends JobService {
    private final String TAG = MyJobSchedule.class.getName();
    private boolean jobCancel;

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.e(TAG, "job started");
        doBackGroundJob(params);
        return false;
    }

    private void doBackGroundJob(JobParameters params) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //api call ded693 gửi về trong này
                SharedPreferences sharedPreferences = getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                String caloconsume = sharedPreferences.getString("CALO_CONSUME", "");
                float calo = Float.parseFloat(caloconsume);
                String userid = sharedPreferences.getString("userID", "");

                User user = new User();
                user.setUserID(Integer.parseInt(userid));
                Track track = new Track(new java.sql.Date(System.currentTimeMillis()), calo, user);

                ApiService.apiService.trackCaloEachDay(track).enqueue(new Callback<RespPostLogin>() {
                    @Override
                    public void onResponse(Call<RespPostLogin> call, Response<RespPostLogin> response) {
                        Log.e(TAG, new Date() + " - save calo success");
                    }

                    @Override
                    public void onFailure(Call<RespPostLogin> call, Throwable t) {
                        Log.e(TAG, new Date() + " - save calo fail");
                    }
                });

                Log.e(TAG, new Date() + " - Kha đẹp zai, Job finished");
                jobFinished(params, false);
            }
        }).start();
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.e(TAG, "job stopped");
        jobCancel = true;
        return false;
    }
}
