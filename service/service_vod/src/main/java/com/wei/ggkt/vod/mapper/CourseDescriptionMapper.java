package com.wei.ggkt.vod.mapper;

import com.wei.ggkt.model.vod.CourseDescription;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 课程简介 Mapper 接口
 * </p>
 *
 * @author wei
 * @since 2022-09-13
 */
@Mapper
public interface CourseDescriptionMapper extends BaseMapper<CourseDescription> {

//    @Select("select * from `course_description` where course_id = #{id}")
    //也可以使用注解这样的写法，或者在xml文件
    CourseDescription getDescriptionById(@Param("id") Long id);
}
