package com.malred.musicback.controller;

import com.malred.musicback.entity.Blogs;
import com.malred.musicback.entity.httpReceive.HBlog;
import com.malred.musicback.service.blogService;
import com.malred.musicback.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author malguy-wang sir
 * @create ---
 */
@RestController //这个注解让响应返回是string而不是java对象
@RequestMapping("blog")
@CrossOrigin //跨域配置
public class blogController {
    @Autowired
    blogService blogService;

    /**
     * 上传封面
     *
     * @param file
     * @return
     */
    @PostMapping("updCover")
    public Map<String, Object> updCover(MultipartFile file) {
        if (null == file) {
            return R.Fail("文件为空");
        }
        String url = blogService.uptCover(file);
        if (null != url) {
            return R.OK(url);
        }
        return R.Fail("上传封面失败");
    }

    /**
     * 添加文章
     * @param blog
     * @return
     */
    @PostMapping("addBlog")
    public Map<String, Object> addBlog(@RequestBody Blogs blog) {
        if (null == blog) {
            return R.Fail("上传内容为空");
        }
        if(blogService.addBlog(blog)) {
            return R.OK("发布成功");
        }
        return R.Fail("发布失败");
    }

    /**
     * 修改文章
     * @param blog
     * @return
     */
    @PostMapping("uptBlog")
    public Map<String, Object> uptBlog(@RequestBody Blogs blog) {
        if (null == blog) {
            return R.Fail("上传内容为空");
        }
//        System.out.println(blog);
        if(blogService.uptBlog(blog)){
            return R.OK("修改成功");
        }
        return R.Fail("修改失败");
    }

    /**
     * 获取个人的所有文章
     *
     * @param uid
     * @return
     */
    @GetMapping("getUserBlogs")
    public Map<String, Object> getBlog(String uid) {
        if (null == uid) return R.Fail("用户id为空");
        List<Blogs> blogs = blogService.getBlogs(uid);
        if (null != blogs) {
            return R.OK(blogs);
        }
        return R.Fail("获取失败");
    }

    /**
     * 根据bid获取文章信息
     *
     * @param bid
     * @return
     */
    @GetMapping("getBlogByBid")
    public Map<String, Object> getBlogByBid(String bid) {
        if (null == bid) return R.Fail("bid为空");
        HBlog res = blogService.getBlogByBid(bid);
        if (null != res) {
            return R.OK(res);
        }
        return R.Fail("查询文章失败");
    }
}
