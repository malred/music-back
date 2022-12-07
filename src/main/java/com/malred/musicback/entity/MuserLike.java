package com.malred.musicback.entity;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MuserLike {
  // 由uid+mid拼接而成,如果重复就会保存
  private String id;
  private String uid;
  private String mid;
}
