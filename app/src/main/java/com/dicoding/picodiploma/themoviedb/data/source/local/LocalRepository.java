package com.dicoding.picodiploma.themoviedb.data.source.local;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.MovieEntity;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShowEntity;
import com.dicoding.picodiploma.themoviedb.data.source.local.room.CatalogueDao;
import com.dicoding.picodiploma.themoviedb.data.source.local.room.CatalogueDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Dipanggil ke sini
public class LocalRepository {
    private CatalogueDao mCatalogueDao;
    private ExecutorService executorService;

    public LocalRepository(Application application) {
        executorService = Executors.newSingleThreadExecutor();

        CatalogueDatabase database = CatalogueDatabase.getDatabase(application);
        mCatalogueDao = database.catalogueDao();
    }

    public LiveData<List<MovieEntity>> getAllMovies() {
        return mCatalogueDao.getAllMovies();
    }

    public LiveData<MovieEntity> getMovieById(final String movieId) {
        return mCatalogueDao.getMovieById(movieId);
    }

    public void insertMovies(final MovieEntity movieEntity) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                mCatalogueDao.insertMovie(movieEntity);
            }
        });
    }

    public void deleteMovies(final MovieEntity movieEntity) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                mCatalogueDao.deleteMovie(movieEntity);
            }
        });
    }

    public LiveData<List<TvShowEntity>> getAllTvShows() {
        return mCatalogueDao.getAllTvShows();
    }

    public LiveData<TvShowEntity> getTvShowById(final String tvShowId) {
        return mCatalogueDao.getTvShowById(tvShowId);
    }

    public void insertTvShows(final TvShowEntity tvShowEntity) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                mCatalogueDao.insertTvShow(tvShowEntity);
            }
        });
    }

    public void deleteTvShows(final TvShowEntity tvShowEntity) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                mCatalogueDao.deleteTvShow(tvShowEntity);
            }
        });
    }
}

