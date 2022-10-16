package com.example.misisapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.misisapplication.R;
import com.example.misisapplication.adapters.AllDishFromCategoryAdapter;
import com.example.misisapplication.domain.Dish;

import java.util.ArrayList;
import java.util.List;


public class AllDishFromCategoryFragment extends Fragment {

    private List<Dish> dishList = new ArrayList<>();
    private ImageButton backStack;
    private TextView rv_all_dish_from_category_txt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_all_dish_from_category, container, false);

        RecyclerView recyclerView =view.findViewById(R.id.rv_all_dish_from_category);

        AllDishFromCategoryAdapter allDishFromCategoryAdapter = new AllDishFromCategoryAdapter(view.getContext(), dishList);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(allDishFromCategoryAdapter);

        backStack = view.findViewById(R.id.back_space_button_all_dish);
        String name = getArguments().getString("name");

        rv_all_dish_from_category_txt = view.findViewById(R.id.rv_all_dish_from_category_txt);

        rv_all_dish_from_category_txt.setText(name);

        backStack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backStack.setOnClickListener((view1) -> {
                    NavHostFragment.
                            findNavController(AllDishFromCategoryFragment.this).navigate(
                            R.id.action_allDishFromCategoryFragment_to_searchFragment);
                });
                backStack.performClick();
            }
        });

        return view;
    }
}