package com.dicoding.picodiploma.themoviedb.ui.movie;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.themoviedb.R;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.Movie;
import com.dicoding.picodiploma.themoviedb.ui.detail.movie.DetailMovieActivity;
import com.dicoding.picodiploma.themoviedb.utils.GlideApp;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private final Activity activity;
    private List<Movie> mData = new ArrayList<>();

    public MovieAdapter(Activity activity) {
        this.activity = activity;

    }

    private List<Movie> getListData() {
        return mData;
    }

    void setData(List<Movie> movies) {
        if (movies == null)  return;
        this.mData.clear();
        this.mData.addAll(movies);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, int position) {
        holder.TextViewNameMovie.setText(mData.get(position).getTitle());
        holder.TextViewReleaseMovie.setText(mData.get(position).getRelease());
        holder.TextViewDescriptionMovie.setText(mData.get(position).getDescription());


        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, DetailMovieActivity.class);
            intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, getListData().get(position).getMovieId());
                activity.startActivity(intent);
        });

        GlideApp.with(holder.itemView.getContext())
                .load(getListData().get(position).getPhoto())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(holder.ImageViewPhotoMovie);
    }


    @Override
    public int getItemCount() {
        return getListData().size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView TextViewNameMovie;
        TextView TextViewReleaseMovie;
        TextView TextViewDescriptionMovie;
        ImageView ImageViewPhotoMovie;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            TextViewNameMovie = itemView.findViewById(R.id.tv_movie_name);
            TextViewReleaseMovie = itemView.findViewById(R.id.tv_movie_date);
            TextViewDescriptionMovie = itemView.findViewById(R.id.tv_movie_desc);
            ImageViewPhotoMovie = itemView.findViewById(R.id.img_item_photo);
        }
    }

}
