package com.taobao71.tb71.Service;

import com.taobao71.tb71.domain.Coupon;
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
    public Coupon getCouponByItemId(String itemId);

}
