package com.example.experiencechannel.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.experiencechannel.R;
import com.example.experiencechannel.model.entity.PostVo;
import com.example.experiencechannel.model.entity.VideoVo;

/**
 * 描述视图绑定以及对获取到的数据进行绑定
 */
public class VideoVoViewHolder extends RecyclerView.ViewHolder{
    /**
     * 用户头像
     */
    ImageView ivAvatar;
    /**
     * 用户昵称
     */
    TextView tvName;
    /**
     * 视频或者图片
     */
    ImageView videoImage;
    /**
     * 视频描述
     */
    TextView textDescription;
    /**
     * 视频点赞图片
     */
    ImageView thumbImage;
    /**
     * 视频评论图片
     */
    ImageView commentImage;
    /**
     * 视频收藏图片
     */
    ImageView collectImage;
    /**
     * 视频分享图片
     */
    ImageView shareImage;
    /**
     * 视频点赞数量
     */
    TextView thumbNum;
    /**
     * 帖子收藏数量
     */
    TextView collectNum;
    /**
     * 帖子评论数量
     */
    TextView commentNum;
    /**
     * 视频分享数量
     */
    TextView shareNum;
    public VideoVoViewHolder(@NonNull View itemView) {
        super(itemView);
        // 绑定视图ID
        ivAvatar = itemView.findViewById(R.id.video_user_avatar);
        tvName = itemView.findViewById(R.id.video_author);
        videoImage= itemView.findViewById(R.id.video_player);
        thumbNum=itemView.findViewById(R.id.like_count);
        commentNum=itemView.findViewById(R.id.comment_count);
        collectNum=itemView.findViewById(R.id.collect_count);
        shareNum=itemView.findViewById(R.id.share_count);
        thumbImage=itemView.findViewById(R.id.like_button);
        commentImage=itemView.findViewById(R.id.comment_button);
        collectImage=itemView.findViewById(R.id.collect_button);
        thumbImage=itemView.findViewById(R.id.share_button);
        textDescription=itemView.findViewById(R.id.video_description);
    }
    //绑定数据导视图
    public void bindData(VideoVo videoVo){
        tvName.setText("@"+videoVo.getUserNickName());
        ivAvatar.setImageResource(videoVo.getAvatarResId());
        videoImage.setImageResource(videoVo.getVideoResId());
        thumbNum.setText(String.valueOf(videoVo.getThumbNum()));
        collectNum.setText(String.valueOf(videoVo.getCollectNum()));
        commentNum.setText(String.valueOf(videoVo.getCommentNum()));
        shareNum.setText(String.valueOf(videoVo.getShareNum()));
//        thumbImage.setImageResource(R.drawable.unthumb);
//        commentImage.setImageResource(R.drawable.unthumb);
//        collectImage.setImageResource(R.drawable.unthumb);
//        shareImage.setImageResource(R.drawable.unthumb);
        textDescription.setText(videoVo.getDescription());

    }

}
