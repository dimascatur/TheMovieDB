package com.dicoding.picodiploma.themoviedb.data.source.local.entity.model;

public class MovieEntity {
    private String movieId;
    private String title;
    private String description;
    private String release;
    private String photo;

    public MovieEntity(String movieId, String title, String description, String release, String photo) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.release = release;
        this.photo = photo;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
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