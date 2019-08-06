package com.dicoding.picodiploma.themoviedb.data.source.local.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.Movie;

import java.util.List;


// todo Ini tidak perlu
public class MovieWithEntity {
    @Embedded
    public Movie movie;

    @Relation(parentColumn = "movieId", entityColumn = "movieId")
    public List<MovieEntity> movieEntities;
}
