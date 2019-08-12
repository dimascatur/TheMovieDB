package com.dicoding.picodiploma.themoviedb.ui.favorite.tvShow;

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
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShowEntity;
import com.dicoding.picodiploma.themoviedb.ui.detail.tvShow.DetailTvShowActivity;
import com.dicoding.picodiploma.themoviedb.utils.GlideApp;

public class FavoriteTvShowAdapter extends PagedListAdapter<TvShowEntity, FavoriteTvShowAdapter.FavoriteTvShowViewHolder> {
    private Fragment fragment;

    protected FavoriteTvShowAdapter(@NonNull DiffUtil.ItemCallback<TvShowEntity> diffCallback) {
        super(diffCallback);
    }

    FavoriteTvShowAdapter(Fragment fragment) {
        super(DIFF_CALLBACK);
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public FavoriteTvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new FavoriteTvShowViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteTvShowViewHolder holder, int position) {
        TvShowEntity tvShowEntity = getItem(position);
        holder.TextViewNameTvShow.setText(tvShowEntity.getTitle());
        holder.TextViewReleaseTvShow.setText(tvShowEntity.getRelease());
        holder.TextViewDescriptionTvShow.setText(tvShowEntity.getDescription());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailTvShowActivity.class);
            intent.putExtra(DetailTvShowActivity.EXTRA_TV, tvShowEntity.getTvShowId());
            holder.itemView.getContext().startActivity(intent);
        });

        GlideApp.with(holder.itemView.getContext())
                .load(tvShowEntity.getPhoto())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(holder.ImageViewPhotoTvShow);
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
    private static DiffUtil.ItemCallback<TvShowEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<TvShowEntity>() {
                @Override
                public boolean areItemsTheSame(TvShowEntity oldTvShow, TvShowEntity newTvShow) {
                    return oldTvShow.getTitle().equals(newTvShow.getTitle());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(TvShowEntity oldTvShow, @NonNull TvShowEntity newTvShow) {
                    return oldTvShow.equals(newTvShow);
                }
            };
}
