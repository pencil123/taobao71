package com.taobao71.tb71.Service.Impl;

import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao71.tb71.Service.TaobaoClientServer;
import com.taobao71.tb71.Service.TaokeServer;
import com.taobao71.tb71.dao.CouponResultServer;
import com.taobao71.tb71.dao.CouponServer;
import com.taobao71.tb71.dao.ItemServer;
import com.taobao71.tb71.domain.Coupon;
import com.taobao71.tb71.domain.CouponResp;
import com.taobao71.tb71.rabbitmq.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaokeServerImpl implements TaokeServer {
    @Autowired
    private TaobaoClientServer taobaoClientServer;
    @Autowired
    private CouponServer couponServer;
    @Autowired
    private ItemServer itemServer;
    @Autowired
    private CouponResultServer couponResultServer;
    @Autowired
    private Publisher publisher;

    private TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();

    static Logger logger = LoggerFactory.getLogger(TaokeServerImpl.class);

    public Coupon getCouponByItemId(String itemId){

         // 查询数据库中的优惠券表；
        Coupon coupon = couponServer.getCouponByItemId(itemId);
        logger.info("Coupon info:{}",coupon.toString());
        if (coupon != null) {
            return coupon;
        }
        // 查询数据库中的优惠券搜索coupon_result结果表；
        coupon = couponResultServer.getCouponByItemId(itemId);
        if (coupon != null) {
            return coupon;
        }
        // 查询数据库中物料表item;如果查询到了，则表明此物料没有优惠券。
        if (itemServer.itemExistRetrunId(Long.valueOf(itemId)) != 0) {
            return null;
        }
        //将Item_id 信息发送到RabbitMQ
        publisher.sendDirectMessage(itemId);

        // 获取商品Item_id 的详细信息‘
//        req.setNumIids(item_id);
//        ItemSearch itemSearch = taobaoClientServer.getItemInfo(req);
//
//        // 根据商品信息，搜索优惠券信息
//        if (itemSearch != null) {
//            TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();
//            req.setQ(itemSearch.getTitle());
//            req.setSellerIds(itemSearch.getSeller_id().toString());
//            req.setCat(itemSearch.getCategory_name() + "," + itemSearch.getLevel_one_category_name());
//            //req.setItemloc(itemSearch.getProvcity());
//            req.setStartPrice(Double.valueOf(itemSearch.getZk_final_price()).longValue());
//            req.setEndPrice(Double.valueOf(itemSearch.getZk_final_price()).longValue() + 1);
//            taobaoClientServer.searchMaterial(req);
//            String couoponUrl2 = couponServer.getCouponUrlByItemId(item_id);
//            if (couoponUrl2 != null) {
//                return couoponUrl2;
//            }
//        }
        return null;
    }



    /**
     * 获取Coupon 信息
     * @param itemId
     * @return
     */
    public CouponResp getCouponResp(String itemId){
        Coupon coupon = couponServer.getCouponByItemId(itemId);
        if (coupon == null) {
            return null;
        }
        CouponResp conponResp = new CouponResp();
        String imgUrl = coupon.getPict_url().replace("s://img.alicdn","://img.taobao71");
        conponResp.setPict_url(imgUrl + "_350x350.jpg");
        conponResp.setSmall_images(conponResp.getSmall_images());
        conponResp.setTpwd(taobaoClientServer.gainTpwd("https:" + coupon.getCoupon_share_url()).getPassword_simple());
        return conponResp;
    }
}
