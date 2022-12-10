package com.malred.musicback.entity;


import com.malred.musicback.entity.httpReceive.HMusicInfo;
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

    // 将前端传来的对象进行转化
    public MusicInfo(HMusicInfo hMusicInfo) {
        this.mid = hMusicInfo.getMid();
        this.mname = hMusicInfo.getMname();
        this.picUrl = hMusicInfo.getPicUrl();
        this.arname = hMusicInfo.getArname();
    }
}
