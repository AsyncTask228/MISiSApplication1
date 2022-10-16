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

import java.util.List;

public class FoundDishAdapter extends RecyclerView.Adapter<FoundDishAdapter.ViewHolder> {

    private static RecyclerView recyclerView;
    private LayoutInflater inflater;
    private Context context;
    private List<Dish> found_dishes;

    public FoundDishAdapter(Context context, List<Dish> found_dishes) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.found_dishes = found_dishes;
    }

    @NonNull
    @Override
    public FoundDishAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_main_rv_itrem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoundDishAdapter.ViewHolder holder, int position) {

        holder.favorite_dish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (holder.favorite_dish_btn.getDrawable().equals(R.drawable.ic_baseline_favorite_border_24)) {
                    holder.favorite_dish_btn.setImageResource(R.drawable.ic_baseline_favorite_24);
                    //post запрос на избранное
                } else {
                    holder.favorite_dish_btn.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                    //delete запрос на избранное
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return found_dishes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageButton favorite_dish_btn;
        ImageView found_dish_image;
        TextView item_dish_name, ingredients_txt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            favorite_dish_btn = itemView.findViewById(R.id.favorite_dish_btn);
            found_dish_image = itemView.findViewById(R.id.found_dish_image);
            item_dish_name = itemView.findViewById(R.id.item_dish_name);
            ingredients_txt = itemView.findViewById(R.id.ingredients_txt);
        }
    }

    public static void update(){

    }

}
