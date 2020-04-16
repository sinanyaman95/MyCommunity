package com.humber.saynn.mycommunity.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.humber.saynn.mycommunity.R;
import com.humber.saynn.mycommunity.activities.AddRestaurant;
import com.humber.saynn.mycommunity.activities.MainActivity;
import com.humber.saynn.mycommunity.activities.UserNewComment;
import com.humber.saynn.mycommunity.entities.User;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class VerticalUserCommentAdapter extends RecyclerView.Adapter<VerticalUserCommentAdapter.UserViewHolder>{

    private static final int VIEW_TYPE_FOOTER = 99;
    private static final int VIEW_TYPE_CELL = 1;

    LayoutInflater linflater;
    ArrayList<User> userList;
    Context ctx;
    String foodName;

    public VerticalUserCommentAdapter(Context ctx, ArrayList<User> userList, String foodName){
        linflater = LayoutInflater.from(ctx);
        this.userList = userList;
        this.ctx = ctx;
        this.foodName = foodName;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = null;
        if(viewType == VIEW_TYPE_CELL){
            v = linflater.inflate(R.layout.user_comment_item,parent,false);
        }else if(viewType == VIEW_TYPE_FOOTER){
            v = linflater.inflate(R.layout.new_comment_button,parent,false);
        }

        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        if(position != userList.size()){
            holder.u = userList.get(position);
            User tempUser = holder.u;

            holder.username.setText(tempUser.getUsername());
            holder.comment.setText(tempUser.getComment());
        }else{
            holder.newCommentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"Please be kind in your review",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(ctx, UserNewComment.class);
                    i.putExtra("foodName",foodName);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
                    ctx.startActivity(i);
                }
            });
        }


    }

    @Override
    public int getItemViewType(int position) {
        return (position == userList.size()) ? VIEW_TYPE_FOOTER : VIEW_TYPE_CELL;
    }

    @Override
    public int getItemCount() {
        return userList.size()+1;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        TextView username;
        TextView comment;
        User u;
        CardView cv;
        LinearLayout newCommentLayout;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.nameUser);
            comment = itemView.findViewById(R.id.commentUser);
            cv = itemView.findViewById(R.id.userCommentCardView);
            newCommentLayout = itemView.findViewById(R.id.addComment);
        }
    }
}
