package com.zifan.lingxiclient.controller;

import com.zifan.lingxiclient.model.User;
import com.zifan.lingxiclient.service.AuthService;
import com.zifan.lingxiclient.util.ValidationUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {
    public Hyperlink loginButton;
    public Button register;
    public PasswordField confirmPasswordField;
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
        switchToLogin();
    }

    private void switchToLogin() {
        try {
            // 加载登录界面的FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/zifan/lingxiclient/view/login.fxml"));
            Parent root = loader.load();

            // 获取当前的Stage
            Stage stage = (Stage) loginButton.getScene().getWindow();

            // 创建新的Scene并设置到Stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}