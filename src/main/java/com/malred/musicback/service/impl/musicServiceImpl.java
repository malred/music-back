package com.malred.musicback.service.impl;

import com.malred.musicback.entity.MuserLike;
import com.malred.musicback.entity.MusicInfo;
import com.malred.musicback.service.musicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author malguy-wang sir
 * @create ---
 */
@Service
public class musicServiceImpl implements musicService {
    @Autowired
    private com.malred.musicback.mappers.MusicDAO musicDao;

    @Override
    public boolean addMusicLikeById(String uid, MusicInfo musicInfo) {
        //插入之前先查询是否已经存在
        //concat是拼接字符串
        if (null != getUserLikeById(uid.concat(musicInfo.getMid()))) {
            return false;
        }
        if (null != uid && null != musicInfo) {
            //如果该歌曲信息已存在(music_info)
            if (null != musicDao.getLike(musicInfo.getMid())) {
                return musicDao.insertUserLike(uid, musicInfo);
            }
            //都为真才为真
            return (musicDao.insertUserLike(uid, musicInfo)
                    && musicDao.insertMusicInfo(musicInfo));
        }
        return false;
    }

    /**
     * 根据id查询userlike表
     */
    public String getUserLikeById(String id) {
        return musicDao.getUserLikeById(id);
    }

    /**
     * 根据uid获取muserLike
     *
     * @param uid
     * @return
     */
    @Override
    public List<MusicInfo> getLikesByUid(String uid) {
        System.out.println(uid);
        if (null == uid) return null;
        //根据uid查询userlike里的所有muserlike
        List<MuserLike> muserLikes = musicDao.getMuserLikesByUid(uid);
        //喜欢的歌曲列表
        List<MusicInfo> likes = new ArrayList<>();
        for (MuserLike muserLike : muserLikes) {
            if (null == muserLike) return null;
            MusicInfo musicInfo = musicDao.getLike(muserLike.getMid());
            //如果查询为空就return
            if (null == musicInfo) return null;
            likes.add(musicInfo);
        }
        return likes;
    }

    /**
     * 根据uid和mid删除我喜欢的歌曲
     *
     * @param uid
     * @param mid
     * @return
     */
    @Override
    public boolean delLike(String uid, String mid) {
        if (null != uid && null != mid) {
            return musicDao.deleteByUidAndMid(uid, mid);
        }
        return false;
    }
}
