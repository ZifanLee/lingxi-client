package com.zifan.lingxiclient.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private ListView<String> friendList;

    @FXML
    private TextArea chatArea;

    @FXML
    private TextField messageField;

    @FXML
    private ImageView friendAvatar;

    @FXML
    private Label friendName;

    @FXML
    private void handleSendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            chatArea.appendText("You: " + message + "\n");
            messageField.clear();
        }
    }

    @FXML
    private void handleAddFriend() {
        // 处理添加好友逻辑
    }

    @FXML
    private void handleRemoveFriend() {
        // 处理移除好友逻辑
    }

    @FXML
    private void handleProfile() {
        // 处理个人资料逻辑
    }

    @FXML
    private void handlePreferences() {
        // 处理偏好设置逻辑
    }
}