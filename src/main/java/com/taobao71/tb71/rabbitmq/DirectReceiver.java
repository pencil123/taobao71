package com.taobao71.tb71.rabbitmq;

import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao71.tb71.Service.tk.TaobaoClientServer;
import com.taobao71.tb71.model.domain.Item;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "tkQueue")//监听的队列名称 TestDirectQueue
public class DirectReceiver {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private TaobaoClientServer taobaoClientServer;

    private TbkItemInfoGetRequest tbkItemInfoGetRequest = new TbkItemInfoGetRequest();
    private TbkDgMaterialOptionalRequest tbkDgMaterialOptionalRequest = new TbkDgMaterialOptionalRequest();
    static Logger logger = LoggerFactory.getLogger(DirectReceiver.class);

    private String msgType;

    @RabbitHandler
    public void process(Map itemMessage) {
        logger.info("DirectReceiver消费者收到消息 :{}",itemMessage.toString());
        msgType = itemMessage.get("type").toString();
        switch(msgType){
            case "searchItemById" :
                dealSearchItemById(itemMessage);
                break;
            case "searchCouponByKeyword" :
                dealSearchCouponByKeyword(itemMessage.get("keyword").toString(),itemMessage.get("searchId").toString());
                break;
            default:
                logger.warn("没有匹配到处理方法:{}",itemMessage.toString());
                break;
        }
    }

    private void dealSearchItemById(Map itemMessage){
        try{
            tbkItemInfoGetRequest.setNumIids(itemMessage.get("itemId").toString());
            Item item = taobaoClientServer.getItemInfo(tbkItemInfoGetRequest);
            if( item != null){
                taobaoClientServer.gainItemsByItem(item);
            }else {
                logger.info("没有找到客户提交ID的商品信息。");
            }
        }catch (NullPointerException e){
            logger.warn("通过ID搜索商品失败:{}",itemMessage.toString());
        }
    }

    private void dealSearchCouponByKeyword(String keyword,String searchId){
        tbkDgMaterialOptionalRequest.setQ(keyword);
        tbkDgMaterialOptionalRequest.setHasCoupon(true);
        taobaoClientServer.searchMaterial(tbkDgMaterialOptionalRequest,searchId);
    }
}
