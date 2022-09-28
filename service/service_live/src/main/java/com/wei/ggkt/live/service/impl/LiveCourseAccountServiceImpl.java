package com.wei.ggkt.live.service.impl;

import com.wei.ggkt.model.live.LiveCourseAccount;
import com.wei.ggkt.live.mapper.LiveCourseAccountMapper;
import com.wei.ggkt.live.service.LiveCourseAccountService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 直播课程账号表（受保护信息） 服务实现类
 * </p>
 *
 * @author wei
 * @since 2022-05-09
 */
@Service
public class LiveCourseAccountServiceImpl extends ServiceImpl<LiveCourseAccountMapper, LiveCourseAccount> implements LiveCourseAccountService {

    //获取直播账号信息
    @Override
    public LiveCourseAccount getLiveCourseAccountCourseId(Long id) {
        LambdaQueryWrapper<LiveCourseAccount> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(LiveCourseAccount::getLiveCourseId,id);
        LiveCourseAccount liveCourseAccount = baseMapper.selectOne(wrapper);
        return liveCourseAccount;
    }
}
