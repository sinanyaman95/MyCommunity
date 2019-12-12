package com.humber.saynn.mycommunity.entities;

import com.humber.saynn.mycommunity.R;

import java.util.ArrayList;

public class MusicContent {

    private static MusicContent mc_instance;
    ArrayList<Music> musicList;
    private MusicContent(){
        musicList = fillMusicList();
    }

    public static MusicContent getInstance(){
        if(mc_instance == null){
            mc_instance = new MusicContent();
        }
        return mc_instance;
    }

    private ArrayList<Music> fillMusicList() {
        ArrayList<Music> tempMusicList = new ArrayList<>();

        tempMusicList.add(new Music("Radiohead", R.drawable.musicimage));
        tempMusicList.add(new Music("Radiohead", R.drawable.musicimage));
        tempMusicList.add(new Music("Radiohead", R.drawable.musicimage));
        tempMusicList.add(new Music("Radiohead", R.drawable.musicimage));
        tempMusicList.add(new Music("Radiohead", R.drawable.musicimage));
        tempMusicList.add(new Music("Radiohead", R.drawable.musicimage));
        tempMusicList.add(new Music("Radiohead", R.drawable.musicimage));
        tempMusicList.add(new Music("Radiohead", R.drawable.musicimage));
        tempMusicList.add(new Music("Radiohead", R.drawable.musicimage));
        tempMusicList.add(new Music("Radiohead", R.drawable.musicimage));
        tempMusicList.add(new Music("Radiohead", R.drawable.musicimage));


        return tempMusicList;

    }

    public ArrayList<Music> getMusicList() {
        return this.musicList;
    }
}
