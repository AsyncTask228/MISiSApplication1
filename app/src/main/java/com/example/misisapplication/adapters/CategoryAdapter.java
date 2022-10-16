package com.example.misisapplication.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.misisapplication.DbImitation;
import com.example.misisapplication.R;
import com.example.misisapplication.domain.Category;
import com.example.misisapplication.fragments.AllDishFromCategoryFragment;
import com.example.misisapplication.fragments.ResultDishFragment;
import com.example.misisapplication.fragments.SearchFragment;
import com.example.misisapplication.rest.AppApiVolley;

import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Category> categories;
    private Context context;
    private SearchFragment fragment;

    public CategoryAdapter(Context context, List<Category> categories, SearchFragment fragment) {
        this.inflater = LayoutInflater.from(context);
        this.categories = categories;
        this.context = context;
        this.fragment = fragment;
    }


    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_main_rv_itrem, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {

        holder.category_name.setText(categories.get(position).getName());

        AppApiVolley appApiVolley = new AppApiVolley(context);

        appApiVolley.findDishesByCategoryId(categories.get(position).getId());


        DishesRecyclerAdapter dishesRecyclerAdapter;
        dishesRecyclerAdapter = new DishesRecyclerAdapter(context, DbImitation.getDishes(),fragment);
        holder.rv_dishes.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.rv_dishes.setAdapter(dishesRecyclerAdapter);
        dishesRecyclerAdapter.notifyDataSetChanged();



        holder.category_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("name", holder.category_name.getText().toString());
                holder.category_name.setOnClickListener((view1) -> {
                    NavHostFragment.
                            findNavController(fragment).navigate(
                            R.id.action_searchFragment_to_allDishFromCategoryFragment, bundle);
                });
                holder.category_name.performClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView category_name;
        RecyclerView rv_dishes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            category_name = itemView.findViewById(R.id.rv_category_text);
            rv_dishes = itemView.findViewById(R.id.rv_dish);
        }
    }
}