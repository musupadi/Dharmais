package com.ascendant.dharmais.API;

import com.ascendant.dharmais.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiRequest {
    @GET("news")
    Call<ResponseModel> Berita(@Query("kategori") String kategori);

    @GET("banner")
    Call<ResponseModel> Banner();
}
