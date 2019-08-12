package com.dicoding.picodiploma.themoviedb.ui.favorite.tvShow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.themoviedb.data.source.CatalogueRepository;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShowEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FavoriteTvShowViewModelTest {


    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private FavoriteTvShowViewModel viewModel;
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);

    @Before
    public void setUp() {
        viewModel = new FavoriteTvShowViewModel(catalogueRepository);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getBookmarkTvShow() {
        MutableLiveData<PagedList<TvShowEntity>> dummyTv = new MutableLiveData<>();
        PagedList<TvShowEntity> pagedList = mock(PagedList.class);
        dummyTv.setValue(pagedList);

        when(catalogueRepository.getAllBookmarkTvShows()).thenReturn(dummyTv);

        Observer<PagedList<TvShowEntity>> observer = mock(Observer.class);

        viewModel.getAllBookmarkTvShow().observeForever(observer);

        verify(catalogueRepository).getAllBookmarkTvShows();
    }


}