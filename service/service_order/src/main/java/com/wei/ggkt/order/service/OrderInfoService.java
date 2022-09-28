package com.wei.ggkt.order.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wei.ggkt.model.order.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.ggkt.vo.order.OrderFormVo;
import com.wei.ggkt.vo.order.OrderInfoQueryVo;
import com.wei.ggkt.vo.order.OrderInfoVo;

import java.util.Map;

/**
 * <p>
 * 订单表 订单表 服务类
 * </p>
 *
 * @author wei
 * @since 2022-09-20
 */
public interface OrderInfoService extends IService<OrderInfo> {

    Map<String, Object> findPageOrderInfo(Page<OrderInfo> pageParam, OrderInfoQueryVo orderInfoQueryVo);

    void updateOrderStatus(String out_trade_no);

    Long submitOrder(OrderFormVo orderFormVo);

    OrderInfoVo getOrderInfoById(Long id);

    boolean getOrderStatusById(Long courseId, Long userId);
}
