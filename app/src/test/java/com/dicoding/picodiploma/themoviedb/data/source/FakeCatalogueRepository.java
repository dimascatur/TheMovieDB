package com.dicoding.picodiploma.themoviedb.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dicoding.picodiploma.themoviedb.data.source.local.LocalRepository;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.Movie;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShow;
import com.dicoding.picodiploma.themoviedb.data.source.remote.RemoteRepository;
import com.dicoding.picodiploma.themoviedb.data.source.remote.response.MovieResponse;
import com.dicoding.picodiploma.themoviedb.data.source.remote.response.TvShowResponse;

import java.util.ArrayList;
import java.util.List;

public class FakeCatalogueRepository implements CatalogueDataSource {
    private volatile static FakeCatalogueRepository INSTANCE = null;

    private final LocalRepository localRepository;
    private final RemoteRepository remoteRepository;

    FakeCatalogueRepository(@NonNull LocalRepository localRepository, @NonNull RemoteRepository remoteRepository) {
        this.localRepository = localRepository;
        this.remoteRepository = remoteRepository;
    }

    public static FakeCatalogueRepository getInstance(LocalRepository localRepository, RemoteRepository remoteRepository) {
        if (INSTANCE == null) {
            synchronized (FakeCatalogueRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FakeCatalogueRepository(localRepository, remoteRepository);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<List<Movie>> getAllMovies() {
        MutableLiveData<List<Movie>> movieResult = new MutableLiveData<>();

        remoteRepository.getAllMovies(new RemoteRepository.LoadMoviesCallback() {
            @Override
            public void onAllMoviesReceived(List<MovieResponse> movieResponses) {
                ArrayList<Movie> movieList = new ArrayList<>();
                for (int i = 0; i < movieResponses.size(); i++) {
                    MovieResponse response = movieResponses.get(i);
                    Movie movie = new Movie(response.getId(),
                            response.getTitle(),
                            response.getDescription(),
                            response.getRelease(),
                            response.getImgPhoto());

                    movieList.add(movie);

                }
                movieResult.postValue(movieList);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
        return movieResult;
    }

    @Override
    public LiveData<Movie> getCourseWithMovie(final String movieId) {
        MutableLiveData<Movie> movieResult = new MutableLiveData<>();

        remoteRepository.getAllMovies(new RemoteRepository.LoadMoviesCallback() {
            @Override
            public void onAllMoviesReceived(List<MovieResponse> movieResponses) {
                for (int i = 0; i < movieResponses.size(); i++) {
                    MovieResponse response = movieResponses.get(i);
                    if (response.getId().equals(movieId)) {
                        Movie movie = new Movie(response.getId(),
                                response.getTitle(),
                                response.getDescription(),
                                response.getRelease(),
                                response.getImgPhoto());
                        movieResult.postValue(movie);
                    }
                }
            }

            @Override
            public void onDataNotAvailable() {

            }
        });

        return movieResult;

    }

    @Override
    public LiveData<List<TvShow>> getAllTvShow() {
        MutableLiveData<List<TvShow>> tvShowResult = new MutableLiveData<>();

        remoteRepository.getAllShows(new RemoteRepository.LoadTvShowsCallback() {
            @Override
            public void onAllTvShowsReceived(List<TvShowResponse> tvShowResponses) {
                ArrayList<TvShow> tvShowList = new ArrayList<>();
                for (int i = 0; i < tvShowResponses.size(); i++) {
                    TvShowResponse response = tvShowResponses.get(i);
                    TvShow tvShow = new TvShow(response.getTvId(),
                            response.getTitle(),
                            response.getDescription(),
                            response.getRelease(),
                            response.getImgPhoto());

                    tvShowList.add(tvShow);
                }

                tvShowResult.postValue(tvShowList);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
        return tvShowResult;
    }


    @Override
    public LiveData<TvShow> getCourseWithTvShow(final String tvShowId) {
        MutableLiveData<TvShow> tvShowResult = new MutableLiveData<>();

        remoteRepository.getAllShows(new RemoteRepository.LoadTvShowsCallback() {
            @Override
            public void onAllTvShowsReceived(List<TvShowResponse> tvShowResponses) {
                for (int i = 0; i < tvShowResponses.size(); i++) {
                    TvShowResponse response = tvShowResponses.get(i);
                    if (response.getTvId().equals(tvShowId)) {
                        TvShow tvShow = new TvShow(response.getTvId(),
                                response.getTitle(),
                                response.getDescription(),
                                response.getRelease(),
                                response.getImgPhoto());
                        tvShowResult.postValue(tvShow);
                    }
                }
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
     return tvShowResult;
    }
}
