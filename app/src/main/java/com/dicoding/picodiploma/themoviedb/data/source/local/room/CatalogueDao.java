package com.dicoding.picodiploma.themoviedb.data.source.local.room;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.MovieEntity;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShowEntity;

import java.util.List;

public interface CatalogueDao {

    @WorkerThread
    @Query("SELECT * FROM movieEntity")
    LiveData<List<MovieEntity>> getAllMovies();

    @Transaction
    @Query("SELECT * FROM movieEntity WHERE movieId = :movieId")
    LiveData<MovieEntity> getMovieById(String movieId);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMovie(MovieEntity movieEntity);

    @Delete
    void deleteMovie(MovieEntity movieEntity);

    @WorkerThread
    @Query("SELECT * FROM tvShowEntity")
    LiveData<List<TvShowEntity>> getAllTvShows();

    @Transaction
    @Query("SELECT * FROM tvShowEntity WHERE tvShowId = :tvShowId")
    LiveData<TvShowEntity> getTvShowById(String tvShowId);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertTvShow(TvShowEntity tvShowEntity);

    @Delete
    void deleteTvShow(TvShowEntity tvShowEntity);


}
