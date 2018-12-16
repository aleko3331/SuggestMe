package com.example.aleksandresabanadze.suggestme.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class TopRatedResponseModel {

    @SerializedName("results")
    @Expose
    private List<MovieIDs> results = null;

    public List<MovieIDs> getResults() {
        return results;
    }
}
