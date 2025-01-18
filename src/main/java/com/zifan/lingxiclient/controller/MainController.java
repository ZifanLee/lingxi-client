package com.zifan.lingxiclient.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.zifan.lingxiclient.service.WebSocketService;

public class MainController {
    @FXML private ListView<String> friendList;
    @FXML private TextArea chatArea;
    @FXML private TextField messageField;

    private WebSocketService webSocketService;

    public void initialize() {
        // 初始化好友列表
        friendList.getItems().addAll("Friend 1", "Friend 2", "Friend 3");

        // 初始化 WebSocket 服务
        webSocketService = new WebSocketService();
        webSocketService.connect();
    }

    @FXML
    public void handleSendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            chatArea.appendText("You: " + message + "\n");
            messageField.clear();

            // 通过 WebSocket 发送消息
            webSocketService.sendMessage(message);
        }
    }
}