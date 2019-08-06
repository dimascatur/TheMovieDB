package com.dicoding.picodiploma.themoviedb.ui.detail.tvShow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.dicoding.picodiploma.themoviedb.data.source.CatalogueRepository;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.TvShowEntity;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShow;
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
    private TvShow dummyTvShow = FakeDataDummy.generateDummyTvShows().get(0);
    private String tvShowId = dummyTvShow.getTvShowId();

    @Before
    public void setUp() {
        viewModel = new DetailTvShowViewModel(catalogueRepository);
        viewModel.setCourseId(tvShowId);
    }

    @After
    public void tearDown(){
    }

    @Test
    public void getTvShows() {
        MutableLiveData<TvShow> tvShowEntities = new MutableLiveData<>();

        when(catalogueRepository.getCourseWithTvShow(tvShowId)).thenReturn(tvShowEntities);

        Observer<TvShow> observer = mock(Observer.class);
        viewModel.getTvShows().observeForever(observer);

        verify(catalogueRepository).getCourseWithTvShow(tvShowId);
    }

    @Test
    public void getModules() {
        List<TvShowEntity> tvShowEntityList = viewModel.getModules();
        assertNotNull(tvShowEntityList);
        assertEquals(10, tvShowEntityList.size());
    }
}
