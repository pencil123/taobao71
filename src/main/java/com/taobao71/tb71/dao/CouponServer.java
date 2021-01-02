package com.taobao71.tb71.dao;

import com.taobao71.tb71.domain.Coupon;
import org.springframework.stereotype.Service;

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
}
