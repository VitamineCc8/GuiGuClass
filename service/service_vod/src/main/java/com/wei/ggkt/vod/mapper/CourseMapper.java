package com.wei.ggkt.vod.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wei.ggkt.model.vod.Course;
import com.wei.ggkt.vo.vod.CoursePublishVo;
import com.wei.ggkt.vo.vod.CourseVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author wei
 * @since 2022-09-14
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    CoursePublishVo selectCoursePublishVoById(@Param("id") Long id);

    CourseVo selectCourseVoById(@Param("courseId") Long courseId);
}
