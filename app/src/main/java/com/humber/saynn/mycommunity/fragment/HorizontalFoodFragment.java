package com.humber.saynn.mycommunity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.humber.saynn.mycommunity.R;
import com.humber.saynn.mycommunity.adapters.HorizontalFoodAdapter;
import com.humber.saynn.mycommunity.database.FirebaseDb;
import com.humber.saynn.mycommunity.entities.Food;
import com.humber.saynn.mycommunity.entities.FoodContent;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalFoodFragment extends Fragment {

    ArrayList<Food> foodList;
    String email;
    FirebaseDb db;


    public HorizontalFoodFragment(String email){
        this.email = email;
        db=FirebaseDb.getInstance();
        this.foodList = fixFoodList();
    }

    private ArrayList<Food> fixFoodList() {
        ArrayList<Food> foodList = FoodContent.getInstance().getFoodList();
        ArrayList<Food> tempList = new ArrayList<>();
        ArrayList<String> nationality = getUserNationality();
        for(String s : nationality){
            for(Food f: foodList){
                if(f.getNationality().equalsIgnoreCase(s)){
                    tempList.add(f);
                }
            }
        }
        return tempList;
    }

    private ArrayList<String> getUserNationality() {
        return db.getNationality();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.horizontal_food_list,container,false);

        if(v instanceof RecyclerView){
            Context context = v.getContext();
            RecyclerView recyclerView = (RecyclerView) v;
            recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            recyclerView.setAdapter(new HorizontalFoodAdapter(context,foodList));

        }
        return v;
    }
}
