package com.dicoding.picodiploma.themoviedb.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.dicoding.picodiploma.themoviedb.data.source.CatalogueRepository;
import com.dicoding.picodiploma.themoviedb.di.Injection;
import com.dicoding.picodiploma.themoviedb.ui.detail.movie.DetailMovieViewModel;
import com.dicoding.picodiploma.themoviedb.ui.detail.tvShow.DetailTvShowViewModel;
import com.dicoding.picodiploma.themoviedb.ui.movie.MovieViewModel;
import com.dicoding.picodiploma.themoviedb.ui.tv.TvShowViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;

    private final CatalogueRepository mCatalogueRepository;

    public ViewModelFactory(CatalogueRepository catalogueRepository) {
        mCatalogueRepository = catalogueRepository;
    }

    public static ViewModelFactory getInstance(Application application) {
        if (INSTANCE  == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(application));
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            //noinspection unchecked
            return (T) new MovieViewModel(mCatalogueRepository);
        } else if (modelClass.isAssignableFrom(TvShowViewModel.class)) {
            //noinspection unchecked
            return (T) new TvShowViewModel(mCatalogueRepository);
        } else if (modelClass.isAssignableFrom(DetailMovieViewModel.class)) {
            //noinspection unchecked
            return (T) new DetailMovieViewModel(mCatalogueRepository);
        } else if (modelClass.isAssignableFrom(DetailTvShowViewModel.class)) {
            //noinspection unchecked
            return (T) new DetailTvShowViewModel(mCatalogueRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}