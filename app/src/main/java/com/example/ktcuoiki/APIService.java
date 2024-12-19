package com.example.ktcuoiki;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    //Lấy sản phẩm từ database
    @GET("getSanPham.php")
    Call<List<ModelSanPham>> getSanPham();
}