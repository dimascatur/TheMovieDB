package com.dicoding.picodiploma.themoviedb.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dicoding.picodiploma.themoviedb.data.source.local.LocalRepository;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.MovieEntity;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShowEntity;
import com.dicoding.picodiploma.themoviedb.data.source.remote.RemoteRepository;
import com.dicoding.picodiploma.themoviedb.data.source.remote.response.MovieResponse;
import com.dicoding.picodiploma.themoviedb.data.source.remote.response.TvShowResponse;

import java.util.ArrayList;
import java.util.List;

public class CatalogueRepository implements CatalogueDataSource {
    private volatile static CatalogueRepository INSTANCE = null;

    private final LocalRepository localRepository;
    private final RemoteRepository remoteRepository;

    private CatalogueRepository(@NonNull LocalRepository localRepository, @NonNull RemoteRepository remoteRepository) {
        this.localRepository = localRepository;
        this.remoteRepository = remoteRepository;
    }

    public static CatalogueRepository getInstance(LocalRepository localRepository, RemoteRepository remoteRepository) {
        if (INSTANCE == null) {
            synchronized (CatalogueRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CatalogueRepository(localRepository, remoteRepository);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<List<MovieEntity>> getAllMovies() {
        MutableLiveData<List<MovieEntity>> movieResult = new MutableLiveData<>();

        remoteRepository.getAllMovies(new RemoteRepository.LoadMoviesCallback() {
            @Override
            public void onAllMoviesReceived(List<MovieResponse> movieResponses) {
                ArrayList<MovieEntity> movieList = new ArrayList<>();
                for (int i = 0; i < movieResponses.size(); i++) {
                    MovieResponse response = movieResponses.get(i);
                    MovieEntity movie = new MovieEntity(response.getId(),
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
    public LiveData<MovieEntity> getMovieById(final String movieId) {
        MutableLiveData<MovieEntity> movieResult = new MutableLiveData<>();

        remoteRepository.getAllMovies(new RemoteRepository.LoadMoviesCallback() {
            @Override
            public void onAllMoviesReceived(List<MovieResponse> movieResponses) {
                for (int i = 0; i < movieResponses.size(); i++) {
                    MovieResponse response = movieResponses.get(i);
                    if (response.getId().equals(movieId)) {
                        MovieEntity movie = new MovieEntity(response.getId(),
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
    public LiveData<List<TvShowEntity>> getAllTvShow() {
        MutableLiveData<List<TvShowEntity>> tvShowResult = new MutableLiveData<>();

        remoteRepository.getAllShows(new RemoteRepository.LoadTvShowsCallback() {
            @Override
            public void onAllTvShowsReceived(List<TvShowResponse> tvShowResponses) {
                ArrayList<TvShowEntity> tvShowList = new ArrayList<>();
                for (int i = 0; i < tvShowResponses.size(); i++) {
                    TvShowResponse response = tvShowResponses.get(i);
                    TvShowEntity tvShow = new TvShowEntity(response.getTvId(),
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
    public LiveData<TvShowEntity> getTvShowById(final String tvShowId) {
        MutableLiveData<TvShowEntity> tvShowResult = new MutableLiveData<>();

        remoteRepository.getAllShows(new RemoteRepository.LoadTvShowsCallback() {
            @Override
            public void onAllTvShowsReceived(List<TvShowResponse> tvShowResponses) {
                for (int i = 0; i < tvShowResponses.size(); i++) {
                    TvShowResponse response = tvShowResponses.get(i);
                    if (response.getTvId().equals(tvShowId)) {
                        TvShowEntity tvShow = new TvShowEntity(response.getTvId(),
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
