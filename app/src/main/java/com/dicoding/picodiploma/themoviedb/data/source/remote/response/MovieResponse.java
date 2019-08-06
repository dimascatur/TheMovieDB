package com.dicoding.picodiploma.themoviedb.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieResponse implements Parcelable {
    private String id;
    private String title;
    private String release;
    private String description;
    private String imgPhoto;

    public MovieResponse() {

    }

    public MovieResponse(String id, String title, String description, String release,  String imgPhoto) {
        this.id = id;
        this.title = title;
        this.release = release;
        this.description = description;
        this.imgPhoto = imgPhoto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgPhoto() {
        return imgPhoto;
    }

    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.release);
        dest.writeString(this.description);
        dest.writeString(this.imgPhoto);
    }

    protected MovieResponse(Parcel in) {
        id = in.readString();
        title = in.readString();
        release = in.readString();
        description = in.readString();
        imgPhoto = in.readString();
    }

    public static final Creator<MovieResponse> CREATOR = new Creator<MovieResponse>() {
        @Override
        public MovieResponse createFromParcel(Parcel source) {
            return new MovieResponse(source);
        }

        @Override
        public MovieResponse[] newArray(int size) {
            return new MovieResponse[size];
        }
    };
}