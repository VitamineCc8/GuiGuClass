package com.wei.ggkt.vod.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface VodService {
    //上传视频
    String updateVideo(MultipartFile file) throws IOException;

    //删除腾讯云视频
    void removeVideo(String fileId);

    Map<String, Object> getPlayAuth(Long courseId, Long videoId);
}
