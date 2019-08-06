package com.dicoding.picodiploma.themoviedb.ui.tv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dicoding.picodiploma.themoviedb.data.source.CatalogueRepository;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShowEntity;

import java.util.List;

public class TvShowViewModel extends ViewModel {
    private CatalogueRepository catalogueRepository;

    public TvShowViewModel(CatalogueRepository mCatalogueRepository) {
        this.catalogueRepository = mCatalogueRepository;
    }

    LiveData<List<TvShowEntity>> getTvShow() {
        return catalogueRepository.getAllTvShow();
    }
}
