package com.malred.musicback.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author
 */
@Data
public class Muser implements Serializable {
    private String id;
    private String uname;
    private String upass;
}