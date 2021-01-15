package com.taobao71.tb71.rabbitmq;

import com.alibaba.fastjson.JSONObject;
import com.taobao71.tb71.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Component
public class Publisher {
    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法
    @Autowired
    RabbitmqConfig rabbitmqConfig;

    public boolean sendDirectMessage(String itemId) {
        Map<String,String> map=new HashMap<>();
        map.put("itemId",itemId);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("tkExchange", "tk",map);
        return true;
    }

    public boolean sendMapMesssage(Map map){
        //map.type searchItemById  提供itemID 搜索物料信息
        //map.type searchCouponByKeyword  提供搜索关键词，搜索优惠券信息
        rabbitTemplate.convertAndSend("tkExchange", "tk",map);
        return true;
    }
}
