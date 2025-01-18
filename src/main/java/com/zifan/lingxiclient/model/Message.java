package com.zifan.lingxiclient.model;

import lombok.Data;

import java.util.Date;

@Data
public class Message {

    private String id;
    private String senderId;
    private String receiverId;
    private String groupId;
    private String content;
    private String type; // text, image, file
    private String status; // sent, delivered, read
    private Date sentAt;
    private Date updatedAt; // 用于消息编辑时间

}
