package com.example.katya.json;

/**
 * Created by Катя on 12.12.2016.
 */
import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("android/jsonandroid")
    Call<JSONResponse> getJSON();
}
