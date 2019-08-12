package com.dicoding.picodiploma.themoviedb.data.source.local.entity.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// TODO buat di sini @Entity
@Entity (tableName = "movieEntity")
public class MovieEntity {

    // TODO Primary Key nya adalah si MovieId kelimanya gak boleh / NonNull

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    private String movieId;

    @NonNull
    @ColumnInfo(name = "title")
    private String title;

    @NonNull
    @ColumnInfo(name = "description")
    private String description;

    @NonNull
    @ColumnInfo(name = "release")
    private String release;

    @NonNull
    @ColumnInfo(name = "photo")
    private String photo;

    public MovieEntity(String movieId, String title, String description, String release,String photo) {
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

}