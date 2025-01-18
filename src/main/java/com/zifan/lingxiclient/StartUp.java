package com.zifan.lingxiclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.zifan.lingxiclient.view.MainView;

public class StartUp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // 加载登录界面
        Parent root = FXMLLoader.load(getClass().getResource("/com/zifan/lingxiclient/view/login.fxml"));
        primaryStage.setTitle("Lingxi Client");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

        // 登录成功后切换到主界面
        // 示例：假设登录成功
        MainView mainView = new MainView(primaryStage);
        mainView.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}