package com.dicoding.picodiploma.themoviedb.ui.favorite.movie;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.themoviedb.R;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.MovieEntity;
import com.dicoding.picodiploma.themoviedb.ui.detail.movie.DetailMovieActivity;
import com.dicoding.picodiploma.themoviedb.utils.GlideApp;

import java.util.ArrayList;
import java.util.List;

public class FavoriteMovieAdapter extends RecyclerView.Adapter<FavoriteMovieAdapter.FavoriteMovieViewHolder> {
    private final FragmentActivity mFragment;
    private List<MovieEntity> data = new ArrayList<>();

    public FavoriteMovieAdapter(FragmentActivity fragment) {
        this.mFragment = fragment;
    }

    private List<MovieEntity> getListData() {
        return data;
    }

    void setData(List<MovieEntity> movies) {
        if (movies == null)  return;
        this.data.clear();
        this.data.addAll(movies);
    }

    @NonNull
    @Override
    public FavoriteMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new FavoriteMovieViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteMovieViewHolder holder, int position) {
        holder.TextViewNameMovie.setText(data.get(position).getTitle());
        holder.TextViewReleaseMovie.setText(data.get(position).getRelease());
        holder.TextViewDescriptionMovie.setText(data.get(position).getDescription());


        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailMovieActivity.class);
            intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, getListData().get(position).getMovieId());
            holder.itemView.getContext().startActivity(intent);
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
}
