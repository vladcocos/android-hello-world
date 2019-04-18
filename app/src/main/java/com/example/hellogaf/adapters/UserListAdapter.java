package com.example.hellogaf.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.hellogaf.R;
import com.example.hellogaf.models.UserModel;
import com.example.hellogaf.viewholders.UsersViewHolder;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter {
    private List<UserModel> userList;

    public UserListAdapter(List<UserModel> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.users_view_holder, parent, false);
        UsersViewHolder item = new UsersViewHolder(v);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ((UsersViewHolder) viewHolder).bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
