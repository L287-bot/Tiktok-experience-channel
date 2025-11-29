package com.example.experiencechannel.model.entity;

import lombok.Data;

@Data
public class Post {
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布用户id
     */
    private Long   publishUserId;
    /**
     * 点赞数
     */
    private Integer thumbNum;

}
