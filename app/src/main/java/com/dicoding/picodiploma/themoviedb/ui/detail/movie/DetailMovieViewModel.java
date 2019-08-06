package com.dicoding.picodiploma.themoviedb.ui.detail.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dicoding.picodiploma.themoviedb.data.source.CatalogueRepository;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.Movie;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.themoviedb.utils.DataDummy;

import java.util.List;

public class DetailMovieViewModel extends ViewModel {
    private String courseId;
    private CatalogueRepository catalogueRepository;

    public DetailMovieViewModel(CatalogueRepository mCatalogueRepository) {
        this.catalogueRepository = mCatalogueRepository;
    }

    LiveData<Movie> getMovies() {
        return catalogueRepository.getCourseWithMovie(courseId);
    }

    List<MovieEntity> getModules() {
        return DataDummy.generateDummyEntity(getMovieId());
    }

    void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    private String getMovieId() {
        return courseId;
    }
}

