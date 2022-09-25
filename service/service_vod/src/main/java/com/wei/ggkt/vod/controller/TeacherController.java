package com.wei.ggkt.vod.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wei.ggkt.exception.GgktException;
import com.wei.ggkt.model.vod.Teacher;
import com.wei.ggkt.result.Result;
import com.wei.ggkt.vo.vod.TeacherQueryVo;
import com.wei.ggkt.vod.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @author wei
 * @since 2022-09-07
 */
@Api(tags = "讲师管理接口")
@RestController
//@CrossOrigin
@RequestMapping("/admin/vod/teacher")
public class TeacherController {

    //gqw-guiguclass-1313868630.cos.ap-guangzhou.myqcloud.com
    //APPID:1313868630

    @Autowired
    private TeacherService teacherService;

    // http://localhost:8301/admin/vod/teacher/findAll
    //查询所有讲师列表
    @ApiOperation("罗列所有讲师")
    @GetMapping("findAll")
    public Result<List<Teacher>> findAll() {
        List<Teacher> list;
        try {
            list = teacherService.list();
        } catch (Exception e) {
            throw new GgktException(201, "执行自定义异常，并捕获异常");
        }
        return Result.ok(list).message("查询数据成功");
    }

    //删除讲师
    @ApiOperation("逻辑删除讲师")
    @DeleteMapping("remove/{id}")
    public Result removeById(@ApiParam(name = "id", value = "ID", required = true)
                             @PathVariable Long id) {
        boolean isSuccess = teacherService.removeById(id);
        if (isSuccess) {
            return Result.ok(null).message("逻辑删除讲师成功");
        } else {
            return Result.fail(null).message("逻辑删除讲师失败");
        }
    }


    //条件查询分页列表
    @ApiOperation("条件查询分页")
    @PostMapping("findQuery/{current}/{limit}")
    public Result findPage(@ApiParam(name = "current", value = "当前页码", required = true)
                           @PathVariable long current,
                           @ApiParam(name = "limit", value = "每页记录数", required = true)
                           @PathVariable long limit,
                           @ApiParam(name = "teacherVo", value = "查询对象", required = false)
                           @RequestBody(required = false) TeacherQueryVo teacherQueryVo) {
        //创建page对象，传递当前页和每页记录数
        Page<Teacher> teacherPage = new Page<>(current, limit);
        //获取条件值
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        if (teacherQueryVo == null) {
            return Result.ok(teacherService.page(teacherPage, null));
        } else {
            String name = teacherQueryVo.getName();//讲师名称
            Integer level = teacherQueryVo.getLevel();//讲师级别
            String joinDateBegin = teacherQueryVo.getJoinDateBegin();//开始时间
            String joinDateEnd = teacherQueryVo.getJoinDateEnd();//结束时间
            //封装条件
            if (!StringUtils.isEmpty(name)) {
                wrapper.like("name", name);
            }
            if (!StringUtils.isEmpty(level)) {
                wrapper.eq("level", level);
            }
            if (!StringUtils.isEmpty(joinDateBegin)) {
                wrapper.ge("join_date", joinDateBegin);
            }
            if (!StringUtils.isEmpty(joinDateEnd)) {
                wrapper.le("join_date", joinDateEnd);
            }
        }
        //调用方法得到分页查询结果
        return Result.ok(teacherService.page(teacherPage, wrapper));
    }


//    List<AttrAttrgroupRelationEntity> collect = Arrays.asList(vos).stream().map(item -> {
//        AttrAttrgroupRelationEntity attrgroupRelation = new AttrAttrgroupRelationEntity();
//        BeanUtils.copyProperties(item, attrgroupRelation);
//        return attrgroupRelation;
//    }).collect(Collectors.toList());

    //4 添加讲师
    @ApiOperation("添加讲师")
    @PostMapping("saveTeacher")
    public Result saveTeacher(@RequestBody Teacher teacher) {
        boolean isSuccess = teacherService.save(teacher);
        if (isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    //5 修改-根据id查询
    @ApiOperation("根据id查询")
    @GetMapping("getTeacher/{id}")
    public Result getTeacher(@PathVariable Long id) {
        Teacher teacher = teacherService.getById(id);
        return Result.ok(teacher);
    }

    //6 修改-最终实现
    @ApiOperation("修改最终实现")
    @PostMapping("updateTeacher")
    public Result updateTeacher(@RequestBody Teacher teacher) {
        boolean isSuccess = teacherService.updateById(teacher);
        if (isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    //7 批量删除讲师
    // json数组 [1,2,3]
    @ApiOperation("批量删除讲师")
    @DeleteMapping("removeBatch")
    public Result removeBatch(@RequestBody List<Long> idList) {
        boolean isSuccess = teacherService.removeByIds(idList);
        if (isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }


}

