package com.malred.musicback.service;

import com.malred.musicback.entity.MusicInfo;

import java.util.List;

/**
 * @author malguy-wang sir
 * @create ---
 */
public interface musicService {
    boolean addMusicLikeById(String uid, MusicInfo musicInfo);

    List<MusicInfo> getLikesByUid(String uid);

    boolean delLike(String uid, String mid);
}
