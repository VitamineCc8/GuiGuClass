package com.wei.ggkt.vod.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.ggkt.vod.mapper.SubjectMapper;
import com.wei.ggkt.vod.service.SubjectService;
import org.springframework.stereotype.Service;
import com.wei.ggkt.model.vod.Subject;

import java.util.List;

/**
 * @author wei
 * @since 2022-09-10
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    public List<Subject> selectList(Long id) {
        QueryWrapper<Subject> subjectQueryWrapper = new QueryWrapper<>();
        subjectQueryWrapper.eq("parent_id", id);
        List<Subject> subjects = baseMapper.selectList(subjectQueryWrapper);
        for (Subject subject : subjects) {
            Long subjectId = subject.getId();
            boolean isChild = this.isChildren(subjectId);
            subject.setHasChildren(isChild);
        }
        return subjects;
    }

    //查询id下面是否有子节点
    private boolean isChildren(Long subjectId) {
        QueryWrapper<Subject> subjectQueryWrapper = new QueryWrapper<>();
        subjectQueryWrapper.eq("parent_id", subjectId);
        Integer count = baseMapper.selectCount(subjectQueryWrapper);
        return count > 0;
    }
}
