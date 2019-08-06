package com.dicoding.picodiploma.themoviedb.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShowResponse implements Parcelable {
    private String tvId;
    private String title;
    private String description;
    private String release;
    private String imgPhoto;

    public TvShowResponse() {

    }

    public TvShowResponse(String tvId, String title, String description, String release, String imgPhoto) {
        this.tvId = tvId;
        this.title = title;
        this.description = description;
        this.release = release;
        this.imgPhoto = imgPhoto;
    }

    public String getTvId() {
        return tvId;
    }

    public void setTvId(String tvId) {
        this.tvId = tvId;
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
        dest.writeString(this.tvId);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.release);
        dest.writeString(this.imgPhoto);
    }

    protected TvShowResponse(Parcel in) {
        tvId = in.readString();
        title = in.readString();
        description = in.readString();
        release = in.readString();
        imgPhoto = in.readString();
    }

    public static final Creator<TvShowResponse> CREATOR = new Creator<TvShowResponse>() {
        @Override
        public TvShowResponse createFromParcel(Parcel source) {
            return new TvShowResponse(source);
        }

        @Override
        public TvShowResponse[] newArray(int size) {
            return new TvShowResponse[size];
        }
    };
}
