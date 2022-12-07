package com.malred.musicback.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MusicInfo {
  private String mid;
  private String mname;
  private String picUrl;
  private String arname;
}
