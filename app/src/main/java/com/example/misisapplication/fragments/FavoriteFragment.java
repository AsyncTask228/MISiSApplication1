package com.example.misisapplication.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.misisapplication.DbImitation;
import com.example.misisapplication.MainActivity;
import com.example.misisapplication.R;
import com.example.misisapplication.adapters.FavoriteAdapter;
import com.example.misisapplication.domain.Dish;
import com.example.misisapplication.rest.AppApiVolley;

import java.util.ArrayList;
import java.util.List;


public class FavoriteFragment extends Fragment {

    private static RecyclerView recyclerView;
    private static FavoriteAdapter favoriteAdapter;
    private List<Dish> dishes = new ArrayList<>();
   // private int personId =  MainActivity.sharedPreferences.getInt("id", 0);



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        AppApiVolley appApiVolley = new AppApiVolley(getContext());
        //appApiVolley.findRecipeByPersonId(personId);

        RecyclerView recyclerView = view.findViewById(R.id.rv_favorites_dishes);
        FavoriteAdapter favoriteAdapter = new FavoriteAdapter(view.getContext(), DbImitation.getRecipes());
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(favoriteAdapter);


        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void update() {
        favoriteAdapter = new FavoriteAdapter(recyclerView.getContext(), DbImitation.getRecipes());
        recyclerView.setAdapter(favoriteAdapter);
    }
}