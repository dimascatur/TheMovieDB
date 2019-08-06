package com.dicoding.picodiploma.themoviedb.data.source.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dicoding.picodiploma.themoviedb.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.Movie;


@Database(entities = {Movie.class, MovieEntity.class},
        version = 1,
        exportSchema = false)
public abstract class CatalogueDatabase extends RoomDatabase {

    private static CatalogueDatabase INSTANCE;

    public abstract CatalogueDao catalogueDao();

    private static final Object sLock = new Object();

    public static CatalogueDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        CatalogueDatabase.class, "Catalogue.db")
                        .build();
            }
            return INSTANCE;
        }
    }
}
