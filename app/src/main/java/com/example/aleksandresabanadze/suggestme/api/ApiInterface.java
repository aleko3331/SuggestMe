package com.example.aleksandresabanadze.suggestme.api;

import com.example.aleksandresabanadze.suggestme.models.MovieResponseModel;
import com.example.aleksandresabanadze.suggestme.models.TopRatedResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("movie/top_rated")
    Call<TopRatedResponseModel> getTopRatedMovies(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("movie/{id}")
    Call<MovieResponseModel> getMovieData(@Path("id") int id, @Query("api_key") String apiKey);
}
