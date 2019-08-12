package com.dicoding.picodiploma.themoviedb.ui.favorite.movie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.themoviedb.R;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.MovieEntity;
import com.dicoding.picodiploma.themoviedb.ui.detail.movie.DetailMovieActivity;
import com.dicoding.picodiploma.themoviedb.utils.GlideApp;

public class FavoriteMovieAdapter extends PagedListAdapter<MovieEntity, FavoriteMovieAdapter.FavoriteMovieViewHolder> {
    private Fragment fragment;

    protected FavoriteMovieAdapter(@NonNull DiffUtil.ItemCallback<MovieEntity> diffCallback) {
        super(diffCallback);
    }

    FavoriteMovieAdapter(Fragment fragment) {
        super(DIFF_CALLBACK);
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public FavoriteMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new FavoriteMovieViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteMovieViewHolder holder, int position) {
        MovieEntity movieEntity = getItem(position);
        holder.TextViewNameMovie.setText(movieEntity.getTitle());
        holder.TextViewReleaseMovie.setText(movieEntity.getRelease());
        holder.TextViewDescriptionMovie.setText(movieEntity.getDescription());


        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailMovieActivity.class);
            intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movieEntity.getMovieId());
            holder.itemView.getContext().startActivity(intent);
        });

        GlideApp.with(holder.itemView.getContext())
                .load(movieEntity.getPhoto())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(holder.ImageViewPhotoMovie);

    }

    class FavoriteMovieViewHolder extends RecyclerView.ViewHolder {
        TextView TextViewNameMovie;
        TextView TextViewReleaseMovie;
        TextView TextViewDescriptionMovie;
        ImageView ImageViewPhotoMovie;

        FavoriteMovieViewHolder(@NonNull View itemView) {
            super(itemView);
            TextViewNameMovie = itemView.findViewById(R.id.tv_movie_name);
            TextViewReleaseMovie = itemView.findViewById(R.id.tv_movie_date);
            TextViewDescriptionMovie = itemView.findViewById(R.id.tv_movie_desc);
            ImageViewPhotoMovie = itemView.findViewById(R.id.img_item_photo);
        }
    }

    private static DiffUtil.ItemCallback<MovieEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MovieEntity>() {
                @Override
                public boolean areItemsTheSame(MovieEntity oldMovie, MovieEntity newMovie) {
                    return oldMovie.getTitle().equals(newMovie.getTitle());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(MovieEntity oldMovie, @NonNull MovieEntity newMovie) {
                    return oldMovie.equals(newMovie);
                }
            };
}
