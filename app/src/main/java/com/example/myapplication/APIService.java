package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("getTacGia.php")
    Call<List<TacGia>> getTacGia();
}
