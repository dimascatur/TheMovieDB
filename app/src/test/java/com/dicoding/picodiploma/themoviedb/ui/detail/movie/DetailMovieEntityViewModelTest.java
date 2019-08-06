package com.dicoding.picodiploma.themoviedb.ui.detail.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.dicoding.picodiploma.themoviedb.data.source.CatalogueRepository;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.MovieEntity;
import com.dicoding.picodiploma.themoviedb.utils.FakeDataDummy;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailMovieEntityViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private DetailMovieViewModel viewModel;
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);
    private MovieEntity dummyMovie = FakeDataDummy.generateDummyMovies().get(0);
    private String movieId = dummyMovie.getMovieId();

    @Before
    public void setUp() {
        viewModel = new DetailMovieViewModel(catalogueRepository);
        viewModel.setCourseId(movieId);
    }

    @After
    public void tearDown(){
    }

    @Test
    public void getMovies() {
        MutableLiveData<MovieEntity> movieEntities = new MutableLiveData<>();

        when(catalogueRepository.getMovieById(movieId)).thenReturn(movieEntities);

        Observer<MovieEntity> observer = mock(Observer.class);
        viewModel.getMovies().observeForever(observer);

        verify(catalogueRepository).getMovieById(movieId);
    }
}