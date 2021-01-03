package com.taobao71.tb71.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 淘宝接口
 */

public interface TaokeApi {

    public void searchMatericalItems(String keyword);
    public void getItemInfo(String item_id);
    public String searchCouponByItemId(String item_id);
}
