package com.example.gifmagazineapiexample.Entity;

/**
 * Created by kokies on 2015/12/23.
 */
public class SearchData {
    private int id;
    private String url;
    private int user_id;
    private String title;
    private int file_size;
    private String rate;
    private ImageList image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFile_size() {
        return file_size;
    }

    public void setFile_size(int file_size) {
        this.file_size = file_size;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public ImageList getImage() {
        return image;
    }

    public void setImage(ImageList image) {
        this.image = image;
    }
}
