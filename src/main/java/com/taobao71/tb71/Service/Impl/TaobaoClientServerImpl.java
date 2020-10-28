package com.taobao71.tb71.Service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao71.tb71.Service.TaobaoClientServer;
import com.taobao71.tb71.Service.TaokeService;
import com.taobao71.tb71.dao.CouponServer;
import com.taobao71.tb71.dao.ItemServer;
import com.taobao71.tb71.dao.MaterialServer;
import com.taobao71.tb71.dao.ShopServer;
import com.taobao71.tb71.domain.Coupon;
import com.taobao71.tb71.domain.Item;
import com.taobao71.tb71.domain.Material;
import com.taobao71.tb71.domain.Shop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
@Service
public class TaobaoClientServerImpl implements TaobaoClientServer {
    @Value("${taobao.appkey}")
    private String appkey;
    @Value("${taobao.secret}")
    private String secret;
    @Value("${taobao.url}")
    private String url;
    @Value("${taobao.AdzoneID}")
    private Long adzoneid;

    @Autowired
    private MaterialServer materialServer;
    @Autowired
    private ShopServer shopServer;
    @Autowired
    private ItemServer itemServer;
    @Autowired
    private CouponServer couponServer;

    private TaobaoClient taobaoClient;

    static Logger logger = LoggerFactory.getLogger(TaobaoClientServerImpl.class);

    /**
     * 物料搜索
     * @param tbkDgMaterialOptionalRequest 请求对象
     * @return
     */
    public String searchMaterial(TbkDgMaterialOptionalRequest tbkDgMaterialOptionalRequest){
        taobaoClient = new DefaultTaobaoClient(url, appkey, secret);
        try {
            // 调用接口查询
            tbkDgMaterialOptionalRequest.setAdzoneId(adzoneid);
            taobaoClient.execute(tbkDgMaterialOptionalRequest);
            TbkDgMaterialOptionalResponse rsp = taobaoClient.execute(tbkDgMaterialOptionalRequest);
            //查询接口处理
            JSONObject jsonObject = JSONObject.parseObject(rsp.getBody());
            JSONObject result_list = jsonObject.getJSONObject("tbk_dg_material_optional_response");
            LinkedList<Material> materials =  new LinkedList<>();
            if (result_list == null) {
                logger.info("search# 关键词:{},页面:{} result is null",tbkDgMaterialOptionalRequest.getQ().toString());
            }

            JSONObject map_data = result_list.getJSONObject("result_list");
            JSONArray infos = map_data.getJSONArray("map_data");
            for(int i=0;i< infos.size();i++) {
                JSONObject info = infos.getJSONObject(i);
 //               Material material = JSON.parseObject(info.toJSONString(),Material.class);
                logger.info("items info:{}",info.toJSONString());


                //商店信息处理
                Shop shop = JSON.parseObject(info.toJSONString(),Shop.class);
                logger.info("Shop test {}",shop.toString());
                Integer shopId = shopServer.addShop(shop);

                //商品信息处理
                Item item = JSON.parseObject(info.toJSONString(), Item.class);
                item.setShop_id(shopId);
                Integer itemId = itemServer.addItem(item);
                logger.info("Item test {}",itemId);

                //优惠券处理
                Coupon coupon = JSON.parseObject(info.toJSONString(),Coupon.class);
                if (!coupon.getCoupon_id().equals("")) {
                    coupon.setItem_id_tk(itemId);
                    int couponId = couponServer.addCoupon(coupon);
                    logger.info("Coupon test {}",couponId);
                }else {
                    logger.info("没有优惠券");
                }
            //    materialServer.addMaterial(material);
            }
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return "hello";
    }


    /**
     *
     */
    public String searchCouponByItemID(){
        taobaoClient = new DefaultTaobaoClient(url, appkey, secret);
        TbkItemidCouponGetRequest req = new TbkItemidCouponGetRequest();
        req.setPlatform(1L);
        req.setPid("mm_123_123_123");
        req.setNumIids("123,456");
        TbkItemidCouponGetResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
    }
}
