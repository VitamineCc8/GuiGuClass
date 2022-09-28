package com.wei.ggkt.user.service.impl;

import com.wei.ggkt.model.user.UserInfo;
import com.wei.ggkt.user.mapper.UserInfoMapper;
import com.wei.ggkt.user.service.UserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wei
 * @since 2022-04-29
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    //openid查询
    @Override
    public UserInfo getUserInfoOpenid(String openId) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("open_id",openId);
        return baseMapper.selectOne(wrapper);
    }
}

