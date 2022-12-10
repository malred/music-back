package com.malred.musicback.controller;

import com.malred.musicback.entity.Muser;
import com.malred.musicback.entity.MuserInfo;
import com.malred.musicback.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("user")
@CrossOrigin //跨域配置
public class userController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    com.malred.musicback.service.userService userService;

    /**
     * 登录
     *
     * @param uname
     * @param upass
     * @return
     */
    @PostMapping("/login")
    public Map<String, Object> login(String uname, String upass) {
        if (null != userService.login(uname, upass)) {
            return R.OK("登录成功");
        }
        return R.Fail("用户名或密码错误");
    }

    /**
     * 注册
     *
     * @param id
     * @param uname
     * @param upass
     * @return
     */
    @PostMapping("/register")
    public Map<String, Object> register(String id, String uname, String upass) {
        //账号必须唯一
        if (userService.unameExist(uname)) {
            return R.Fail("账号已存在");
        }
        //id要唯一(如果已存在,就做一些处理)
        if (userService.IdExist(id)) {

        }
        if (userService.register(id, uname, upass)) {
            return R.OK("注册成功");
        } else {
            return R.Fail("注册失败");
        }
    }

    /**
     * 根据用户名获取个人信息
     *
     * @param uname
     * @return
     */
    @GetMapping("info")
    public Map<String, Object> getInfo(String uname) {
        String id = userService.getUserByName(uname).getId();
        if (null != id) {
            MuserInfo info = userService.getUserInfoById(id);
            return R.OK(info);
        }
        return R.Fail("没有找到该用户信息");
    }

    /**
     * 获取账号密码
     *
     * @param uname
     * @return
     */
    @GetMapping("muser")
    public Map<String, Object> getMuserByUname(String uname) {
        Muser muser = userService.getMuser(uname);
        if (null != muser) {
            return R.OK(muser);
        }
        return R.Fail("查询结果为空");
    }

    /**
     * 修改密码
     *
     * @param uname
     * @param upass
     * @return
     */
    @PostMapping("uptPass")
    public Map<String, Object> uptPass(String uname, String upass) {
        if (userService.uptPass(uname, upass)) {
            return R.OK("修改成功");
        }
        return R.Fail("修改失败");
    }

    /**
     * 更新头像
     *
     * @param id
     * @param file
     * @return
     */
    @PostMapping("uptImg")
    public Map<String, Object> uptImg(String id, MultipartFile file) {
        if (null == file) {
            return R.Fail("文件为空");
        }
        String url = userService.uptImg(id, file);
//        logger.warn("日志" + url);
        if (null != url) {
            return R.OK("上传成功");
        }
        return R.Fail("上传失败");
    }

    /**
     * 修改个人信息
     *
     * @param userinfo
     * @return
     */
    @PostMapping(value = "uptMsg", produces = "application/json;charset=UTF-8")
    public Map<String, Object> uptPass(@RequestBody MuserInfo userinfo) {
        System.out.println(userinfo);
        if (userService.uptMsg(userinfo)) {
            return R.OK("修改成功");
        }
        return R.Fail("修改失败");
    }

}
