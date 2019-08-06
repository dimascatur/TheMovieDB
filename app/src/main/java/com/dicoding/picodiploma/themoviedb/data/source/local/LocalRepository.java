package com.dicoding.picodiploma.themoviedb.data.source.local;

import androidx.lifecycle.LiveData;

import com.dicoding.picodiploma.themoviedb.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.MovieWithEntity;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.Movie;
import com.dicoding.picodiploma.themoviedb.data.source.local.room.CatalogueDao;

import java.util.List;

// todo ini sesuaikan dengan getBookmarkMovie, getBookmarkTvShow, getBookmarkMovieById, getBookmarkTvShowById, insertBookmarkMovie, insertBookmarkTvShow, deleteBookmarkTvShow, deleteBookmarkMovie
public class LocalRepository {
   private final CatalogueDao mCatalogueDao;

    private LocalRepository(CatalogueDao mCatalogueDao) {
        this.mCatalogueDao = mCatalogueDao;
    }

    private static LocalRepository INSTANCE;

    public static LocalRepository getInstance(CatalogueDao catalogueDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalRepository(catalogueDao);
        }
        return INSTANCE;
    }

    // getBookmarkMovie
    public LiveData<List<Movie>> getAllMovies() {
        return mCatalogueDao.getMovie();
    }

    // getBookmarkMovieById
    public LiveData<MovieWithEntity> getMovieWithEntity(final String movieId) {
        return mCatalogueDao.getMovieWithEntityById(movieId);
    }

    public void insertMovie(List<Movie> movies) {
        mCatalogueDao.insertMovies(movies);
    }

    // Tidak perlu
    public void setCourseBookmark(Movie movie) {
        mCatalogueDao.updateMovies(movie);
    }

    public LiveData<MovieEntity> getMovieById(String moduleId){
        return mCatalogueDao.getMovieById(moduleId);
    }

}
