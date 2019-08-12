package com.dicoding.picodiploma.themoviedb.ui.detail.tvShow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dicoding.picodiploma.themoviedb.data.source.CatalogueRepository;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShowEntity;

public class DetailTvShowViewModel extends ViewModel {
    private String tvShowId;
    private CatalogueRepository catalogueRepository;

    public DetailTvShowViewModel(CatalogueRepository mCatalogueRepository) {
        this.catalogueRepository = mCatalogueRepository;
    }

    LiveData<TvShowEntity> getTvShows() {
        return catalogueRepository.getTvShowById(tvShowId);
    }

    LiveData<TvShowEntity> getBookmarkTvShow(){
        return catalogueRepository.getBookmarkTvShowById(tvShowId);
    }

    void setTvShowId(String tvShowId) {
        this.tvShowId = tvShowId;
    }

    public void setBookmark(TvShowEntity tvShowEntity) {
        catalogueRepository.insertTvShow(tvShowEntity);
    }

    public void setUnBookmark(TvShowEntity tvShowEntity) {
        catalogueRepository.deleteTvShow(tvShowEntity);
    }
}

