package com.example.moviefeature;

public class Data {
    int poster;
    String title;

    public Data(int poster, String title) {
        this.poster = poster;
        this.title = title;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
