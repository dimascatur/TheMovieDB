package com.dicoding.picodiploma.themoviedb.data.source;

import androidx.lifecycle.LiveData;

import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.Movie;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShow;

import java.util.List;

public interface CatalogueDataSource {

    LiveData<List<Movie>> getAllMovies();

    LiveData<Movie> getCourseWithMovie(String movieId);

    LiveData<List<TvShow>> getAllTvShow();

    LiveData<TvShow> getCourseWithTvShow(String tvShowId);


}
