package com.example.experiencechannel.model.entity;

import java.io.Serializable;

public class VideoVo implements Serializable {
    /**
     * 视屏资源Id
     */
    private int videoResId;
    /**
     * 点赞数
     */
    private Integer thumbNum;
    /**
     * 收藏数
     */
    private Integer collectNum;
    /**
     * 收藏数
     */
    private Integer shareNum;

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    /**
     * 收藏数
     */
    private Integer commentNum;
    /**
     *用户头像资源Id
     */
    private int avatarResId;
    /**
     * 视频介绍
     */
    private String description;
    /**
     *用户昵称
     */
    private String userNickName;

    public VideoVo(int avatarResId, Integer collectNum, String description, Integer shareNum, Integer thumbNum, String userNickName, int videoResId,Integer commentNum) {
        this.avatarResId = avatarResId;
        this.collectNum = collectNum;
        this.description = description;
        this.shareNum = shareNum;
        this.thumbNum = thumbNum;
        this.userNickName = userNickName;
        this.videoResId = videoResId;
        this.commentNum=commentNum;
    }

    public int getAvatarResId() {
        return avatarResId;
    }

    public void setAvatarResId(int avatarResId) {
        this.avatarResId = avatarResId;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getShareNum() {
        return shareNum;
    }

    public void setShareNum(Integer shareNum) {
        this.shareNum = shareNum;
    }

    public Integer getThumbNum() {
        return thumbNum;
    }

    public void setThumbNum(Integer thumbNum) {
        this.thumbNum = thumbNum;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public int getVideoResId() {
        return videoResId;
    }

    public void setVideoResId(int videoResId) {
        this.videoResId = videoResId;
    }
}
