package com.dicoding.picodiploma.themoviedb.ui.tv;

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
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShowEntity;
import com.dicoding.picodiploma.themoviedb.ui.detail.tvShow.DetailTvShowActivity;
import com.dicoding.picodiploma.themoviedb.utils.GlideApp;

import java.util.ArrayList;
import java.util.List;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> {
    private final Activity activity;
    private List<TvShowEntity> data = new ArrayList<>();

    public TvShowAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<TvShowEntity> getListData() {
        return data;
    }

    void setData(List<TvShowEntity>tvShows) {
        if (tvShows == null) return;
        this.data.clear();
        this.data.addAll(tvShows);
    }

    @NonNull
    @Override

    public TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowViewHolder holder, int position) {
        holder.TextViewNameTvShow.setText(data.get(position).getTitle());
        holder.TextViewReleaseTvShow.setText(data.get(position).getRelease());
        holder.TextViewDescriptionTvShow.setText(data.get(position).getDescription());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, DetailTvShowActivity.class);
            intent.putExtra(DetailTvShowActivity.EXTRA_TV, getListData().get(position).getTvShowId());
            activity.startActivity(intent);
        });

        GlideApp.with(holder.itemView.getContext())
                .load(getListData().get(position).getPhoto())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(holder.ImageViewPhotoTvShow);


    }

    @Override
    public int getItemCount() {
        return getListData().size();
    }

    class TvShowViewHolder extends RecyclerView.ViewHolder {
        TextView TextViewNameTvShow;
        TextView TextViewReleaseTvShow;
        TextView TextViewDescriptionTvShow;
        ImageView ImageViewPhotoTvShow;

        TvShowViewHolder(@NonNull View itemView) {
            super(itemView);
            TextViewNameTvShow = itemView.findViewById(R.id.tv_movie_name);
            TextViewReleaseTvShow = itemView.findViewById(R.id.tv_movie_date);
            TextViewDescriptionTvShow = itemView.findViewById(R.id.tv_movie_desc);
            ImageViewPhotoTvShow = itemView.findViewById(R.id.img_item_photo);
        }
    }
}