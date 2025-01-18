package com.zifan.lingxiclient.model;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Friendship {

    private Long id;
    private String friendEmail; // 好友邮箱
    private FriendshipStatus status = FriendshipStatus.PENDING; // 状态
    private LocalDateTime createdAt = LocalDateTime.now(); // 创建时间
    private LocalDateTime updatedAt = LocalDateTime.now(); // 更新时间

    public enum FriendshipStatus {
        PENDING, ACCEPTED, REJECTED, BLOCKED
    }
}