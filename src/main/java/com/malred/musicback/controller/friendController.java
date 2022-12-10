package com.malred.musicback.controller;

import com.malred.musicback.entity.MuserInfo;
import com.malred.musicback.entity.httpReceive.HFriend;
import com.malred.musicback.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author malguy-wang sir
 * @create ---
 */
@RestController
@RequestMapping("friend")
@CrossOrigin //跨域配置
public class friendController {

    @Autowired
    com.malred.musicback.service.friendService friendService;

    /**
     * 根据uname添加好友
     *
     * @param hFriend
     * @return
     */
    @PostMapping(value = "addFriend", produces = "application/json;charset=UTF-8")
    public Map<String, Object> addFriend(@RequestBody HFriend hFriend
//            String uid, String fname, String fgroup
    ) {
        if (friendService.addFriend(
                hFriend.getUid(),
                hFriend.getFname(),
                hFriend.getFgroup())) {
            return R.OK("添加成功");
        }
        return R.Fail("查无此人或重复添加");
    }

    @GetMapping("getFriends")
    public Map<String, Object> getFriends(String uid) {
        Map<String, List<MuserInfo>> friends = friendService.getFriendsByUid(uid);
        if (null != friends) {
            return R.OK(friends);
        }
        return R.Fail("无法获取好友列表");
    }

    @GetMapping("getFriendByFid")
    public Map<String, Object> getFriendByFid(String fid) {
        MuserInfo friend = friendService.getFriendByFid(fid);
        if (null != friend) {
            return R.OK(friend);
        }
        return R.Fail("无法获取好友列表");
    }

    @DeleteMapping("delFriend")
    public Map<String, Object> delFriend(String uid, String fid) {
        if (friendService.delFriend(uid, fid)) {
            return R.OK("删除成功");
        }
        return R.Fail("删除失败");
    }
}
