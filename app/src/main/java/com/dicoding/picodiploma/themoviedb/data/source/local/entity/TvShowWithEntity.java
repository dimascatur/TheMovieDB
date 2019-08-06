package com.dicoding.picodiploma.themoviedb.data.source.local.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShow;

import java.util.List;


// todo Ini tidak perlu
public class TvShowWithEntity {
    @Embedded
    public TvShow tvShow;

    @Relation(parentColumn = "tvShowId", entityColumn = "tvShowId")
    public List<TvShowEntity> tvShowEntities;
}
