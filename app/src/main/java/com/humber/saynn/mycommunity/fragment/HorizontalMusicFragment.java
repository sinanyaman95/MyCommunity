package com.humber.saynn.mycommunity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.humber.saynn.mycommunity.R;
import com.humber.saynn.mycommunity.adapters.HorizontalFoodAdapter;
import com.humber.saynn.mycommunity.adapters.HorizontalMusicAdapter;
import com.humber.saynn.mycommunity.entities.Music;
import com.humber.saynn.mycommunity.entities.MusicContent;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalMusicFragment extends Fragment {

    HorizontalMusicFragment horizontalFoodAdapter;
    ArrayList<Music> musicList;


    private HorizontalMusicFragment(){
        this.musicList = MusicContent.getInstance().getMusicList();
    }

    public static HorizontalMusicFragment newInstance(){
        return new HorizontalMusicFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.horizontal_music_list,container,false);

        if(v instanceof RecyclerView){
            Context context = v.getContext();
            RecyclerView recyclerView = (RecyclerView) v;
            recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            recyclerView.setAdapter(new HorizontalMusicAdapter(context,musicList));

        }
        return v;
    }
}
