package com.taobao71.tb71.Service.tk;

import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao71.tb71.Service.CouponServer;
import com.taobao71.tb71.Service.ItemServer;
import com.taobao71.tb71.model.domain.Coupon;
import com.taobao71.tb71.model.domain.Item;
import com.taobao71.tb71.model.vo.CouponPwdResp;
import com.taobao71.tb71.rabbitmq.Publisher;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaokeServer {
    @Autowired
    private TaobaoClientServer taobaoClientServer;
    @Autowired
    private CouponServer couponServer;
    @Autowired
    private ItemServer itemServer;
    @Autowired
    private Publisher publisher;

    private TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();

    static Logger logger = LoggerFactory.getLogger(TaokeServer.class);

    public Coupon getCouponByItemId(String itemId,boolean sendMq){

         // 查询数据库中的优惠券表；
        Coupon coupon = couponServer.getCouponByItemId(itemId);

        if (coupon != null) {
            logger.info("Coupon info:{}",coupon.toString());
            return coupon;
        }
        if(!sendMq){
            return null;
        }
        //将Item_id 信息发送到RabbitMQ
        Map<String,String> map=new HashMap<>();
        map.put("type","searchItemById");
        map.put("itemId",itemId);
        publisher.sendMapMesssage(map);
        return null;
    }

    /**
     * Item 表中是否存在物料
     * @param itemId
     * @return 如果有：true
     */
    public Item getItemByItemId(String itemId){
        // 查询数据库中物料表item;如果查询到了，则表明此物料没有优惠券。
        Item item = itemServer.getItemByItemId(Long.valueOf(itemId));
        if(item != null){
            logger.info("Item is not null");
        }
        return item != null ? item : null;
    }

    /**
     * 获取Coupon 信息
     * @param itemId
     * @return
     */
    public CouponPwdResp getCouponResp(String itemId){
        Coupon coupon = couponServer.getCouponByItemId(itemId);
        if(coupon != null){
            CouponPwdResp conponPwdResp = new CouponPwdResp();
            String imgUrl = coupon.getPictUrl().replace("s://img.alicdn","://img.taobao71");
            conponPwdResp.setTitle(coupon.getTitle());
            conponPwdResp.setPictUrl(imgUrl + "_350x350.jpg");
            conponPwdResp.setSmallImages(conponPwdResp.getSmallImages());
            conponPwdResp.setTpwd(taobaoClientServer.gainTpwd("https:" + coupon.getCouponShareUrl()).getPasswordSimple());
            return conponPwdResp;
        }
        Item item = itemServer.getItemByItemId(Long.valueOf(itemId));
        if(item != null){
            CouponPwdResp conponPwdResp = new CouponPwdResp();
            String imgUrl = item.getPictUrl().replace("s://img.alicdn","://img.taobao71");
            conponPwdResp.setPictUrl(imgUrl + "_350x350.jpg");
            conponPwdResp.setTpwd(taobaoClientServer.gainTpwd("https:" + item.getUrl()).getPasswordSimple());
            return conponPwdResp;
        }else{
            return null;
        }
    }
}
