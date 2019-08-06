package com.dicoding.picodiploma.themoviedb.ui.detail.movie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dicoding.picodiploma.themoviedb.R;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class DetailMovieAdapter extends RecyclerView.Adapter<DetailMovieAdapter.MovieViewHolder> {

    private List<MovieEntity> movieEntities = new ArrayList<>();

    void setModules(List<MovieEntity> modules) {
        if (modules == null) return;
        movieEntities.clear();
        movieEntities.addAll(modules);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_module_list, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(movieEntities.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return movieEntities.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        final TextView textTitle;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_module_title);
        }

        void bind(String title) {
            textTitle.setText(title);
        }
    }
}
