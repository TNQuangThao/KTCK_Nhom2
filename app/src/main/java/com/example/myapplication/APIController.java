package com.example.myapplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class APIController {
    private static final String BASE_URL = "http://192.168.1.50:82/BaoCao/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
//        Gson gson = new GsonBuilder().setLenient().create();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
