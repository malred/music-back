package com.malred.musicback.service.impl;

import com.malred.musicback.entity.Muser;
import com.malred.musicback.entity.MuserInfo;
import com.malred.musicback.mappers.MuserDAO;
import com.malred.musicback.service.userService;
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
public class userServiceImpl implements userService {
    @Autowired
    MuserDAO muserDAO;

    @Override
    public Muser login(String uname, String upass) {
        if (null != uname && null != upass) {
            Muser muser = muserDAO.getUserByNameAndPass(uname, upass);
            if (null != muser) {
                return muser;
            }
        }
        return null;
    }

    @Override
    public boolean IdExist(String id) {
        return false;
    }

    @Override
    public boolean unameExist(String uname) {
        //账号已存在
        if (null != muserDAO.getUserByName(uname)) return true;
        return false;
    }

    @Override
    public boolean register(String id, String uname, String upass) {
        if (id == "" || uname == "" || upass == "") return false;
        if (null == id || null == uname || null == upass) return false;
        boolean flag1 = muserDAO.addUser(id, uname, upass);
        boolean flag2 = muserDAO.addUserInfo(id);
        //更新两个库(用代码逻辑代替数据库的外键级联)
        if (flag1 && flag2) return true;
        return false;
    }

    @Override
    public Muser getUserByName(String uname) {
        return muserDAO.getUserByName(uname);
    }

    @Override
    public MuserInfo getUserInfoById(String id) {
        return muserDAO.getUserInfoById(id);
    }

    @Override
    public Muser getMuser(String uname) {
        if (null != uname) {
            return muserDAO.getUserByName(uname);
        }
        return null;
    }

    @Override
    public boolean uptPass(String uname, String upass) {
        if (null != uname && null != upass) {
            return muserDAO.updatePassByName(uname, upass);
        }
        return false;
    }

    @Override
    public boolean uptMsg(MuserInfo muserInfo) {
        if (null != muserInfo) {
            return muserDAO.updateInfoById(
                    muserInfo.getId(),
                    muserInfo.getName(),
                    muserInfo.getAge(),
                    muserInfo.getBirth(),
                    muserInfo.getLocation()
            );
        }
        return false;
    }

    // 上传文件,保存本地
    @Override
    public String uptImg(String id, MultipartFile file) {
        if (null != file && null != id) {
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
            String img = "http://localhost:9090/music/img/" + uuidFilename;
            boolean flag = muserDAO.updateImgById(id, img);
            if (flag) {
                return img;
            }
        }
        return null;
    }
}
