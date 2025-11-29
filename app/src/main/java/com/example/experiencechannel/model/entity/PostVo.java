package com.example.experiencechannel.model.entity;

import java.io.Serializable;

public class PostVo implements Serializable {
    /**
     * 标题
     */
    private String title;
    /**
     * 点赞数
     */
    private Integer thumbNum;
//    /**
//     *用户头像资源Id
//     */
//    private int avatarResId;
//    /**
//     *帖子图像资源Id
//     */
//    private int imageResId;
    /**
     * // 用户头像网络地址
     */
    private String avatarUrl;
    /**
     *  //帖子图片网络地址
     */
    private String postImageUrl;
    /**
     *用户是否点赞
     */
    private boolean isLike;
    /**
     *用户昵称
     */
    private String userNickName;
//    public PostVo(int avatarResId,int imageResId, Integer thumbNum, String title,String userNickName,boolean isLike) {
//        this.avatarResId = avatarResId;
//        this.imageResId = imageResId;
//        this.thumbNum = thumbNum;
//        this.title = title;
//        this.userNickName = userNickName;
//        this.isLike=isLike;
//    }


    public PostVo(String avatarUrl, boolean isLike, String postImageUrl, Integer thumbNum, String title, String userNickName) {
        this.avatarUrl = avatarUrl;
        this.isLike = isLike;
        this.postImageUrl = postImageUrl;
        this.thumbNum = thumbNum;
        this.title = title;
        this.userNickName = userNickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getPostImageUrl() {
        return postImageUrl;
    }

    public void setPostImageUrl(String postImageUrl) {
        this.postImageUrl = postImageUrl;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }
//
//    public int getAvatarResId() {
//        return avatarResId;
//    }
//
//    public void setAvatarResId(int avatarResId) {
//        this.avatarResId = avatarResId;
//    }
//
//
//    public int getImageResId() {
//        return imageResId;
//    }
//
//    public void setImageResId(int imageResId) {
//        this.imageResId = imageResId;
//    }


    public Integer getThumbNum() {
        return thumbNum;
    }

    public void setThumbNum(Integer thumbNum) {
        this.thumbNum = thumbNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
