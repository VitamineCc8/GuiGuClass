package com.wei.ggkt.order.mapper;

import com.wei.ggkt.model.order.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 订单表 订单表 Mapper 接口
 * </p>
 *
 * @author wei
 * @since 2022-09-20
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

    OrderInfo getOrderStatus(@Param("courseId") Long courseId, @Param("userId") Long userId);
}
