package com.humber.saynn.mycommunity.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.humber.saynn.mycommunity.R;
import com.humber.saynn.mycommunity.activities.FoodBlog;
import com.humber.saynn.mycommunity.entities.Food;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalFoodAdapter extends RecyclerView.Adapter<HorizontalFoodAdapter.ViewHolder> {

    ArrayList<Food> foodList;
    LayoutInflater inflater;
    Context ctx;


    public HorizontalFoodAdapter(Context ctx,ArrayList<Food> foodList){
        this.foodList = foodList;
        inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public HorizontalFoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.horizontal_food_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.food = foodList.get(position);
        Food tempFood = holder.food;
        holder.foodImage.setImageResource(tempFood.getImageId());
        holder.descriptionText.setText(tempFood.getDescription());
        holder.foodCardView.setClickable(true);
        holder.url = tempFood.getUrl();
        String url = holder.url;
        final Uri location= Uri.parse(url);

        holder.foodCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ctx.getApplicationContext(), FoodBlog.class);
                ctx.startActivity(i);
            }
        });

        holder.foodCardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(location);
                v.getContext().startActivity(i);
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView foodCardView;
        ImageView foodImage;
        TextView descriptionText;
        String url;
        Food food;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.foodImage);
            descriptionText = itemView.findViewById(R.id.foodText);
            foodCardView = itemView.findViewById(R.id.foodCardView);

        }
    }
}
