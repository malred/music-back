package com.malred.musicback.controller;

import com.malred.musicback.entity.MusicInfo;
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
@RequestMapping("music")
@CrossOrigin //跨域配置
public class musicController {
    @Autowired
    com.malred.musicback.service.userService userService;
    @Autowired
    com.malred.musicback.service.musicService musicService;

    /**
     * 添加到我喜欢
     *
     * @return
     */
    @PostMapping("addLike")
    public Map<String, Object> addLike(
            String uid, MusicInfo musicInfo
    ) {
//        MusicInfo musicInfo = new MusicInfo(mid,mname,picUrl,arname);
//        System.out.println(musicInfo);
//        System.out.println(uid);
        if (musicService.addMusicLikeById(uid, musicInfo)) {
            return R.OK("添加成功");
        }
        return R.Fail("请不要重复添加");
    }

    /**
     * 根据uid(账号)查询喜欢的歌曲
     *
     * @param uid
     * @return
     */
    @GetMapping("getLikes")
    public Map<String, Object> getLikes(String uid) {
        List likes = musicService.getLikesByUid(uid);
        if (null != likes) {
            return R.OK(likes);
        }
        return R.Fail("获取歌曲列表失败");
    }

    /**
     * 根据uid和mid删除我喜欢的音乐
     *
     * @param uid
     * @param mid
     * @return
     */
    @DeleteMapping("delLike")
    public Map<String, Object> getLikes(
            @RequestParam("uid") String uid,
            @RequestParam("mid") String mid) {
        System.out.println(uid);
        System.out.println(mid);
        if (musicService.delLike(uid, mid)) {
            return R.OK("移除成功");
        }
        return R.Fail("移除失败");
    }
}
