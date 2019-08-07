package com.dicoding.picodiploma.themoviedb.ui.favorite.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dicoding.picodiploma.themoviedb.data.source.CatalogueRepository;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.MovieEntity;

import java.util.List;

public class FavoriteMovieViewModel extends ViewModel {
    private CatalogueRepository catalogueRepository;

    public FavoriteMovieViewModel(CatalogueRepository mCatalogueRepository) {
        this.catalogueRepository = mCatalogueRepository;
    }

    LiveData<List<MovieEntity>> getAllBookmarkMovies() {
        return catalogueRepository.getAllBookmarkMovies();
    }
}
