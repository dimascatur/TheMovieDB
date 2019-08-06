package com.dicoding.picodiploma.themoviedb.data.source.remote;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.Movie;
import com.dicoding.picodiploma.themoviedb.data.source.remote.response.MovieResponse;
import com.dicoding.picodiploma.themoviedb.data.source.remote.response.TvShowResponse;
import com.dicoding.picodiploma.themoviedb.utils.EspressoIdlingResource;
import com.dicoding.picodiploma.themoviedb.utils.JsonHelper;

import java.util.List;

public class RemoteRepository {

    private static RemoteRepository INSTANCE;
    private JsonHelper jsonHelper;
    private final long SERVICE_LATENCY_IN_MILLIS = 2000;

    private RemoteRepository(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteRepository getInstance(JsonHelper helper){
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepository(helper);
        }
        return INSTANCE;
    }

    public void getAllMovies(LoadMoviesCallback  callback) {
        EspressoIdlingResource.increment();
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            callback.onAllMoviesReceived(jsonHelper.loadMovies());
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    public void getAllShows(LoadTvShowsCallback callback) {
        EspressoIdlingResource.increment();
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            callback.onAllTvShowsReceived(jsonHelper.loadTvShow());
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    public interface LoadMoviesCallback {
        void onAllMoviesReceived(List<MovieResponse> movieResponses);

        void onDataNotAvailable();
    }

    public interface LoadTvShowsCallback {
        void onAllTvShowsReceived(List<TvShowResponse> tvShowResponses);

        void onDataNotAvailable();
    }
}
