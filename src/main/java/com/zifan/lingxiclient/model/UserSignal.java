package com.zifan.lingxiclient.model;

import com.zifan.lingxiclient.model.enumType.SignalType;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserSignal {
    private String userEmail; // 用户email
    private Map<String, List<Signal>> modules; // 模块划分的信号列表

    // 无参构造函数（用于 MongoDB 反序列化）
    public UserSignal() {
        this.modules = new HashMap<>();
    }

    // 带 userEmail 的构造函数
    public UserSignal(String userEmail) {
        this.userEmail = userEmail;
        this.modules = new HashMap<>();
    }

    @Data
    public static class Signal {
        private SignalType type; // 信号类型
        private String id; // 相关ID, 外建，用于指向具体记录id
        private LocalDateTime timestamp; // 时间戳
    }
}