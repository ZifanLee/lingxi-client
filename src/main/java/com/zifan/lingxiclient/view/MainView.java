package com.zifan.lingxiclient.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.zifan.lingxiclient.service.WebSocketService;

public class MainView {
    private Stage primaryStage;
    private WebSocketService webSocketService;

    public MainView(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.webSocketService = new WebSocketService();
    }

    // 加载主界面
    public void show() {
        try {
            // 加载主界面的 FXML 文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/zifan/lingxiclient/view/main.fxml"));
            Parent root = loader.load();

            // 设置主界面场景
            Scene scene = new Scene(root, 1000, 800);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Lingxi Client - Main");
            primaryStage.show();

            // 初始化 WebSocket 连接
            webSocketService.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}