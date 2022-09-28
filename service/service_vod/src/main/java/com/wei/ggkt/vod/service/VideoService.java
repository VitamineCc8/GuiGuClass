package com.wei.ggkt.vod.service;

import com.wei.ggkt.model.vod.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author wei
 * @since 2022-09-13
 */
public interface VideoService extends IService<Video> {

    void removeVideoByCourseId(Long id);
}
