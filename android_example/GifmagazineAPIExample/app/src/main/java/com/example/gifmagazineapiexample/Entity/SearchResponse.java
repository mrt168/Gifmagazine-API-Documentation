package com.example.gifmagazineapiexample.Entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kokies on 2015/12/23.
 */
public class SearchResponse {
    @SerializedName("data")
    private List<SearchData> data;

    @SerializedName("pagination")
    private Pagination pagination;

    /**
     *
     * @return
     * The data
     */
    public List<SearchData> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(List<SearchData> data) {
        this.data = data;
    }

    /**
     *
     * @return
     * The pagination
     */
    public Pagination getMeta() {
        return pagination;
    }

    /**
     *
     * @param pagination
     * The meta
     */
    public void setMeta(Pagination pagination) {
        this.pagination = pagination;
    }

}
