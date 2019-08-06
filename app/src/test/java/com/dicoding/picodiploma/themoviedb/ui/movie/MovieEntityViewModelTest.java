package com.dicoding.picodiploma.themoviedb.ui.movie;

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
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieEntityViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MovieViewModel viewModel;
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);

    @Before
    public void setUp() {
        viewModel = new MovieViewModel(catalogueRepository);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getCourse() {
        MutableLiveData<List<MovieEntity>> dummyMovie = new MutableLiveData<>();
        dummyMovie.setValue(FakeDataDummy.generateDummyMovies());

        when(catalogueRepository.getAllMovies()).thenReturn(dummyMovie);

        Observer<List<MovieEntity>> observer = Mockito.mock(Observer.class);

        viewModel.getCourse().observeForever(observer);

        verify(catalogueRepository).getAllMovies();
    }

}