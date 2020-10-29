package com.taobao71.tb71.dao;

import com.taobao71.tb71.domain.Coupon;
import org.springframework.stereotype.Service;

@Service
public interface CouponServer {
    public Integer addCoupon(Coupon coupon);
    public String getCouponUrlByItemId(String item_id);
}
