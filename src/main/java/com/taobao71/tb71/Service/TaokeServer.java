package com.taobao71.tb71.Service;

import com.taobao71.tb71.model.domain.Coupon;
import com.taobao71.tb71.model.vo.CouponResp;
import com.taobao71.tb71.model.domain.Item;
import org.springframework.stereotype.Service;

/**
 * taobao 数据对象处理
 */
@Service
public interface TaokeServer {
    /**
     * 获取Coupon 信息；根据ItemId 查询
     * @param itemId
     * @return 如果没有，则返回null
     */
    public Coupon getCouponByItemId(String itemId,boolean sendMq);

    /**
     * Item 表中是否存在物料
     * @param itemId
     * @return 如果有：true
     */
    public Item getItemByItemId(String itemId);

    /**
     * 获取Coupon 信息
     * @param itemId
     * @return
     */
    public CouponResp getCouponResp( String itemId);

}
