package com.dicoding.picodiploma.themoviedb.ui.detail.tvShow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dicoding.picodiploma.themoviedb.R;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.TvShowEntity;

import java.util.ArrayList;
import java.util.List;

public class DetailTvShowAdapter extends RecyclerView.Adapter<DetailTvShowAdapter.TvShowViewHolder> {

    private List<TvShowEntity> tvShowEntities = new ArrayList<>();

    void setModules(List<TvShowEntity> modules) {
        if (modules == null) return;
        tvShowEntities.clear();
        tvShowEntities.addAll(modules);

    }
    @NonNull
    @Override
    public TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_module_list, parent, false);
        return new TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowViewHolder holder, int position) {
        holder.bind(tvShowEntities.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return tvShowEntities.size();
    }

    class TvShowViewHolder extends RecyclerView.ViewHolder {
        final TextView textTitle;

        TvShowViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_module_title);

        }
        void bind(String title) {
            textTitle.setText(title);
        }
    }
}
