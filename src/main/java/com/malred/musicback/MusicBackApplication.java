package com.malred.musicback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.malred.musicback.mappers")
public class MusicBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicBackApplication.class, args);
    }
    // 允许前端传递特殊字符
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(connector -> {
            connector.setProperty("relaxedPathChars", "[]|"); // 添加需要的特殊符号
            connector.setProperty("relaxedQueryChars", "|{}[]");    // 添加需要的特殊符号
        });
        return factory;
    }
}
