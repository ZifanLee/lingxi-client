package com.zifan.lingxiclient.controller;

import com.zifan.lingxiclient.model.User;
import com.zifan.lingxiclient.service.AuthService;
import com.zifan.lingxiclient.util.ValidationUtil;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class LoginController {
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    private final AuthService authService = new AuthService();

    @FXML
    public void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (!ValidationUtil.isValidEmail(email) || !ValidationUtil.isValidPassword(password)) {
            errorLabel.setText("Invalid email or password");
            return;
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        try {
            if (authService.login(user)) {
                errorLabel.setText("Login successful");
                // 跳转到主界面
            } else {
                errorLabel.setText("Login failed");
            }
        } catch (Exception e) {
            errorLabel.setText(e.getMessage());
        }
    }

    @FXML
    public void handleRegister() {
        // 跳转到注册界面
    }
}