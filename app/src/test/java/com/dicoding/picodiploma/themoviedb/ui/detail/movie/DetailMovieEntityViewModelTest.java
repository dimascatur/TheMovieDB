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
        viewModel.setMovieId(movieId);
    }

    @After
    public void tearDown(){
    }

    @Test
    public void getMovies() {

        MovieEntity entity = new MovieEntity("123", "title", "desc", "11-11-11", "url");

        MutableLiveData<MovieEntity> movieEntities = new MutableLiveData<>();
        movieEntities.postValue(entity);

        when(catalogueRepository.getMovieById(movieId)).thenReturn(movieEntities);

        Observer<MovieEntity> observer = mock(Observer.class);
        viewModel.getMovies().observeForever(observer);

        verify(observer).onChanged(entity);
    }
}