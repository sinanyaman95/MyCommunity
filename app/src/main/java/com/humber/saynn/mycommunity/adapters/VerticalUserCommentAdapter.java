package com.humber.saynn.mycommunity.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.humber.saynn.mycommunity.R;
import com.humber.saynn.mycommunity.activities.MainActivity;
import com.humber.saynn.mycommunity.entities.User;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class VerticalUserCommentAdapter extends RecyclerView.Adapter<VerticalUserCommentAdapter.UserViewHolder>{

    LayoutInflater linflater;
    ArrayList<User> userList;

    public VerticalUserCommentAdapter(Context ctx, ArrayList<User> userList){
        linflater = LayoutInflater.from(ctx);
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = linflater.inflate(R.layout.user_comment_item,parent,false);

        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.u = userList.get(position);
        User tempUser = holder.u;

        holder.username.setText(tempUser.getUsername());
        holder.comment.setText(tempUser.getComment());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        TextView username;
        TextView comment;
        User u;
        CardView cv;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.nameUser);
            comment = itemView.findViewById(R.id.commentUser);
            cv = itemView.findViewById(R.id.userCommentCardView);
        }
    }
}
