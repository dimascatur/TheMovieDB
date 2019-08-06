package com.dicoding.picodiploma.themoviedb.ui.detail.tvShow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dicoding.picodiploma.themoviedb.data.source.CatalogueRepository;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShowEntity;

import java.util.List;

public class DetailTvShowViewModel extends ViewModel {
    private String courseId;
    private CatalogueRepository catalogueRepository;

    public DetailTvShowViewModel(CatalogueRepository mCatalogueRepository) {
        this.catalogueRepository = mCatalogueRepository;
    }

    LiveData<TvShowEntity> getTvShows() {
        return catalogueRepository.getTvShowById(courseId);
    }

    void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    private String getTvShowId() {
        return courseId;
    }
}

