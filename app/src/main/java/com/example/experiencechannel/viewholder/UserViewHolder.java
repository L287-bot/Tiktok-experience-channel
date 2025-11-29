package com.example.experiencechannel.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.experiencechannel.R;
import com.example.experiencechannel.model.entity.User;

public class UserViewHolder extends RecyclerView.ViewHolder{

    ImageView ivAvatar;
    TextView tvName;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        // 绑定视图ID
        ivAvatar = itemView.findViewById(R.id.user_avatar);
        tvName = itemView.findViewById(R.id.user_name);
    }
    //绑定数据导视图
    public void bindData(User user){
        tvName.setText(user.getUserNickName());
        ivAvatar.setImageResource(user.getAvatarResId());
    }

}
