package com.humber.saynn.mycommunity.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.humber.saynn.mycommunity.R;
import com.humber.saynn.mycommunity.entities.Music;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalMusicAdapter extends RecyclerView.Adapter<HorizontalMusicAdapter.MusicViewHolder> {
    ArrayList<Music> musicList;
    LayoutInflater inflater;
    Context ctx;

    public HorizontalMusicAdapter(Context ctx, ArrayList<Music> musicList){
        this.musicList = musicList;
        inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public HorizontalMusicAdapter.MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.horizontal_music_item,parent,false);
        HorizontalMusicAdapter.MusicViewHolder holder = new HorizontalMusicAdapter.MusicViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalMusicAdapter.MusicViewHolder holder, int position) {

        holder.music = musicList.get(position);
        Music tempMusic = holder.music;
        holder.musicImage.setImageResource(tempMusic.getImageId());
        holder.singer.setText(tempMusic.getSinger());
        holder.musicCardView.setClickable(true);
        holder.musicCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, "NOW PLAYING", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder {

        CardView musicCardView;
        ImageView musicImage;
        TextView singer;
        Music music;


        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);

            musicImage = itemView.findViewById(R.id.musicImage);
            singer = itemView.findViewById(R.id.musicText);
            musicCardView = itemView.findViewById(R.id.musicCardView);

        }
    }
}
