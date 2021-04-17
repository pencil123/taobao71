package com.taobao71.tb71.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taobao71.tb71.Service.OrderServer;
import com.taobao71.tb71.mapper.OrderMapper;
import com.taobao71.tb71.mapper.UserMapper;
import com.taobao71.tb71.model.domain.Order;
import com.taobao71.tb71.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServerImpl extends ServiceImpl<OrderMapper, Order> implements OrderServer {
  @Autowired Order order;

  public boolean addOrder(Long orderId,Integer userId){
    order.setOrderid(orderId);
    order.setUserId(userId);
    return save(order);
  }
}
