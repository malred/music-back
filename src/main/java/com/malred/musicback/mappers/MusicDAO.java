package com.malred.musicback.mappers;

import com.malred.musicback.entity.MuserLike;
import com.malred.musicback.entity.MusicInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author malguy-wang sir
 * @create ---
 */
@Mapper
public interface MusicDAO {
    /**
     * 插入新数据到userlike
     *
     * @param uid
     * @param musicInfo
     * @return
     */
    boolean insertUserLike(@Param("uid") String uid,
                           @Param("musicInfo") MusicInfo musicInfo);

    /**
     * 添加到musicinfo表(因为本地没有music数据(在网易云api),所有用表存)
     *
     * @param musicInfo
     * @return
     */
    boolean insertMusicInfo(@Param("musicInfo") MusicInfo musicInfo);

    /**
     * 根据id获取userlike
     *
     * @param id
     * @return
     */
    String getUserLikeById(@Param("id") String id);

    List<MuserLike> getMuserLikesByUid(@Param("uid") String uid);

    /**
     * 根据mid获取歌曲信息
     *
     * @param mid
     * @return
     */
    MusicInfo getLike(@Param("mid") String mid);

    /**
     * 根据uid和mid删除我喜欢的歌曲
     *
     * @param uid
     * @param mid
     * @return
     */
    boolean deleteByUidAndMid(
            @Param("uid") String uid,
            @Param("mid") String mid);
}
