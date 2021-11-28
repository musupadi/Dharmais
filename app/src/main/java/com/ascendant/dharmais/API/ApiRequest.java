package com.ascendant.dharmais.API;

import com.ascendant.dharmais.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRequest {
    @GET("news")
    Call<ResponseModel> Berita(@Query("kategori") String kategori);

    @GET("banner")
    Call<ResponseModel> Banner();

    @GET("testimoni")
    Call<ResponseModel> Testimoni();

    @GET("spesialis")
    Call<ResponseModel> Spesialis();

    @GET("page/data")
    Call<ResponseModel> Page(@Query("parent") String parent);

    //POST
    @FormUrlEncoded
    @POST("jadwaldokter")
    Call<ResponseModel> JadwalDokter(@Field("spesialis") String spesialis);
}
