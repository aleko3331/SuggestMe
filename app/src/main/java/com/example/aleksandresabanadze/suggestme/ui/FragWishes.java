package com.example.aleksandresabanadze.suggestme.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aleksandresabanadze.suggestme.R;
import com.example.aleksandresabanadze.suggestme.adapters.OnItemClickListener;
import com.example.aleksandresabanadze.suggestme.adapters.RVAdapter;
import com.example.aleksandresabanadze.suggestme.db.DbHelper;
import com.example.aleksandresabanadze.suggestme.models.MovieModel;

import java.util.List;

public class FragWishes extends Fragment {

    private RecyclerView recyclerView;
    private RVAdapter rvAdapter;
    private List<MovieModel> movieModels;
    private DbHelper dbHelper;

    public FragWishes() {
    }

    public static FragWishes newInstance() {
        FragWishes fragment = new FragWishes();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inf = inflater.inflate(R.layout.fragment_frag_wishes, container, false);

        recyclerView = inf.findViewById(R.id.recycler_view_want);
        recyclerView.setHasFixedSize(true);

        dbHelper = new DbHelper(getContext());

        movieModels = dbHelper.getMovieDataToWant();

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);

        rvAdapter = new RVAdapter(movieModels, getContext());
        recyclerView.setAdapter(rvAdapter);

        rvAdapter.setOnRecyclerItemListener(new OnItemClickListener() {
            @Override
            public void onClick(int position) {
                dbHelper.deleteMovieData(movieModels.get(position).id);
                rvAdapter.deleteMovie(position);
                rvAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(rvAdapter);
            }
        });



        return inf;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            movieModels = dbHelper.getMovieDataToWant();
            rvAdapter.addMovie(movieModels);
            rvAdapter.notifyDataSetChanged();
        }
    }
}
