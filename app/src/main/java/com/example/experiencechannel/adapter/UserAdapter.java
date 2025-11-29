package com.example.experiencechannel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.experiencechannel.R;
import com.example.experiencechannel.model.entity.User;
import com.example.experiencechannel.viewholder.UserViewHolder;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<User> mUserList;

    // 构造方法：接收数据集
    public UserAdapter(List<User> userList) {
        this.mUserList = userList;
    }
    /**
     * 加载Item布局
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return
     */
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        //创建返回的ViewHolder
        return new UserViewHolder(itemRootView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mUserList.get(position);
        holder.bindData(user);
    }

    @Override
    public int getItemCount() {
        return mUserList!=null?mUserList.size():0;
    }
    // 数据更新（后续刷新列表用）
    public void updateData(List<User> newUserList) {
        this.mUserList = newUserList;
        // 通知RecyclerView数据已变更
        notifyDataSetChanged();
    }
}
