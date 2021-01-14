package com.taobao71.tb71.dao;

import com.taobao71.tb71.domain.Coupon;
import com.taobao71.tb71.domain.CouponResp;
import com.taobao71.tb71.domain.ItemResp;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 逻辑：自建库处理
 * 优惠券Coupon对象处理
 */
@Service
public interface CouponServer {

    /**
     * 向数据库中插入优惠券信息
     * @param coupon
     * @return 优惠券的ID
     */
    public Integer addCoupon(Coupon coupon);

    /**
     * 通过item_Id 查询优惠券信息
     * @param item_id
     * @return 优惠券的分享URL地址
     */
    public String getCouponUrlByItemId(String item_id);

    /**
     * 通过ItemId 查询优惠券信息
     * @param itemId
     * @return
     */
    public Coupon getCouponByItemId(String itemId);


    /**
     * 根据搜索 ID 返回 物料信息
     * @param searchId
     * @return 返回 物料信息
     */
    public List<ItemResp> searchCouponBySearchId(String searchId);
}
