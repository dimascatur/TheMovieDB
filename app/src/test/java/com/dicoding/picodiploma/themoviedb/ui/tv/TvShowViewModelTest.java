package com.dicoding.picodiploma.themoviedb.ui.tv;

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
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvShowViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private TvShowViewModel viewModel;
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);

    @Before
    public void setUp() {
        viewModel = new TvShowViewModel(catalogueRepository);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getTvShow() {
        MutableLiveData<List<TvShowEntity>> dummyTvShow = new MutableLiveData<>();
        dummyTvShow.setValue(FakeDataDummy.generateDummyTvShows());

        when(catalogueRepository.getAllTvShow()).thenReturn(dummyTvShow);

        Observer<List<TvShowEntity>> observer = Mockito.mock(Observer.class);

        viewModel.getTvShow().observeForever(observer);

        verify(catalogueRepository).getAllTvShow();
    }
}