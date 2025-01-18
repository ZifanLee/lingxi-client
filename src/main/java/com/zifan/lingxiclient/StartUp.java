package com.zifan.lingxiclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // 加载登录界面
        Parent root = FXMLLoader.load(getClass().getResource("/com/zifan/lingxiclient/view/login.fxml"));
        primaryStage.setTitle("Lingxi Client - Login");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}