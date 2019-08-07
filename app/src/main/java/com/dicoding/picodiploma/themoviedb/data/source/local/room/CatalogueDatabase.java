package com.dicoding.picodiploma.themoviedb.data.source.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.MovieEntity;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShowEntity;

@Database(entities = {MovieEntity.class, TvShowEntity.class},
        version = 1,
        exportSchema = false)
public abstract class CatalogueDatabase extends RoomDatabase {

    public abstract CatalogueDao catalogueDao();

    private static volatile CatalogueDatabase INSTANCE;

    public static CatalogueDatabase getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (CatalogueDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CatalogueDatabase.class, "catalogue_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
