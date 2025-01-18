package com.zifan.lingxiclient.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatController {
    @FXML private ListView<String> friendList;
    @FXML private TextArea chatArea;
    @FXML private TextField messageField;

    @FXML
    private void handleSendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            chatArea.appendText("You: " + message + "\n");
            messageField.clear();

            // TODO: 实现发送消息逻辑
            System.out.println("Send: " + message);
        }
    }
}