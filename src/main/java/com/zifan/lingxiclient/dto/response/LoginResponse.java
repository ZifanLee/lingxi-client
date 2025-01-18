package com.zifan.lingxiclient.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoginResponse {
    private int status;
    private DataClass data;
    private String message;

    @Data
    public static class DataClass {
        private String token;
    }
}