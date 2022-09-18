package com.wei.ggkt.vod.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.ggkt.model.vod.Course;
import com.wei.ggkt.vo.vod.CourseFormVo;
import com.wei.ggkt.vo.vod.CoursePublishVo;
import com.wei.ggkt.vo.vod.CourseQueryVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author wei
 * @since 2022-09-14
 */
public interface CourseService extends IService<Course> {

    Map<String,Object> findPageCourse(Page<Course> pageParam, CourseQueryVo courseQueryVo);

    Long saveCourseInfo(CourseFormVo courseFormVo);

    CourseFormVo getCourseFormVoById(Long id);

    void updateCourseById(CourseFormVo courseFormVo);

    CoursePublishVo getCoursePublishVo(Long id);

    void publishCourse(Long id);

    void removeCourseId(Long id);

    List<Course> findlist();
}
