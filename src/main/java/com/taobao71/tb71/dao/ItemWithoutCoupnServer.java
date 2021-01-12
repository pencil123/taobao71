package com.taobao71.tb71.dao;


import com.taobao71.tb71.domain.ItemWithoutCoupon;
import org.springframework.stereotype.Service;

@Service
public interface ItemWithoutCoupnServer {
    public Integer addItemWithoutCoupon(ItemWithoutCoupon itemWithoutCoupon);
    public Integer getItemByItemID(Long item_id);
}
