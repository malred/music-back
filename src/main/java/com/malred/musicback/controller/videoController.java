package com.malred.musicback.controller;

import com.malred.musicback.service.userService;
import com.malred.musicback.service.videoService;
import com.malred.musicback.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author malguy-wang sir
 * @create ---
 */
@RestController
@RequestMapping("video")
@CrossOrigin //跨域配置
public class videoController {
    @Autowired
    com.malred.musicback.service.videoService videoService;
    @PostMapping("addVideo")
    public Map<String, Object> addVideo(String uid,String vTitle, MultipartFile file) {
        if (null == file) {
            return R.Fail("文件为空");
        }
        String url = videoService.addVideo(uid,vTitle, file);
//        logger.warn("日志" + url);
        if (null != url) {
            return R.OK("上传成功");
        }
        return R.Fail("上传失败");
    }
}
