package com.example.experiencechannel.model.entity;

import java.io.Serializable;


public class User implements Serializable {
    /**
     *用户头像资源Id
     */
    private int avatarResId;
    /**
     *用户账号
     */
    private String userAccount;
    /**
     *用户昵称
     */
    private String userNickName;
    /**
     *用户密码
     */
    private String userPassword;

    public User(int avatarResId, String userAccount, String userNickName, String userPassword) {
        this.avatarResId = avatarResId;
        this.userAccount = userAccount;
        this.userNickName = userNickName;
        this.userPassword = userPassword;
    }

    public int getAvatarResId() {
        return avatarResId;
    }

    public void setAvatarResId(int avatarResId) {
        this.avatarResId = avatarResId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
