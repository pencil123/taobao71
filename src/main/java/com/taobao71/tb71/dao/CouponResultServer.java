package com.taobao71.tb71.dao;

import com.taobao71.tb71.domain.Coupon;
import org.springframework.stereotype.Service;

/**
 * 逻辑：自行维护数据
 * 自行维护数据，添加优惠券Coupon 信息
 */
@Service
public interface CouponResultServer {

    /**
     * 判断商品信息是否存在
     * @param item_id
     * @return 商品优惠券信息；如果没有则返回NULL
     */

    public String couponExist(Long item_id);


    public Coupon getCouponByItemId(String itemId);
}
