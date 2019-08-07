package com.dicoding.picodiploma.themoviedb.di;

import android.app.Application;

import com.dicoding.picodiploma.themoviedb.data.source.CatalogueRepository;
import com.dicoding.picodiploma.themoviedb.data.source.local.LocalRepository;
import com.dicoding.picodiploma.themoviedb.data.source.remote.RemoteRepository;
import com.dicoding.picodiploma.themoviedb.utils.JsonHelper;

public class Injection {
    public static CatalogueRepository provideRepository(Application application) {

        LocalRepository localRepository = new LocalRepository(application);
        RemoteRepository remoteRepository = RemoteRepository.getInstance(new JsonHelper(application));

        return CatalogueRepository.getInstance(localRepository, remoteRepository);
    }
}
