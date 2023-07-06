package com.example.caloriestracking.api;

import com.example.caloriestracking.Response.RespLoginNormal;
import com.example.caloriestracking.Response.RespPostLogin;
import com.example.caloriestracking.Response.RespPostLoginAll;
import com.example.caloriestracking.Response.ResponseLogin;
import com.example.caloriestracking.model.Track;
import com.example.caloriestracking.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    //http://caloriestracking.ap-southeast-2.elasticbeanstalk.com/swagger-ui/index.html
    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient.Builder okBuilder = new OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)          // kết hợp vs 1 dòng code ở dưới +
            .connectTimeout(30, TimeUnit.SECONDS)       // dùng để khi connect mà quá 30s ko có result trả về thì nó báo lỗi
            .retryOnConnectionFailure(true)                     //có cố kết nối lại khi nó lỗi ko
            .addInterceptor(loggingInterceptor);

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    //http://localhost:8080/auth/google/login
    //tạo retrofit từ interface class + link api
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://caloriestracking.ap-southeast-2.elasticbeanstalk.com/")    //lấy domain của link api
            //.baseUrl("http://172.18.208.1:8081/")    //lấy domain của link api
            .addConverterFactory(GsonConverterFactory.create(gson))	//dùng để convert kq trả về
            .client(okBuilder.build())
            .build()
            .create(ApiService.class);

    @GET("auth/google/login")
    Call<ResponseLogin> loginT3();

    @POST("users")
    Call<RespPostLogin> createUser(@Body User user);

    @FormUrlEncoded
    @POST("auth/login")
    Call<RespLoginNormal> checkLogin(@Field("email") String email,
                                     @Field("pass") String pass);

    @GET("auth/reset")
    Call<RespPostLogin> resetpass(@Query("email") String email);

    //http://localhost:8080/auth/feedback?from=khadepzai%40gmail.com&feedback=TEst%20COnnect
    @FormUrlEncoded
    @POST("auth/feedback")
    Call<RespPostLogin> sendFeedback(@Field("from") String from,
                                     @Field("feedback") String feedback);

    @POST("users")
    Call<RespPostLogin> updateUserProfile(@Body User user);

    @POST("track")
    Call<RespPostLogin> trackCaloEachDay(@Body Track track);

    @GET("track/user")
    Call<RespPostLoginAll<List<Track>>> getTrackuser(@Query("userid") int userid);
    //test call track success
//        ApiService.apiService.getTrackuser(1).enqueue(new Callback<RespPostLoginAll<List<Track>>>() {
//            @Override
//            public void onResponse(Call<RespPostLoginAll<List<Track>>> call, Response<RespPostLoginAll<List<Track>>> response) {
//                List<Track> list = response.body().getData();
//                for (Track track: list) {
//                    Log.e("TRACK_USER", track.getUser().getFullName() + " - " + track.getDate() + " - "  +track.getCalo());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RespPostLoginAll<List<Track>>> call, Throwable t) {
//                Log.e("TRACK_USER", "get track of user fail");
//            }
//        });
    //test


}
