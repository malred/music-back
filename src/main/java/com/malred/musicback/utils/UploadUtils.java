package com.malred.musicback.utils;

import java.util.UUID;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class UploadUtils {
    /**
     * 获取随机名称
     *
     * @param realName 真实名称
     * @return uuid 随机名称
     */
    public static String getUUIDName(String realName) {
        //获取后缀名
        int index = realName.lastIndexOf(".");
        if (index == -1) {//如果没有后缀
            return UUID.randomUUID().toString().replace("-", "").toUpperCase();
        } else { //如果有后缀就接上
            return UUID.randomUUID().toString().replace("-", "")
                    .toUpperCase() + realName.substring(index);
        }
    }
}
