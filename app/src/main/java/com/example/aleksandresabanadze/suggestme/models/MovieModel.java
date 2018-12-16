package com.example.aleksandresabanadze.suggestme.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class MovieModel {
    @SerializedName("budget")
    @Expose
    public Integer budget;

    @SerializedName("genres")
    @Expose
    public String genres;

    @SerializedName("id")
    @Expose
    public Integer id;

    @SerializedName("original_language")
    @Expose
    public String originalLanguage;

    @SerializedName("overview")
    @Expose
    public String overview;

    @SerializedName("popularity")
    @Expose
    public Double popularity;

    @SerializedName("poster_path")
    @Expose
    public String posterPath;

    @SerializedName("release_date")
    @Expose
    public String releaseDate;

    @SerializedName("revenue")
    @Expose
    public Integer revenue;

    @SerializedName("runtime")
    @Expose
    public Integer runtime;

    @SerializedName("spoken_languages")
    @Expose
    public String spokenLanguages;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("vote_average")
    @Expose
    public Double voteAverage;

    public void setGenres(List<Genre> genre) {
        StringBuilder result  = new StringBuilder("");
        for (Genre item:genre)
            result.append(item.name+", ");
        this.genres = result.toString();
    }


    public void setSpokenLanguages(List<SpokenLanguage> spokenLanguage) {
        StringBuilder result  = new StringBuilder("");
        for (SpokenLanguage item:spokenLanguage)
            result.append(item.name+", ");
        this.spokenLanguages = result.toString();
    }
}
