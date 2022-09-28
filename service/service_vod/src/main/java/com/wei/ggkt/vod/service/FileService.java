package com.wei.ggkt.vod.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author VitamineG
 * @DateTime 2022/9/9 23:42
 */
public interface FileService {
    //文件上传
    String upload(MultipartFile file);
}
