package com.dicoding.picodiploma.themoviedb.utils;

import android.app.Application;

import com.dicoding.picodiploma.themoviedb.data.source.remote.response.MovieResponse;
import com.dicoding.picodiploma.themoviedb.data.source.remote.response.TvShowResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {

    private Application application;

    public JsonHelper(Application application) {
        this.application = application;
    }

    private String parsingFileToString(String fileName) {
        try {
            InputStream is = application.getAssets().open(fileName);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new String(buffer);

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public List<MovieResponse> loadMovies() {
        ArrayList<MovieResponse> list = new ArrayList<>();

        try {
            JSONObject responseObject = new JSONObject(parsingFileToString("MovieResponses.json"));
            JSONArray listArray = responseObject.getJSONArray("movies");
            for (int i = 0; i < listArray.length(); i++) {
                JSONObject course = listArray.getJSONObject(i);

                String id = course.getString("id");
                String title = course.getString("title");
                String description = course.getString("description");
                String release = course.getString("release");
                String imgPhoto = course.getString("imgPhoto");

                MovieResponse movieResponse = new MovieResponse(id, title, description, release, imgPhoto);
                list.add(movieResponse );
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<TvShowResponse> loadTvShow() {
        ArrayList<TvShowResponse> list = new ArrayList<>();

        try {
            JSONObject responseObject = new JSONObject(parsingFileToString("TvShowResponses.json"));
            JSONArray listArray = responseObject.getJSONArray("tvShows");
            for (int i = 0; i < listArray.length(); i++) {
                JSONObject course = listArray.getJSONObject(i);

                String tvId = course.getString("tvId");
                String title = course.getString("title");
                String description = course.getString("description");
                String release = course.getString("release");
                String imgPhoto = course.getString("imgPhoto");

                TvShowResponse tvShowResponse = new TvShowResponse(tvId, title, description, release, imgPhoto);
                list.add(tvShowResponse);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}