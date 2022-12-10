package com.malred.musicback.mappers;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author malguy-wang sir
 * @create ---
 */
@Mapper
public interface VideoDAO {
    /**
     * 根据uid添加视频(发布视频)
     * @param uid
     * @param video
     * @return
     */
    boolean addVideoByUid(String uid,String vTitle, String video);
}
