package com.dicoding.picodiploma.themoviedb.ui.detail.tvShow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dicoding.picodiploma.themoviedb.data.source.CatalogueRepository;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.TvShowEntity;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShow;
import com.dicoding.picodiploma.themoviedb.utils.DataDummy;

import java.util.List;

public class DetailTvShowViewModel extends ViewModel {
    private String courseId;
    private CatalogueRepository catalogueRepository;

    public DetailTvShowViewModel(CatalogueRepository mCatalogueRepository) {
        this.catalogueRepository = mCatalogueRepository;
    }

    LiveData<TvShow> getTvShows() {
        return catalogueRepository.getCourseWithTvShow(courseId);
    }

    List<TvShowEntity> getModules() {
        return DataDummy.generateDummyTv(getTvShowId());

    }

    void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    private String getTvShowId() {
        return courseId;
    }
}

