package com.malred.musicback.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author
 */
@Data
@ToString
public class Muser implements Serializable {
    private String id;
    private String uname;
    private String upass;
}