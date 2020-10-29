package com.taobao71.tb71.Controllers.Impl;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao71.tb71.Controllers.Search;
import com.taobao71.tb71.Controllers.TaokeApi;
import com.taobao71.tb71.Service.TaobaoClientServer;
import com.taobao71.tb71.dao.CouponResultServer;
import com.taobao71.tb71.dao.CouponServer;
import com.taobao71.tb71.dao.ItemServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/tkapi")
public class TaokeApiImpl implements TaokeApi {
    @Autowired
    private TaobaoClientServer taobaoClientServer;
    @Autowired
    private CouponServer couponServer;
    @Autowired
    private ItemServer itemServer;
    @Autowired
    private CouponResultServer couponResultServer;
    static Logger logger = LoggerFactory.getLogger(TaokeApiImpl.class);

    @RequestMapping("searchMaterical")
    public void searchMatericalItems(@RequestParam(value = "keyword",required = false,defaultValue = "女装") String keyword){
        TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();
        req.setQ(keyword);
        taobaoClientServer.searchMaterial(req);
    }

    @RequestMapping("getItemInfo")
    public void getItemInfo(@RequestParam(value = "item_id",required = true,defaultValue = "123") String item_id){
        TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
        req.setNumIids(item_id);
        taobaoClientServer.getItemInfo(req);
    }

    @RequestMapping("getCouponByItemId")
    public String searchCouponByItemId(@RequestParam(value = "item_id",required = true,defaultValue = "123") String item_id) {
        String couoponUrl = couponServer.getCouponUrlByItemId(item_id);
        if (couoponUrl != null) {
            return couoponUrl;
        }
        couoponUrl = couponResultServer.couponExist(Long.valueOf(item_id));
        if (couoponUrl != null) {
            return couoponUrl;
        }

        if (itemServer.itemExistRetrunId(Long.valueOf(item_id)) != 0) {
            return "this item has no coupon!";
        }

        TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
        req.setNumIids(item_id);
        taobaoClientServer.getItemInfo(req);
        return "Please come back tommorow";
    }
}
