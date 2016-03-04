package com.example.gifmagazineapiexample.Retrofits;

import com.google.gson.Gson;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class GifMagazineAPIClient {
    public GifMagazineAPI getGifMagazineAPI() {
        RestAdapter adapter =
                new RestAdapter.Builder()
                        .setEndpoint("http://api.gifmagazine.net/")
                        .setConverter(new GsonConverter(new Gson()))
                        .build();
        return adapter.create(GifMagazineAPI.class);
    }
}