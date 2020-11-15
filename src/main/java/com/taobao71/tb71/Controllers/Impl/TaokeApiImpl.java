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
import com.taobao71.tb71.domain.ItemSearch;
import com.taobao71.tb71.rabbitmq.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

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
    @Autowired
    private Publisher publisher;

    private TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
    static Logger logger = LoggerFactory.getLogger(TaokeApiImpl.class);

    @RequestMapping("searchMaterical")
    public void searchMatericalItems(@RequestParam(value = "keyword",required = false,defaultValue = "女装") String keyword){
        TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();
        req.setQ(keyword);
        taobaoClientServer.searchMaterial(req);
    }

    /**
     * 从接口处查询数据；根据Item_id 查询信息
     * @param item_id 宝贝的ID
     */
    @RequestMapping("getItemInfo")
    public void getItemInfo(@RequestParam(value = "item_id",required = true,defaultValue = "123") String item_id){
        TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
        req.setNumIids(item_id);
        taobaoClientServer.getItemInfo(req);
    }

    /**
     * 更加item_id 查询优惠券；判断是否已经存储，如果没有，则调用接口。
     * @param item_id 宝贝ID
     * @return
     */
    @RequestMapping("getCouponByItemId")
    public String searchCouponByItemId(@RequestParam(value = "item_id",required = true,defaultValue = "123") String item_id) {
        // 查询数据库中的优惠券表；
        String couoponUrl = couponServer.getCouponUrlByItemId(item_id);
        if (couoponUrl != null) {
            return couoponUrl;
        }
        // 查询数据库中的优惠券搜索coupon_result结果表；
        couoponUrl = couponResultServer.couponExist(Long.valueOf(item_id));
        if (couoponUrl != null) {
            return couoponUrl;
        }
        // 查询数据库中物料表item;如果查询到了，则表明此物料没有优惠券。
        if (itemServer.itemExistRetrunId(Long.valueOf(item_id)) != 0) {
            return "this item has no coupon!";
        }
        //将Item_id 信息发送到RabbitMQ
        //publisher.sendDirectMessage(item_id);

        // 获取商品Item_id 的详细信息‘
        req.setNumIids(item_id);
        ItemSearch itemSearch = taobaoClientServer.getItemInfo(req);

        // 根据商品信息，搜索优惠券信息
        if (itemSearch != null){
            TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();
            req.setQ(itemSearch.getTitle());
            req.setSellerIds(itemSearch.getSeller_id().toString());
            req.setCat(itemSearch.getCategory_name() + "," + itemSearch.getLevel_one_category_name());
            //req.setItemloc(itemSearch.getProvcity());
            req.setStartPrice(Double.valueOf(itemSearch.getZk_final_price()).longValue());
            req.setEndPrice(Double.valueOf(itemSearch.getZk_final_price()).longValue() + 1);
            taobaoClientServer.searchMaterial(req);
            String couoponUrl2 = couponServer.getCouponUrlByItemId(item_id);
            if (couoponUrl2 != null) {
                return couoponUrl2;
            }
        }
        return "this item has no coupon";
    }
}
