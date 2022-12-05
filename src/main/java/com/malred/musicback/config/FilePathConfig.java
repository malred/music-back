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
        registry.addResourceHandler("/music/img/**")//虚拟url地址,如1/1.jpg
                .addResourceLocations("file:D:\\blob\\music_img\\");//       windows
//        .addResourceLocations("file:var/blob/guli_user"); //       linux
    }
}
