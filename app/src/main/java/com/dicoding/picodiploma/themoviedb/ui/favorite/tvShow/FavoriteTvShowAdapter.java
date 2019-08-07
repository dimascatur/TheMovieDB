package com.dicoding.picodiploma.themoviedb.ui.favorite.tvShow;

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
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShowEntity;
import com.dicoding.picodiploma.themoviedb.ui.detail.tvShow.DetailTvShowActivity;
import com.dicoding.picodiploma.themoviedb.utils.GlideApp;

import java.util.ArrayList;
import java.util.List;

public class FavoriteTvShowAdapter extends RecyclerView.Adapter<FavoriteTvShowAdapter.FavoriteTvShowViewHolder> {
    private final FragmentActivity mFragment;
    private List<TvShowEntity> data = new ArrayList<>();

    public FavoriteTvShowAdapter(FragmentActivity mFragment) {
        this.mFragment = mFragment;
    }

    private List<TvShowEntity> getListData() {
        return data;
    }

    void setData(List<TvShowEntity> tvShows) {
        if (tvShows == null) return;
        this.data.clear();
        this.data.addAll(tvShows);
    }

    @NonNull
    @Override
    public FavoriteTvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new FavoriteTvShowViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteTvShowViewHolder holder, int position) {
        holder.TextViewNameTvShow.setText(data.get(position).getTitle());
        holder.TextViewReleaseTvShow.setText(data.get(position).getRelease());
        holder.TextViewDescriptionTvShow.setText(data.get(position).getDescription());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailTvShowActivity.class);
            intent.putExtra(DetailTvShowActivity.EXTRA_TV, getListData().get(position).getTvShowId());
            holder.itemView.getContext().startActivity(intent);
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

    class FavoriteTvShowViewHolder extends RecyclerView.ViewHolder {
        TextView TextViewNameTvShow;
        TextView TextViewReleaseTvShow;
        TextView TextViewDescriptionTvShow;
        ImageView ImageViewPhotoTvShow;

        FavoriteTvShowViewHolder(@NonNull View itemView) {
            super(itemView);
            TextViewNameTvShow = itemView.findViewById(R.id.tv_movie_name);
            TextViewReleaseTvShow = itemView.findViewById(R.id.tv_movie_date);
            TextViewDescriptionTvShow = itemView.findViewById(R.id.tv_movie_desc);
            ImageViewPhotoTvShow = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
