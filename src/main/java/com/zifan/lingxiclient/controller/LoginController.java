package com.zifan.lingxiclient.controller;

import com.zifan.lingxiclient.dto.request.LoginRequest;
import com.zifan.lingxiclient.dto.response.LoginResponse;
import com.zifan.lingxiclient.service.AuthService;
import com.zifan.lingxiclient.service.WebSocketService;
import com.zifan.lingxiclient.view.MainView;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.http.HttpResponse;

public class LoginController {
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    private final AuthService authService = new AuthService();
    private final WebSocketService webSocketService = new WebSocketService();

    @FXML
    public void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email);
        loginRequest.setPassword(password);

        try {
            // 发送登录请求，获取 token
            LoginResponse loginResponse = authService.login(loginRequest);
            if (loginResponse.getStatus() == 200) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("登录成功");
                alert.setHeaderText(null); // 不显示标题栏
                alert.setContentText("登录成功！");

                // 显示弹窗
                alert.showAndWait();
            }
            String token = loginResponse.getData().getToken();
            if (token != null) {
                // 使用 token 建立 WebSocket 连接
                webSocketService.connect(token);

                // 跳转到主页面，并传递 token
                Stage stage = (Stage) emailField.getScene().getWindow();
                MainView mainView = new MainView(stage, token);
                mainView.show();
            } else {
                errorLabel.setText("Login failed: Invalid credentials");
            }
        } catch (Exception e) {
            errorLabel.setText("Login failed: " + e.getMessage());
        }
    }

    @FXML
    public void handleRegister() {
        // 跳转到注册界面
    }
}