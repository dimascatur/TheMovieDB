package com.dicoding.picodiploma.themoviedb.ui.detail.movie;

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
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.MovieEntity;
import com.dicoding.picodiploma.themoviedb.utils.GlideApp;
import com.dicoding.picodiploma.themoviedb.viewmodel.ViewModelFactory;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    private ProgressBar progressBar;

    private TextView textTitle;
    private TextView textDesc;
    private ImageView imageView;
    private ImageView imageBg;
    private Menu menu;
    private DetailMovieViewModel viewModel;
    private Boolean state = false;
    private MovieEntity movieEntity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
            String movieId = extras.getString(EXTRA_MOVIE);
            if (movieId != null) {
                progressBar.setVisibility(View.VISIBLE);
                viewModel.setMovieId(movieId);
            }

        }
        viewModel.getMovies().observe(this, movie -> {
            if (movie != null) {
                movieEntity = movie;
                populateCourse(movie);
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        this.menu = menu;

        viewModel.getBookmarkMovie().observe(this, movieEntity -> {
            state = movieEntity != null;
            setBookmarkState(state);

        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        } else if (item.getItemId() == R.id.action_bookmark) {
            if (movieEntity != null) {
                if (state) {
                    viewModel.setUnBookmark(movieEntity);
                    state = false;
                } else {
                    viewModel.setBookmark(movieEntity);
                    state = true;
                }
                setBookmarkState(state);
            }
        }
        return super.onOptionsItemSelected(item);
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

    private void populateCourse(MovieEntity movie) {
        textTitle.setText(movie.getTitle());
        textDesc.setText(movie.getDescription());

        GlideApp.with(getApplicationContext())
                .load(movie.getPhoto())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(imageView);

        GlideApp.with(getApplicationContext())
                .load(movie.getPhoto())
                .centerCrop()
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(imageBg);
    }

    @NonNull
    private static DetailMovieViewModel obtainViewModel(AppCompatActivity activity) {

        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return ViewModelProviders.of(activity, factory).get(DetailMovieViewModel.class);
    }
}

