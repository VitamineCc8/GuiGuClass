package com.wei.ggkt.live.service;

import com.wei.ggkt.model.live.LiveCourseDescription;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程简介 服务类
 * </p>
 *
 * @author wei
 * @since 2022-05-09
 */
public interface LiveCourseDescriptionService extends IService<LiveCourseDescription> {

    //获取直播课程描述信息
    LiveCourseDescription getLiveCourseById(Long id);
}
