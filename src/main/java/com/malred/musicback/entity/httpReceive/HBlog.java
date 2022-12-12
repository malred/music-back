package com.malred.musicback.entity.httpReceive;

import com.malred.musicback.entity.Blogs;
import com.malred.musicback.entity.MuserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 原blog对象返回时带uid,但是渲染文章详情需要作者名字
 * 因此需要根据uid查询用户信息,并返回
 * 这个类是为了方便返回userinfo+bloginfo
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HBlog {
    // 文章信息
    private Blogs bloginfo;
    // 作者信息
    private MuserInfo authorinfo;
}
