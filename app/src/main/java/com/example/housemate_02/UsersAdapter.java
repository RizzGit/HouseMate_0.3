package com.example.housemate_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.housemate_02.ui.main.MainViewModel;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    private Context context;
    private List<User> usrList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title,usrLink;
        public ImageView thumbnail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //init the views
            title = itemView.findViewById(R.id.title);
            usrLink = itemView.findViewById(R.id.count);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

    public UsersAdapter(Context context, List<User> usrList) {
        this.context = context;
        this.usrList = usrList;
    }

    //Methods of Adapter
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_scrolling_test,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = usrList.get(position);

        holder.title.setText(user.getNome());
        holder.usrLink.setText(user.getEmail());

        //Extra Code?? min 43 https://www.youtube.com/watch?v=SGjIEcErSE0

    }

    @Override
    public int getItemCount() {
        return usrList.size();
    }

}
