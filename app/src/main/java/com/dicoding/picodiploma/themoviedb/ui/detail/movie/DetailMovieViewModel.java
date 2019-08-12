package com.dicoding.picodiploma.themoviedb.ui.detail.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dicoding.picodiploma.themoviedb.data.source.CatalogueRepository;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.MovieEntity;

public class DetailMovieViewModel extends ViewModel {
    private String movieId;
    private CatalogueRepository catalogueRepository;

    public DetailMovieViewModel(CatalogueRepository mCatalogueRepository) {
        this.catalogueRepository = mCatalogueRepository;
    }

    LiveData<MovieEntity> getMovies() {
        return catalogueRepository.getMovieById(movieId);
    }

    LiveData<MovieEntity> getBookmarkMovie(){
        return catalogueRepository.getBookmarkMovieById(movieId);
    }

    void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setBookmark(MovieEntity movieEntity) {
        catalogueRepository.insertMovie(movieEntity);
    }

    public void setUnBookmark(MovieEntity movieEntity) {
        catalogueRepository.deleteMovie(movieEntity);
    }
}

