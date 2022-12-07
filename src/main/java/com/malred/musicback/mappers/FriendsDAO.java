package com.malred.musicback.mappers;

import com.malred.musicback.entity.Friends;
import com.malred.musicback.entity.MuserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FriendsDAO {
    /**
     * 添加好友
     *
     * @param uid
     * @param fid
     * @param fgroup
     * @return
     */
    boolean addFriend(
            @Param("uid") String uid,
            @Param("fid") String fid,
            @Param("fgroup") String fgroup);

    /**
     * 查询friend
     *
     * @param uid
     * @param fid
     * @param fgroup
     * @return
     */
    Friends getByUidAndFidAndGroup(
            @Param("uid") String uid,
            @Param("fid") String fid,
            @Param("fgroup") String fgroup);

    /**
     * 根据uid获取分组信息
     *
     * @param uid
     * @return
     */
    List<String> getGroupsByUid(@Param("uid") String uid);

    /**
     * @return
     */
    List<String> getFidByGroupAndUid(
            @Param("fgroup") String fgroup,
            @Param("uid") String uid);

    /**
     * 通过fid获取friend
     *
     * @param fid
     * @return
     */
    MuserInfo getFriendByFid(@Param("fid") String fid);

    /**
     * 根据uid,fid删除好友
     *
     * @param uid
     * @param fid
     * @return
     */
    boolean delFriendByUidAndFid(
            @Param("uid") String uid,
            @Param("fid") String fid);

    /**
     * 根据uid和fid获取好友
     *
     * @return
     */
    String getByUidAndFid(
            @Param("uid") String uid,
            @Param("fid") String fid
    );

    /**
     * 根据uid和fid更新分组
     * @param uid
     * @param fid
     * @param fgroup
     * @return
     */
    boolean updataGroupByUidAndFid(
            @Param("uid") String uid,
            @Param("fid") String fid,
            @Param("fgroup") String fgroup);
}