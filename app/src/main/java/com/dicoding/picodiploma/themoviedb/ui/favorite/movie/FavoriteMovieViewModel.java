package com.dicoding.picodiploma.themoviedb.ui.favorite.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.themoviedb.data.source.CatalogueRepository;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.MovieEntity;

public class FavoriteMovieViewModel extends ViewModel {
    private CatalogueRepository catalogueRepository;

    public FavoriteMovieViewModel(CatalogueRepository mCatalogueRepository) {
        this.catalogueRepository = mCatalogueRepository;
    }

    LiveData<PagedList<MovieEntity>> getAllBookmarkMovies() {
        return catalogueRepository.getAllBookmarkMovies();
    }
}
