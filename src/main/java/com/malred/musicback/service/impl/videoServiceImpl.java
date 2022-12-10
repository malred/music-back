package com.malred.musicback.service.impl;

import com.malred.musicback.mappers.VideoDAO;
import com.malred.musicback.service.videoService;
import com.malred.musicback.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author malguy-wang sir
 * @create ---
 */
@Service
public class videoServiceImpl implements videoService {
    @Autowired
    VideoDAO videoDAO;
    // 上传文件,保存本地
    @Override
    public String addVideo(String uid,String vTitle,MultipartFile file) {
        if (null != file && null != uid) {
            //获取上传文件  MultipartFile
            //获取文件的内容
            try {
                InputStream is = file.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //获取原始文件名
            String originalFilename = file.getOriginalFilename();
            //生成一个uuid名称出来
            String uuidFilename = UploadUtils.getUUIDName(originalFilename);
            //创建新文件,名称是uuidFilename,放在D:/blob/music_img下
            File newFile = new File("D:/blob/music_img", uuidFilename);
            //将文件输出到目标的文件中
            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //获取当前的配置文件
            //返回上传到oss的路径
            String video = "http://localhost:9090/music/img/" + uuidFilename;
            boolean flag = videoDAO.addVideoByUid(uid,vTitle, video);
            if (flag) {
                return video;
            }
        }
        return null;
    }
}
