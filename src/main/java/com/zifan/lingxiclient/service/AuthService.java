package com.zifan.lingxiclient.service;

import com.zifan.lingxiclient.model.User;
import com.zifan.lingxiclient.util.HttpUtil;
import com.zifan.lingxiclient.config.AppConfig;
import com.zifan.lingxiclient.exception.AuthException;

public class AuthService {
    private final String registerUrl;
    private final String loginUrl;

    public AuthService() {
        this.registerUrl = AppConfig.getProperty("server.baseUrl") + AppConfig.getProperty("server.auth.registerUrl");
        this.loginUrl = AppConfig.getProperty("server.baseUrl") + AppConfig.getProperty("server.auth.loginUrl");
    }

    public boolean register(User user) throws AuthException {
        try {
            HttpUtil.sendPostRequest(registerUrl, user, String.class);
            return true;
        } catch (Exception e) {
            throw new AuthException("Failed to register user: " + e.getMessage());
        }
    }

    public boolean login(User user) throws AuthException {
        try {
            HttpUtil.sendPostRequest(loginUrl, user, String.class);
            return true;
        } catch (Exception e) {
            throw new AuthException("Failed to login: " + e.getMessage());
        }
    }
}