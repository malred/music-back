package com.malred.musicback.service;

import com.malred.musicback.entity.Blogs;
import com.malred.musicback.entity.httpReceive.HBlog;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author malguy-wang sir
 * @create ---
 */
public interface blogService {
    String uptCover( MultipartFile file);

    boolean addBlog(Blogs blog);

    List<Blogs> getBlogs(String uid);

    HBlog getBlogByBid(String bid);

    boolean uptBlog(Blogs blog);
}
