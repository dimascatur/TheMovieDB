package com.dicoding.picodiploma.themoviedb.data.source.local.entity.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// TODO buat di sini @Entity
@Entity(tableName = "tvShowEntity")
public class TvShowEntity {

    // TODO Primary Key nya adalah si MovieId kelimanya gak boleh / NonNull
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvShowId")
    private String tvShowId;

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

}


// TODO buat kelas DAO -> getAll..., get...ById(String id...), insertMovie...(...), deleteMovie...(...)
// TODO liat di sini (https://www.dicoding.com/academies/129/tutorials/4479?from=4469)
// TODO Query nya ("Select * from ... where id = inputId")