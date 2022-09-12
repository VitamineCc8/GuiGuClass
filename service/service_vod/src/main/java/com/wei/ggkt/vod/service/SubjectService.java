package com.wei.ggkt.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.ggkt.model.vod.Subject;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author wei
 * @since 2022-09-10
 */
public interface SubjectService extends IService<Subject> {

    List<Subject> selectList(Long id);
}
