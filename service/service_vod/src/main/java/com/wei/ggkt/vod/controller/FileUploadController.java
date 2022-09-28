package com.wei.ggkt.vod.controller;

import com.wei.ggkt.result.Result;
import com.wei.ggkt.vod.service.impl.FileServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author VitamineG
 * @DateTime 2022/9/9 23:40
 */
@Api(tags = "文件上传接口")
@RestController
//@CrossOrigin
@RequestMapping("/admin/vod/file")
public class FileUploadController {

    @Autowired
    private FileServiceImpl fileService;

    /**
     * 文件上传
     */
    @ApiOperation(value = "文件上传")
    @PostMapping("upload")
    public Result upload(
            @ApiParam(name = "file", value = "文件", required = true)
            @RequestParam("file") MultipartFile file) {
        String uploadUrl = fileService.upload(file);
        return Result.ok(uploadUrl).message("文件上传成功");
    }

}
