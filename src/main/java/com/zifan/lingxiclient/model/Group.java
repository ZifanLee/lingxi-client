package com.zifan.lingxiclient.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Group {

    private String id;
    private String name;
    private String creatorId;
    private List<String> members;
    private String type;
    private Date createdAt;
    private Date updatedAt;

}