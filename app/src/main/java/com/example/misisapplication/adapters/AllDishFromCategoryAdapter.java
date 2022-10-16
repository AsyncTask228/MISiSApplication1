package com.example.misisapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.misisapplication.R;
import com.example.misisapplication.domain.Dish;

import java.util.ArrayList;
import java.util.List;

public class AllDishFromCategoryAdapter extends RecyclerView.Adapter<AllDishFromCategoryAdapter.ViewHolder> {

    private Context context;
    private List<Dish> dishList = new ArrayList<>();
    private LayoutInflater inflater;

    public AllDishFromCategoryAdapter(Context context, List<Dish> dishList) {
        this.context = context;
        this.dishList = dishList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AllDishFromCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custom_item_rv_found_dish, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllDishFromCategoryAdapter.ViewHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return dishList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView found_dish_image;
        ImageButton favorite_food_btn;
        TextView item_dish_name, ingredients_txt;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            found_dish_image = itemView.findViewById(R.id.found_dish_image);
            favorite_food_btn = itemView.findViewById(R.id.favorite_dish_btn);
            item_dish_name = itemView.findViewById(R.id.item_dish_name);
            ingredients_txt = itemView.findViewById(R.id.ingredients_txt);

        }
    }

}
