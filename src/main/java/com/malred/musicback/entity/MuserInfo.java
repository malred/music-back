package com.malred.musicback.entity;

import lombok.Data;

import java.sql.Blob;
import java.util.Date;

@Data
public class MuserInfo {
    private String id;
    private String name;
    private String location;
    private Long age;
    private Date birth;
    private Date createday;
    private String img;//Í·Ïñ
}
