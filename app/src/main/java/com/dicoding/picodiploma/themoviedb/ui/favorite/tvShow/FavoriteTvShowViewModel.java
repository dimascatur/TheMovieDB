package com.dicoding.picodiploma.themoviedb.ui.favorite.tvShow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.themoviedb.data.source.CatalogueRepository;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShowEntity;

public class FavoriteTvShowViewModel extends ViewModel {
    private CatalogueRepository catalogueRepository;

    public FavoriteTvShowViewModel(CatalogueRepository mCatalogueRepository) {
        this.catalogueRepository = mCatalogueRepository;
    }

    LiveData<PagedList<TvShowEntity>> getAllBookmarkTvShow() {
        return catalogueRepository.getAllBookmarkTvShows();
    }
}

