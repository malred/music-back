package com.malred.musicback.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MuserInfo implements Serializable {
    private String id;
    private String name;
    private String location;
    private Long age;
    private String sex;
    private String birth;
    private Date createday;
    private String img;//Í·Ïñ
}
