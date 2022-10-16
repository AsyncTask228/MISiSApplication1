package com.example.misisapplication.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.misisapplication.DbImitation;
import com.example.misisapplication.R;
import com.example.misisapplication.adapters.ResultDishAdapter;
import com.example.misisapplication.domain.Dish;
import com.example.misisapplication.domain.Image;
import com.example.misisapplication.rest.AppApiVolley;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultDishFragment extends Fragment {

    List<Dish> dishList = new ArrayList<>();
    private static RecyclerView recyclerView;
    private static ResultDishAdapter resultDishAdapter;
    private ImageButton backStack;

    private static ResultDishFragment fragment;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_dish, container, false);

        fragment = ResultDishFragment.this;
        dishList.clear();

        dishList.add(new Dish(2, "Борщ", Collections.emptyList(), new Image(2, "http://dankovsloboda.ru/components/com_jshopping/files/img_products/full_borshh-klasicheskij.jpg")));

        recyclerView = view.findViewById(R.id.rv_found);
        resultDishAdapter = new ResultDishAdapter(view.getContext(), dishList, fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(resultDishAdapter);

        backStack = view.findViewById(R.id.back_space_button_found);

        //======================================================  Стрелка назад

        backStack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backStack.setOnClickListener((view1) -> {
                    NavHostFragment.
                            findNavController(ResultDishFragment.this).navigate(
                            R.id.action_resultDishFragment_to_searchFragment);
                });
                backStack.performClick();
            }
        });


        //==========================================================================

        return view;
    }

    public static void update() {
        resultDishAdapter = new ResultDishAdapter(recyclerView.getContext(), DbImitation.getDishes(), fragment);
        recyclerView.setAdapter(resultDishAdapter);
    }

}