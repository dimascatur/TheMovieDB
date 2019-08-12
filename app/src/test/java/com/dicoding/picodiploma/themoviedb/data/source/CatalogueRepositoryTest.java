package com.dicoding.picodiploma.themoviedb.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.paging.DataSource;

import com.dicoding.picodiploma.themoviedb.data.source.local.LocalRepository;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.MovieEntity;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShowEntity;
import com.dicoding.picodiploma.themoviedb.data.source.remote.RemoteRepository;
import com.dicoding.picodiploma.themoviedb.data.source.remote.response.MovieResponse;
import com.dicoding.picodiploma.themoviedb.data.source.remote.response.TvShowResponse;
import com.dicoding.picodiploma.themoviedb.utils.FakeDataDummy;
import com.dicoding.picodiploma.themoviedb.utils.LiveDataTestUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CatalogueRepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private LocalRepository local = mock(LocalRepository.class);
    private RemoteRepository remote = mock(RemoteRepository.class);
    private FakeCatalogueRepository catalogueRepository = new FakeCatalogueRepository(local, remote);

    private ArrayList<MovieResponse> movieResponses = FakeDataDummy.generateRemoteDummyMovies();
    private String movieId = movieResponses.get(0).getId();

    private ArrayList<TvShowResponse> tvShowResponses = FakeDataDummy.generateRemoteDummyTvShows();
    private String tvShowId = tvShowResponses.get(0).getTvId();

    @Before
    public void setUp(){

    }

    @After
    public void tearDown() {

    }

    @Test
    public void getAllMovies() {

        doAnswer(invocation -> {
            ((RemoteRepository.LoadMoviesCallback) invocation.getArguments()[0])
                    .onAllMoviesReceived(movieResponses);
            return null;
        }).when(remote).getAllMovies(any(RemoteRepository.LoadMoviesCallback.class));

        List<MovieEntity> result = LiveDataTestUtil.getValue(catalogueRepository.getAllMovies());

        verify(remote, times(1)).getAllMovies(any(RemoteRepository.LoadMoviesCallback.class));

        assertEquals(movieResponses.size(), result.size());
    }

    @Test
    public void getAllTvShows() {
        doAnswer(invocation -> {
            ((RemoteRepository.LoadTvShowsCallback) invocation.getArguments()[0])
                    .onAllTvShowsReceived(tvShowResponses);
            return null;
        }).when(remote).getAllShows(any(RemoteRepository.LoadTvShowsCallback.class));

        List<TvShowEntity> result = LiveDataTestUtil.getValue(catalogueRepository.getAllTvShow());

        verify(remote, times(1)).getAllShows(any(RemoteRepository.LoadTvShowsCallback.class));

        assertEquals(tvShowResponses.size(), result.size());
    }

    @Test
    public void getMovieById() {
        doAnswer(invocation -> {
            ((RemoteRepository.LoadMoviesCallback) invocation.getArguments()[0])
                    .onAllMoviesReceived(movieResponses);
            return null;
        }).when(remote).getAllMovies(any(RemoteRepository.LoadMoviesCallback.class));

        MovieEntity result = LiveDataTestUtil.getValue(catalogueRepository.getMovieById(movieId));

        verify(remote, times(1)).getAllMovies(any(RemoteRepository.LoadMoviesCallback.class));

        assertEquals(movieResponses.get(0).getTitle(), result.getTitle());
    }

    @Test
    public void getTvShowById() {
        doAnswer(invocation -> {
            ((RemoteRepository.LoadTvShowsCallback) invocation.getArguments()[0])
                    .onAllTvShowsReceived(tvShowResponses);
            return null;
        }).when(remote).getAllShows(any(RemoteRepository.LoadTvShowsCallback.class));

        TvShowEntity result = LiveDataTestUtil.getValue(catalogueRepository.getTvShowById(tvShowId));
        assertEquals(tvShowResponses.get(0).getTitle(), result.getTitle());

        verify(remote, times(1)).getAllShows(any(RemoteRepository.LoadTvShowsCallback.class));

    }

    @Test
    public void getBookmarkedMovies(){

        DataSource.Factory<Integer, MovieEntity> dataSourceMovie = mock(DataSource.Factory.class);

        when(local.getAllBookmarkMovies()).thenReturn(dataSourceMovie);

        catalogueRepository.getAllBookmarkMovies();

        verify(local).getAllBookmarkMovies();
    }

    @Test
    public void getBookmarkedTvShows() {

        DataSource.Factory<Integer, TvShowEntity> dataSourceTvShow = mock(DataSource.Factory.class);

        when(local.getAllBookmarkTvShows()).thenReturn(dataSourceTvShow);

        catalogueRepository.getAllBookmarkTvShows();

        verify(local).getAllBookmarkTvShows();
    }
}