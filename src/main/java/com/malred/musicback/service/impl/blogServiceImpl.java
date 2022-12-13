package com.malred.musicback.service.impl;

import com.malred.musicback.entity.Blogs;
import com.malred.musicback.entity.MuserInfo;
import com.malred.musicback.entity.httpReceive.HBlog;
import com.malred.musicback.mappers.BlogDAO;
import com.malred.musicback.mappers.MuserDAO;
import com.malred.musicback.service.blogService;
import com.malred.musicback.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author malguy-wang sir
 * @create ---
 */
@Service
public class blogServiceImpl implements blogService {
    @Autowired
    BlogDAO blogDAO;
    @Autowired
    MuserDAO muserDAO;

    /**
     * 上传文章封面
     *
     * @param file
     * @return
     */
    @Override
    public String uptCover(MultipartFile file) {
        if (null != file) {
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
            File newFile = new File("D:/blob/music_img/blog", uuidFilename);
            //将文件输出到目标的文件中
            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //获取当前的配置文件
            //返回上传到oss的路径
            String img = "http://localhost:9090/music/blog/" + uuidFilename;
            //等后面提交文章时再修改封面
//            boolean flag = blogDAO.updateCoverById(id, img);
//            if (flag) {
            return img;
//            }
        }
        return null;
    }

    /**
     * 新增文章
     *
     * @param blog
     * @return
     */
    @Override
    public boolean addBlog(Blogs blog) {
        return blogDAO.insertBlog(blog);
    }

    /**
     * 根据uid获取文章列表
     *
     * @param uid
     * @return
     */
    @Override
    public List<Blogs> getBlogs(String uid) {
        return blogDAO.getBlogsByUid(uid);
    }

    /**
     * 根据bid查询文章
     *
     * @param bid
     * @return
     */
    @Override
    public HBlog getBlogByBid(String bid) {
        // 获取文章信息
        Blogs blogs = blogDAO.getBlogByBid(bid);
        // 根据文章的作者id,获取作者信息
        MuserInfo muserInfo = muserDAO.getUserInfoById(blogs.getUid());
        HBlog hBlog = new HBlog(blogs, muserInfo);
        return hBlog;
    }

    /**
     * 更新文章
     *
     * @param blog
     * @return
     */
    @Override
    public boolean uptBlog(Blogs blog) {
        return blogDAO.updateBlog(blog);
    }

    /**
     * 删除文章
     *
     * @param bid
     * @return
     */
    @Override
    public boolean delBlog(String bid) {
        return blogDAO.delBlogById(bid);
    }
}
