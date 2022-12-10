package com.malred.musicback.entity.httpReceive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 因为前端要传递uid进行一些操作,所以需要一个对象来接收
 * 如果是@requestParam uid,@requestBody MusicInfo 则只能接收到musicinfo
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HMusicInfo {
    private String uid;
    private String mid;
    private String mname;
    private String picUrl;
    private String arname;
}
