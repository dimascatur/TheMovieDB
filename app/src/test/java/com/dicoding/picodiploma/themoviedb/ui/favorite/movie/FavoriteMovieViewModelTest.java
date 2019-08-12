package com.dicoding.picodiploma.themoviedb.ui.favorite.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.themoviedb.data.source.CatalogueRepository;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.MovieEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FavoriteMovieViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private FavoriteMovieViewModel viewModel;
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);

    @Before
    public void setUp() {
        viewModel = new FavoriteMovieViewModel(catalogueRepository);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getBookmarkMovie() {
        MutableLiveData<PagedList<MovieEntity>> dummyMovie = new MutableLiveData<>();
        PagedList<MovieEntity> pagedList = mock(PagedList.class);
        dummyMovie.setValue(pagedList);

        when(catalogueRepository.getAllBookmarkMovies()).thenReturn(dummyMovie);

        Observer<PagedList<MovieEntity>> observer = mock(Observer.class);

        viewModel.getAllBookmarkMovies().observeForever(observer);

        verify(catalogueRepository).getAllBookmarkMovies();
    }

}