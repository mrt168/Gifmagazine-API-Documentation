package com.example.gifmagazineapiexample.Retrofits;

import com.example.gifmagazineapiexample.Entity.SearchResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface GifMagazineAPI {

    @GET("//v1/gifs/search")
    void getSearchResult(@Query("q") String query,
                         @Query("offset") int offset, @Query("limit") int limit,
                         @Query("safe") int safe, Callback<SearchResponse> cb);



}
