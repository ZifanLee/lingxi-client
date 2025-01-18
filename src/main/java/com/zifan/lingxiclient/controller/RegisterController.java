package com.zifan.lingxiclient.controller;

import com.zifan.lingxiclient.model.User;
import com.zifan.lingxiclient.service.AuthService;
import com.zifan.lingxiclient.util.ValidationUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;

public class RegisterController {
    @FXML private TextField emailField;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    private final AuthService authService = new AuthService();

    @FXML
    public void handleRegister() {
        String email = emailField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (!ValidationUtil.isValidEmail(email) || !ValidationUtil.isValidPassword(password) || !ValidationUtil.isValidUsername(username)) {
            errorLabel.setText("Invalid input");
            return;
        }

        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);

        try {
            if (authService.register(user)) {
                errorLabel.setText("Registration successful");
                // 跳转到登录界面
            } else {
                errorLabel.setText("Registration failed");
            }
        } catch (Exception e) {
            errorLabel.setText(e.getMessage());
        }
    }

    @FXML
    public void handleLogin() {
        // 跳转到登录界面
    }
}