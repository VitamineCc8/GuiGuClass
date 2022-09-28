package com.wei.ggkt.live.config;

import com.wei.ggkt.live.mtcloud.MTCloud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MTCloudConfig {

    @Autowired
    private com.wei.ggkt.live.config.MTCloudAccountConfig mtCloudAccountConfig;


    @Bean
    public MTCloud mtCloudClient(){
        return new MTCloud(mtCloudAccountConfig.getOpenId(), mtCloudAccountConfig.getOpenToken());
    }


    //个人感觉这样也可以
//    @Autowired
//    public  MTCloud mtCloud;
//
//    @Bean
//    public MTCloud mtCloudClient(){
//        return new MTCloud(mtCloud.openID, mtCloud.openToken);
//    }
}
