package com.example.experiencechannel.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.experiencechannel.R;
import com.example.experiencechannel.adapter.PostVoAdapter;
import com.example.experiencechannel.constant.resourceConstant;
import com.example.experiencechannel.model.entity.PostVo;
import com.example.experiencechannel.model.entity.User;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 描述视图绑定以及数据绑定
 */
public class PostVoViewHolder extends RecyclerView.ViewHolder{
    /**
     * 用户头像
     */
    ImageView ivAvatar;
    /**
     * 用户昵称
     */
    TextView tvName;
    /**
     * 帖子图片
     */
    ImageView postImage;
    /**
     * 帖子标题
     */
    TextView textTitle;
    /**
     * 帖子点赞图片
     */
    ImageView thumbImage;
    /**
     * 帖子点赞数量
     */
    TextView thumbNum;
    public PostVoViewHolder(@NonNull View itemView) {
        super(itemView);
        // 绑定视图ID
        ivAvatar = itemView.findViewById(R.id.user_avatar);
        tvName = itemView.findViewById(R.id.user_name);
        postImage= itemView.findViewById(R.id.cardImage);
        thumbNum=itemView.findViewById(R.id.thumb_num);
        thumbImage=itemView.findViewById(R.id.user_thumb);
        textTitle=itemView.findViewById(R.id.post_content);

       }
    public void bindData(PostVo postVo){
        tvName.setText(postVo.getUserNickName());
//        ivAvatar.setImageResource(postVo.getAvatarUrl());
        // 使用 Glide 加载用户头像
        Glide.with(itemView.getContext())
                .load(postVo.getAvatarUrl())
                .placeholder(R.drawable.logo)
                .error(R.drawable.logotext)
                .circleCrop()
                .into(ivAvatar);

        // 使用 Glide 加载帖子主图
        Glide.with(itemView.getContext())
                .load(postVo.getPostImageUrl())
                .placeholder(R.drawable.logo)
                .error(R.drawable.logotext)
                .fitCenter()
                .into(postImage);
        // 只为点赞按钮设置点击监听器
//        postImage.setImageResource(postVo.getImageResId());
        thumbNum.setText(String.valueOf(postVo.getThumbNum()));
        if (postVo.isLike()){
            thumbImage.setImageResource(R.drawable.thumb);
        }else {
            thumbImage.setImageResource(R.drawable.unthumb);
        }
        textTitle.setText(postVo.getTitle());
    }

}
