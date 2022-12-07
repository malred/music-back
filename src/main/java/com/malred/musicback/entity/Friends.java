package com.malred.musicback.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Friends implements Serializable {
    private Long id;
    private String uid;
    private String fid;
    private String group;
}