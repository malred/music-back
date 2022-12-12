package com.malred.musicback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author malguy-wang sir
 * @create ---
 */
/**
 * 映射url到本地目录
 */
@Configuration
public class FilePathConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //music/img就到music_img/img文件夹,music/blog就到music_img/blog
        registry.addResourceHandler("/music/**")//虚拟url地址,如1/1.jpg
                .addResourceLocations("file:D:\\blob\\music_img\\");//       windows
//        .addResourceLocations("file:var/blob/guli_user"); //       linux
//        registry.addResourceHandler("/music/blog/**")//虚拟url地址,如1/1.jpg
//                .addResourceLocations("file:D:\\blob\\music_img\\blog");//
    }
}
