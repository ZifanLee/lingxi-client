package com.zifan.lingxiclient.service;

import com.zifan.lingxiclient.config.AppConfig;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class WebSocketService {
    private WebSocketClient webSocketClient;

    public void connect(String token) {
        // 将 token 附加到 WebSocket URL
        String websocketUrl = AppConfig.getProperty("websocket.url") + "?token=" + token;
        webSocketClient = new WebSocketClient(URI.create(websocketUrl)) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                System.out.println("WebSocket connected");
            }

            @Override
            public void onMessage(String message) {
                System.out.println("Received message: " + message);
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                System.out.println("WebSocket closed");
            }

            @Override
            public void onError(Exception ex) {
                ex.printStackTrace();
            }
        };
        webSocketClient.connect();
    }

    public void sendMessage(String message) {
        if (webSocketClient != null && webSocketClient.isOpen()) {
            webSocketClient.send(message);
        }
    }
}