package com.wei.ggkt.live.service;

import com.wei.ggkt.model.live.LiveCourseAccount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 直播课程账号表（受保护信息） 服务类
 * </p>
 *
 * @author wei
 * @since 2022-05-09
 */
public interface LiveCourseAccountService extends IService<LiveCourseAccount> {

    //获取直播账号信息
    LiveCourseAccount getLiveCourseAccountCourseId(Long id);
}
