package com.example.aleksandresabanadze.suggestme.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    private ApiInterface apiInterface;
    private Retrofit retrofit;
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String API_KEY = "be8c1b9a95b252041b466ecc37ee7c7d";
    public static final String BASE_IMAGE_URL_MEDIUM = "https://image.tmdb.org/t/p/w500";

    public ApiClient() {
        retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public ApiInterface getApiInstance(){
        return this.apiInterface;
    }
}
