package com.dicoding.picodiploma.themoviedb.data.source.local.room;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.dicoding.picodiploma.themoviedb.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.MovieWithEntity;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.TvShowEntity;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.TvShowWithEntity;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.Movie;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShow;

import java.util.List;

@Dao
public interface CatalogueDao {

    @WorkerThread
    @Query("SELECT * FROM movieentities")
    LiveData<List<Movie>> getMovie();

    @Transaction
    @Query("SELECT * FROM movieentities WHERE movieId = :movieId")
    LiveData<MovieWithEntity> getMovieWithEntityById(String movieId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertMovies(List<Movie> movies);

    @Update(onConflict = OnConflictStrategy.FAIL)
    int updateMovies(Movie movies);

    @Query("SELECT * FROM moviemoduleentities WHERE moduleId = :moduleId")
    LiveData<List<MovieEntity>> getModulesByMovieId(String moduleId);


    @Query("SELECT * FROM moviemoduleentities WHERE courseId = :courseId")
    LiveData<MovieEntity> getMovieById(String courseId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertMovie(List<MovieEntity> movieEntities);

    @Update
    int updateModuleByMovie(MovieEntity movieEntity);

//    @WorkerThread
//    @Query("SELECT * FROM tvshowentities")
//    LiveData<List<TvShow>> getTvShow();
//
//    @Transaction
//    @Query("SELECT * FROM tvshowentities WHERE tvShowId = :tvShowId")
//    LiveData<TvShowWithEntity> getTvShowWithEntityById(String tvShowId);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    long[] insertTvShows(List<TvShow> tvShows);
//
//    @Update(onConflict = OnConflictStrategy.FAIL)
//    int updateTvShow(TvShow tvShow);
//
//    @Query("SELECT * FROM tvshowmoduleentities WHERE moduleId = :moduleId")
//    LiveData<List<TvShowEntity>> getModulesByTvShowId(String moduleId);
//
//
//    @Query("SELECT * FROM moviemoduleentities WHERE courseId = :courseId")
//    LiveData<TvShowEntity> getTvShowById(String courseId);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    long[] insertTvShow(List<TvShowEntity> tvShowEntities);
//
//    @Update
//    int updateModuleByTvShow(TvShowEntity tvShowEntity);
}
