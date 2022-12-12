package com.malred.musicback.entity;


import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Blogs {
    private Long id;
    private String uid;
    private String content;
    private Date createday;
    private String title;
    private String cover;
}
