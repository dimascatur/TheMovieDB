package com.dicoding.picodiploma.themoviedb.ui.detail.tvShow;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.themoviedb.R;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShowEntity;
import com.dicoding.picodiploma.themoviedb.utils.GlideApp;
import com.dicoding.picodiploma.themoviedb.viewmodel.ViewModelFactory;

import java.util.List;

public class DetailTvShowActivity extends AppCompatActivity {
    public static final String EXTRA_TV = "extra_tvShow";

    private TextView textTitle;
    private TextView textDesc;
    private ImageView imageView;
    private ImageView imageBg;
    private ProgressBar progressBar;

    private DetailTvShowViewModel viewModel;
    private Menu menu;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_detail);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        viewModel = obtainViewModel(this);

        progressBar = findViewById(R.id.progress_bar);
        textTitle = findViewById(R.id.title_received);
        textDesc = findViewById(R.id.desc_received);
        imageView = findViewById(R.id.img_view);
        imageBg = findViewById(R.id.img_bg);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String tvShowId = extras.getString(EXTRA_TV);
            if (tvShowId != null) {
                progressBar.setVisibility(View.VISIBLE);
                viewModel.setCourseId(tvShowId);
            }

        }
        viewModel.getTvShows().observe(this, tvShow -> {
            if (tvShow != null) {
                populateCourse(tvShow);
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void setBookmarkState(boolean state) {
        if (menu == null) return;
        MenuItem menuItem = menu.findItem(R.id.action_bookmark);
        if (state) {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_black_24dp));
        } else {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_border_black_24dp));
        }
    }

    private void populateCourse(TvShowEntity tvShow) {
        textTitle.setText(tvShow.getTitle());
        textDesc.setText(tvShow.getDescription());

        GlideApp.with(getApplicationContext())
                .load(tvShow.getPhoto())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(imageView);

        GlideApp.with(getApplicationContext())
                .load(tvShow.getPhoto())
                .centerCrop()
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(imageBg);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }
    @NonNull
    private static DetailTvShowViewModel obtainViewModel(AppCompatActivity activity) {

        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return ViewModelProviders.of(activity, factory).get(DetailTvShowViewModel.class);
    }
}
