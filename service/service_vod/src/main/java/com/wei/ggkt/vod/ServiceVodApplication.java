package com.wei.ggkt.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author VitamineG
 * @DateTime 2022/9/7 0:25
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.wei")
public class  ServiceVodApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceVodApplication.class, args);
    }
}
