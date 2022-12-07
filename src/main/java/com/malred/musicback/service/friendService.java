package com.malred.musicback.service;

import com.malred.musicback.entity.Friends;
import com.malred.musicback.entity.MuserInfo;

import java.util.List;
import java.util.Map;

/**
 * @author malguy-wang sir
 * @create ---
 */
public interface friendService {
    boolean addFriend(String uid,String fname,String fgroup);

    Friends friendsExist(String uid, String fid, String fgroup);

    List getGroupsByUid(String uid);

    Map<String, List<MuserInfo>> getFriendsByUid(String uid);

    MuserInfo getFriendByFid(String fid);

    boolean delFriend(String uid, String fid);
}
