package com.wei.ggkt.vod;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author VitamineG
 * @DateTime 2022/9/7 0:25
 */
@SpringBootApplication
@MapperScan("com.wei.ggkt.vod.mapper")
@ComponentScan(basePackages = "com.wei")
public class  ServiceVodApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceVodApplication.class, args);
    }
}
