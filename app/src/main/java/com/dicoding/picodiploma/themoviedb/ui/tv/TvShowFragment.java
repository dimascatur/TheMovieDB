package com.dicoding.picodiploma.themoviedb.ui.tv;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.dicoding.picodiploma.themoviedb.R;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShowEntity;
import com.dicoding.picodiploma.themoviedb.viewmodel.ViewModelFactory;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {
    private RecyclerView rvTvshow;
    private TvShowViewModel viewModel;
    private TvShowAdapter adapter;
    private ProgressBar progressBar;

    private List<TvShowEntity> tvShows;


    public TvShowFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new TvShowFragment();
    }

    @NonNull
    private static TvShowViewModel obtainViewModel(FragmentActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(TvShowViewModel.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTvshow = view.findViewById(R.id.rv_tvShow);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() !=  null) {
            progressBar.setVisibility(View.VISIBLE);

            viewModel = obtainViewModel(getActivity());

            TvShowAdapter tvShowAdapter = new TvShowAdapter(getActivity());

            viewModel.getTvShow().observe(this, tvShows -> {
                progressBar.setVisibility(View.GONE);
                tvShowAdapter.setData(tvShows);
                tvShowAdapter.notifyDataSetChanged();

            });

            rvTvshow.setLayoutManager(new LinearLayoutManager(getContext()));
            rvTvshow.setHasFixedSize(true);
            rvTvshow.setAdapter(tvShowAdapter);
        }
    }
}
