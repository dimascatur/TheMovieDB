package com.dicoding.picodiploma.themoviedb.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DiskIOThreadExecutor implements Executor {

    private final Executor mDisk10;

    DiskIOThreadExecutor(){
        mDisk10 = Executors.newSingleThreadExecutor();
    }
    @Override
    public void execute(Runnable runnable) {
        mDisk10.execute(runnable);

    }
}
