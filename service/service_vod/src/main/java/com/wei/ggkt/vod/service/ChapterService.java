package com.wei.ggkt.vod.service;

import com.wei.ggkt.model.vod.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.ggkt.vo.vod.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author wei
 * @since 2022-09-13
 */
public interface ChapterService extends IService<Chapter> {

    List<ChapterVo> getTreeList(Long courseId);

    void removeChapterByCourseId(Long id);


}
