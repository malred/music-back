package com.malred.musicback.service;

import com.malred.musicback.entity.Muser;
import com.malred.musicback.entity.MuserInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author malguy-wang sir
 * @create ---
 */
public interface userService {
    Muser login(String uname, String upass);

    boolean unameExist(String uname);

    boolean register(String id, String uname, String upass);

    boolean IdExist(String id);

    Muser getUserByName(String uname);

    MuserInfo getUserInfoById(String id);

    Muser getMuser(String uname);

    boolean uptPass(String uname, String upass);

    public boolean uptMsg(MuserInfo muserInfo);

    public String uptImg(String id, MultipartFile file);

}
