package com.dicoding.picodiploma.themoviedb.data.source;

import androidx.lifecycle.LiveData;

import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.MovieEntity;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShowEntity;

import java.util.List;

public interface CatalogueDataSource {

    LiveData<List<MovieEntity>> getAllMovies();

    LiveData<MovieEntity> getMovieById(String movieId);

    LiveData<List<TvShowEntity>> getAllTvShow();

    LiveData<TvShowEntity> getTvShowById(String tvShowId);

    LiveData<List<MovieEntity>> getAllBookmarkMovies();

    LiveData<MovieEntity> getBookmarkMovieById(String movieId);

    void insertMovie(MovieEntity movieEntity);

    void deleteMovie(MovieEntity movieEntity);

    LiveData<List<TvShowEntity>> getAllBookmarkTvShows();

    LiveData<TvShowEntity> getBookmarkTvShowById(String tvShowId);

    void insertTvShow(TvShowEntity tvShowEntity);

    void deleteTvShow(TvShowEntity tvShowEntity);




}
