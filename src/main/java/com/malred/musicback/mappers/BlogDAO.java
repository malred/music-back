package com.malred.musicback.mappers;

import com.malred.musicback.entity.Blogs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author malguy-wang sir
 * @create ---
 */
@Mapper
public interface BlogDAO {
    /**
     * 添加文章
     *
     * @param blog
     * @return
     */
    boolean insertBlog(@Param("blog") Blogs blog);

    /**
     * 根据uid获取所有文章
     *
     * @param uid
     * @return
     */
    List<Blogs> getBlogsByUid(@Param("uid") String uid);

    /**
     * 根据bid获取文章信息
     * @param bid
     * @return
     */
    Blogs getBlogByBid(@Param("bid") String bid);

    /**
     * 更新文章
     * @param blog
     * @return
     */
    boolean updateBlog(@Param("blog") Blogs blog);

    /**
     * 删除文章
     * @param bid
     * @return
     */
    boolean delBlogById(@Param("bid") String bid);
}
