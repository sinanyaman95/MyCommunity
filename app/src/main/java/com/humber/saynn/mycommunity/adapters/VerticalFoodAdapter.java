package com.humber.saynn.mycommunity.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.humber.saynn.mycommunity.R;
import com.humber.saynn.mycommunity.activities.FoodBlog;
import com.humber.saynn.mycommunity.entities.Food;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class VerticalFoodAdapter extends RecyclerView.Adapter<VerticalFoodAdapter.ViewHolder> {

    ArrayList<Food> foodList;
    LayoutInflater inflater;
    Context ctx;

    private static final int VIEW_TYPE_FOOTER = 99;
    private static final int VIEW_TYPE_CELL = 1;

    public VerticalFoodAdapter(Context ctx,ArrayList<Food> foodList){
        this.foodList = foodList;
        inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public VerticalFoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType == VIEW_TYPE_CELL){
            view = inflater.inflate(R.layout.vertical_food_item,parent,false);
        }else{
            view = inflater.inflate(R.layout.vertical_food_button,parent,false);
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if(position != foodList.size()){
            holder.food = foodList.get(position);
            Food tempFood = holder.food;
            holder.foodImage.setImageResource(tempFood.getImageId());
            holder.descriptionText.setText(tempFood.getDescription());
            holder.url = tempFood.getUrl();
            String url = holder.url;
            final Uri location= Uri.parse(url);
            holder.foodCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(location);
                    v.getContext().startActivity(i);
                }
            });
        }else{
            holder.addLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"This is adding a new res",Toast.LENGTH_SHORT).show();
            }
        });
        }




    }

    @Override
    public int getItemCount() {
        return foodList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == foodList.size()) ? VIEW_TYPE_FOOTER : VIEW_TYPE_CELL;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView foodCardView;
        ImageView foodImage;
        TextView descriptionText;
        Food food;
        String url;
        LinearLayout addLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.foodImage);
            descriptionText = itemView.findViewById(R.id.foodText);
            foodCardView = itemView.findViewById(R.id.foodCardView);
            addLayout = itemView.findViewById(R.id.addRestaurantLayout);

        }
    }
}
