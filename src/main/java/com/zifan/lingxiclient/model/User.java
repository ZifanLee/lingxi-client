package com.zifan.lingxiclient.model;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class User {

    private Long id;
    private String username;
    private String email;

    private String passwordHash;

    private String firstName;

    private String lastName;

    private String phone;

    private Integer status = 1; // 默认启用

    private String role = "USER"; // 默认角色

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    private LocalDateTime lastLoginAt;

    private String avatarUrl;

    private String bio;

}