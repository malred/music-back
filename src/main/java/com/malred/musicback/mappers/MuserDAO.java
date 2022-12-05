package com.malred.musicback.mappers;

import com.malred.musicback.entity.Muser;
import com.malred.musicback.entity.MuserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

/**
 * MuserDAO继承基类
 */
@Mapper
public interface MuserDAO {
    /**
     * 登录--根据用户名和密码查询
     *
     * @param uname 用户名
     * @param upass 密码
     * @return
     */
    Muser getUserByNameAndPass(
            @Param("uname") String uname,
            @Param("upass") String upass);

    /**
     * 添加muser(账号密码表)
     *
     * @param id
     * @param uname
     * @param upass
     * @return
     */
    boolean addUser(
            @Param("id") String id,
            @Param("uname") String uname,
            @Param("upass") String upass);

    /**
     * 添加用户信息
     *
     * @param id
     * @return
     */
    boolean addUserInfo(@Param("id") String id);

    /**
     * 根据账号查询muser(账号密码表)
     *
     * @param uname 账号
     * @return
     */
    Muser getUserByName(@Param("uname") String uname);

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    MuserInfo getUserInfoById(@Param("id") String id);

    /**
     * 根据uname更新密码
     *
     * @param uname
     * @param upass
     * @return
     */
    boolean updatePassByName(
            @Param("uname") String uname,
            @Param("upass") String upass);

    /**
     * 根据uname修改头像
     * @param id
     * @param url
     * @return
     */
    boolean updateImgById(
            @Param("id") String id,
            @Param("url") String url);
}