package com.malred.musicback.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author malguy-wang sir
 * @create ---
 */
//通用返回结果类
public class R {
    //返回时携带的值
//    private Object data;
    //状态码,0是成功,-1是失败
    private static Integer ok=0;
    private static Integer fail=-1;
    //失败时返回的提示信息
//    private String msg;
    public static Map<String,Object> OK(){
        Map map=new HashMap();
        map.put("code",ok);
        return map;
    }
    public static Map<String,Object> OK(Object data){
        Map map=new HashMap();
        map.put("code",ok);
        map.put("data",data);
        return map;
    }
    public static Map<String,Object> Fail(){
        Map map=new HashMap();
        map.put("code",fail);
        return map;
    }
    public static Map<String,Object> Fail(String msg){
        Map map=new HashMap();
        map.put("code",fail);
        map.put("msg",msg);
        return map;
    }
}
