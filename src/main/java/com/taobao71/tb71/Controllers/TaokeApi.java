package com.taobao71.tb71.Controllers;

import com.taobao71.tb71.domain.Coupon;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 淘宝接口
 */

public interface TaokeApi {
    public void searchMatericalItems(String keyword);
    public void getItemInfo(String item_id);
    public Coupon searchCouponByItemId(String item_id);
}
