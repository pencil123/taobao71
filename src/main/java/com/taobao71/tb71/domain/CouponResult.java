package com.taobao71.tb71.domain;

import org.springframework.stereotype.Component;

@Component
public class CouponResult extends Coupon{
    private Integer id;
    private Long item_id;
    private String coupon_share_url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public String getCoupon_share_url() {
        return coupon_share_url;
    }

    public void setCoupon_share_url(String coupon_share_url) {
        this.coupon_share_url = coupon_share_url;
    }
}
