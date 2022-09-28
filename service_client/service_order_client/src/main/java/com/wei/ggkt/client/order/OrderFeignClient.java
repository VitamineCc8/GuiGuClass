package com.wei.ggkt.client.order;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @author VitamineG
 * @DateTime 2022/9/27 20:29
 */
@FeignClient(value = "service-order")
public interface OrderFeignClient {

    @ApiOperation("查询用户是否购买")
    @GetMapping("api/order/orderInfo/getOrderStatus/{courseId}/{userId}")
    public boolean getOrderStatus(@PathVariable Long courseId, @PathVariable Long userId);

}
