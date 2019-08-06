package com.dicoding.picodiploma.themoviedb.data.source.local.entity.model;

public class TvShowEntity {
    private String tvShowId;
    private String title;
    private String description;
    private String release;
    private String photo;


    public TvShowEntity(String tvShowId, String title, String description, String release, String photo) {
        this.tvShowId = tvShowId;
        this.title = title;
        this.description = description;
        this.release = release;
        this.photo = photo;
    }

    public String getTvShowId() {
        return tvShowId;
    }

    public void setTvShowId(String tvShowId) {
        this.tvShowId = tvShowId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}