package com.taobao71.tb71.dao;

import org.springframework.stereotype.Component;

@Component
public interface OrderServer {
    /**
     * 向数据库中添加订单信息
     * @param orderId 订单ID
     * @param userId 用户ID
     * @return true/false
     */
    public Integer addOrder(Long orderId,Integer userId);
}
