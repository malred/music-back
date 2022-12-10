package com.malred.musicback.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author malguy-wang sir
 * @create ---
 */
public interface videoService {

    // 上传文件,保存本地
    String addVideo(String id,String vTitle, MultipartFile file);
}
