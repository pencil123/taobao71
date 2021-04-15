package com.taobao71.tb71.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taobao71.tb71.model.domain.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderServer extends IService<Order> {

  public boolean addOrder(Long orderId,Integer userId);
}
