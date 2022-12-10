package com.malred.musicback.service.impl;

import com.malred.musicback.entity.Friends;
import com.malred.musicback.entity.Muser;
import com.malred.musicback.entity.MuserInfo;
import com.malred.musicback.mappers.FriendsDAO;
import com.malred.musicback.mappers.MuserDAO;
import com.malred.musicback.service.friendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author malguy-wang sir
 * @create ---
 */
@Service
public class friendServiceImpl implements friendService {
    @Autowired
    MuserDAO muserDAO;
    @Autowired
    FriendsDAO friendsDAO;

    @Override
    public boolean addFriend(String uid, String fname, String fgroup) {
        //通过fname获取id
        Muser muser = muserDAO.getUserByName(fname);
        String fid = muser.getId();
        //如果已存在该好友,但是分组不同,就改分组
        if (friendsDAO.getByUidAndFid(uid, fid) != fgroup &&
                //一条都没有的时候返回为null也会满足前面的判断
                null != friendsDAO.getByUidAndFid(uid, fid)) {
            System.out.println("改分组");
            return friendsDAO.updataGroupByUidAndFid(uid, fid, fgroup);
        }
        //如果已存在,分组也相同
        if (null != friendsExist(uid, fid, fgroup)) return false;
        if (null != muser) {
            return friendsDAO.addFriend(uid, fid, fgroup)
                    //对方也要添加这个好友
                    && (null != friendsExist(fid, uid, fgroup)) ?
                    //但是好像走不到这步,直接return应该也行
                    //对方如果有这个好友但是分组不同就改分组
                    friendsDAO.updataGroupByUidAndFid(fid, uid, fgroup) :
                    //对方没有这个好友就添加到默认分组
                    friendsDAO.addFriend(fid, uid, "默认");
        }
        //根据uid获取
        return false;
    }

    @Override
    public Friends friendsExist(String uid, String fid, String fgroup) {
        return friendsDAO.getByUidAndFidAndGroup(uid, fid, fgroup);
    }

    @Override
    public List<String> getGroupsByUid(String uid) {
        return friendsDAO.getGroupsByUid(uid);
    }

    @Override
    public Map<String, List<MuserInfo>> getFriendsByUid(String uid) {
        Map<String, List<MuserInfo>> map = new HashMap<>();
        //先查询该uid的所有分组
        List<String> groups = getGroupsByUid(uid);
        //要返回的friends数据
        if (null != groups) {
            //遍历获取不同分组的friend
            for (String group : groups) {
                //获取该分组下所有fid
                List<String> fids =
                        friendsDAO.getFidByGroupAndUid(group, uid);
                if (null != fids) {
                    //分组下所有朋友的info
                    List<MuserInfo> muserInfos = new ArrayList<>();
                    for (String fid : fids) {
                        //获取好友详情
                        MuserInfo finfo = muserDAO.getUserInfoById(fid);
                        //放入朋友信息的list
                        if (null != finfo) muserInfos.add(finfo);
                        System.out.println(finfo);
                    }
                    System.out.println(group);
                    System.out.println(muserInfos);
                    //最后组别为key,朋友list为value,放入map
                    map.put(group, muserInfos);
                }
            }
            return map;
        }
        return null;
    }

    @Override
    public MuserInfo getFriendByFid(String fid) {
        MuserInfo f = friendsDAO.getFriendByFid(fid);
        if (null != f) {
            return f;
        }
        return null;
    }

    @Override
    public boolean delFriend(String uid, String fid) {
        if (null != uid && null != fid) {
            //双方都要删除
            return friendsDAO.delFriendByUidAndFid(uid, fid)
                    && friendsDAO.delFriendByUidAndFid(fid, uid);
        }
        return false;
    }
}
