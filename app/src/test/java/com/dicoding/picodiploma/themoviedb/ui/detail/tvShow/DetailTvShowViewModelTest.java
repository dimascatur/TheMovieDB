package com.dicoding.picodiploma.themoviedb.ui.detail.tvShow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.dicoding.picodiploma.themoviedb.data.source.CatalogueRepository;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShowEntity;
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

public class DetailTvShowViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private DetailTvShowViewModel viewModel;
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);
    private TvShowEntity dummyTvShow = FakeDataDummy.generateDummyTvShows().get(0);
    private String tvShowId = dummyTvShow.getTvShowId();

    @Before
    public void setUp() {
        viewModel = new DetailTvShowViewModel(catalogueRepository);
        viewModel.setTvShowId(tvShowId);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getTvShows() {

        TvShowEntity entity = new TvShowEntity("123", "title", "desc", "12-12-12", "url");

        MutableLiveData<TvShowEntity> tvShowEntities = new MutableLiveData<>();
        tvShowEntities.postValue(entity);

        when(catalogueRepository.getTvShowById(tvShowId)).thenReturn(tvShowEntities);

        Observer<TvShowEntity> observer = mock(Observer.class);
        viewModel.getTvShows().observeForever(observer);

        verify(observer).onChanged(entity);
    }
}
