package com.example.misisapplication.fragments;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.misisapplication.DbImitation;
import com.example.misisapplication.R;
import com.example.misisapplication.adapters.CategoryAdapter;
import com.example.misisapplication.domain.Category;
import com.example.misisapplication.domain.Dish;
import com.example.misisapplication.domain.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SearchFragment extends Fragment {

    public static List<Integer> ids= new ArrayList<>();
    private ArrayList<Category> categories = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DbImitation.clearDishList();

        View view = inflater.inflate(R.layout.fragment_search, container, false);

        RecyclerView rvCategory = view.findViewById(R.id.rv_category);

        categories.add(new Category(1, "Суп"));
        categories.add(new Category(2, "Салат"));
        categories.add(new Category(3, "Морожка"));
        categories.add(new Category(4, "Мясо"));
        DbImitation.addDish(new Dish(1, "оливье", Collections.emptyList(), new Image(1, "https://sun1-16.userapi.com/impg/of_3KiXI5atFg2RvTFfDIgixV9uKK2ZLovlXqg/XVElKrqZXrQ.jpg?size=1620x2160&quality=95&sign=410736b2092fec4b714a6089d614a70d&type=album")));


        CategoryAdapter categoryAdapter = new CategoryAdapter(getContext(), categories, SearchFragment.this);

        rvCategory.setAdapter(categoryAdapter);
        rvCategory.setLayoutManager(new LinearLayoutManager(getContext()));
        categoryAdapter.notifyDataSetChanged();

        AppCompatButton salad = view.findViewById(R.id.choose_salad);
        AppCompatButton soup = view.findViewById(R.id.choose_soup);
        AppCompatButton secondFood = view.findViewById(R.id.choose_second);
        AppCompatButton pp = view.findViewById(R.id.choose_pp);
        AppCompatButton post = view.findViewById(R.id.choose_post);
        AppCompatButton bakery = view.findViewById(R.id.choose_bakery);
        AppCompatButton vegan = view.findViewById(R.id.choose_vegan);
        AppCompatButton dessert = view.findViewById(R.id.choose_dessert);
        AppCompatButton veganskoe = view.findViewById(R.id.choose_veganskoe);
        AppCompatButton drink = view.findViewById(R.id.choose_drink);

        AppCompatButton searchButtonMainFragment = view.findViewById(R.id.search_button_main_fragment);

        searchButtonMainFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchButtonMainFragment.setOnClickListener((view1) -> {
                    NavHostFragment.
                            findNavController(SearchFragment.this).navigate(
                            R.id.action_searchFragment_to_resultDishFragment);
                });
                searchButtonMainFragment.performClick();
            }
        });


        View.OnClickListener listener = new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                AppCompatButton button = (AppCompatButton) view;

                Log.e("asifasdiguyofgasdyfgoas", categories.toString());
                Log.e("jbsfdjbsdfabjsadf", button.getText().toString());
                 Category category = categories.stream().filter(c -> c.getName().equals(button.getText())).findAny().get();


                if (ids.contains(category.getId())) {
                    ids.remove(category.getId());
                } else {
                    ids.add(category.getId());
                }

                Drawable background =
                        button.getBackground();
                if (background.getConstantState().equals(getResources()
                        .getDrawable(R.drawable.custom_btn_v2_orange).getConstantState())) {

                    button.setTextColor(getResources().getColor(R.color.black));
                    button.setBackgroundDrawable(getResources()
                            .getDrawable(R.drawable.custom_choose_button));
                } else {

                    button.setTextColor(getResources().getColor(R.color.white));
                    button.setBackgroundDrawable(getResources().getDrawable(R.drawable.custom_btn_v2_orange));
                }


            }
        };

        salad.setOnClickListener(listener);
        soup.setOnClickListener(listener);
        secondFood.setOnClickListener(listener);
        pp.setOnClickListener(listener);
        post.setOnClickListener(listener);
        bakery.setOnClickListener(listener);
        vegan.setOnClickListener(listener);
        dessert.setOnClickListener(listener);
        veganskoe.setOnClickListener(listener);
        drink.setOnClickListener(listener);


        return view;
    }


    public void replaceFragment(Fragment fragment){

        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.add(R.id.constraint_main_fragment, fragment);
        ft.commit();
    }
}