package com.zifan.lingxiclient.service;

import com.zifan.lingxiclient.dto.request.LoginRequest;
import com.zifan.lingxiclient.dto.response.LoginResponse;
import com.zifan.lingxiclient.model.User;
import com.zifan.lingxiclient.util.HttpUtil;
import com.zifan.lingxiclient.config.AppConfig;
import com.zifan.lingxiclient.exception.AuthException;

public class AuthService {
    private final String loginUrl;

    public AuthService() {
        this.loginUrl = AppConfig.getProperty("server.baseUrl") + AppConfig.getProperty("server.auth.loginUrl");
    }

    public LoginResponse login(LoginRequest loginRequest) throws AuthException {
        try {
            // 发送登录请求，返回 token
            return HttpUtil.sendPostRequest(loginUrl, loginRequest, LoginResponse.class);
        } catch (Exception e) {
            throw new AuthException("Failed to login: " + e.getMessage());
        }
    }

    public boolean register(User user) {
        return true;
    }
}