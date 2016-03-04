package com.example.gifmagazineapiexample.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kokies on 2015/12/23.
 */
public class ImageList {
    @SerializedName("default")
    private Image defaultImage;

    private Image medium;

    public Image getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(Image defaultImage) {
        this.defaultImage = defaultImage;
    }

    public Image getMedium() {
        return medium;
    }

    public void setMedium(Image medium) {
        this.medium = medium;
    }
}
