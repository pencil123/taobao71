package com.taobao71.tb71.Service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao.api.response.TbkItemInfoGetResponse;
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
    private int total_count = 0;

    static Logger logger = LoggerFactory.getLogger(TaobaoClientServerImpl.class);

    @Autowired
    public void setTaobaoClient() {
        this.taobaoClient = new DefaultTaobaoClient(url, appkey, secret);
    }


    /**
     * 解析接口返回的数据，并解析，并写入到数据库
     * @param infos
     */
    private void parseMaterialInfo(JSONArray infos) {
        //查询接口处理
        for(int i=0;i< infos.size();i++) {
            JSONObject info = infos.getJSONObject(i);
            logger.info("items info:{}",info.getLong("num_iid"));

            //商店信息处理
            Shop shop = JSON.parseObject(info.toJSONString(),Shop.class);
            Integer shopId = shopServer.addShop(shop);

            //商品信息处理
            Item item = JSON.parseObject(info.toJSONString(), Item.class);
            item.setShop_id(shopId);
            Integer itemId = itemServer.addItem(item);

            //优惠券处理
            Coupon coupon = JSON.parseObject(info.toJSONString(),Coupon.class);
            if (!coupon.getCoupon_id().equals("")) {
                couponServer.addCoupon(coupon);
            }else {
                logger.info("没有优惠券");
            }
        }
    }

    /**
     * 实际执行接口调用的函数，并将执行结果写入到数据库
     * @param tbkDgMaterialOptionalRequest
     */
    private void searchMaterialAction(TbkDgMaterialOptionalRequest tbkDgMaterialOptionalRequest){
        JSONObject result_list;
        JSONArray map_data;
        JSONObject tbk_dg_material_optional_response;
        try{
            // 执行调用接口
            TbkDgMaterialOptionalResponse rsp = taobaoClient.execute(tbkDgMaterialOptionalRequest);
            JSONObject jsonObject = JSONObject.parseObject(rsp.getBody());
            tbk_dg_material_optional_response = jsonObject.getJSONObject("tbk_dg_material_optional_response");
        }catch (ApiException e) {
            e.printStackTrace();
            return;
        }
        // 调用接口返回值的数量
        if(this.total_count ==0){
            this.total_count = tbk_dg_material_optional_response.getIntValue("total_results");
        }
        // 处理返回的值为空的情况
        try {
            // 接口不稳定；有时候返回数据为空
            result_list = tbk_dg_material_optional_response.getJSONObject("result_list");
            map_data = result_list.getJSONArray("map_data");
        } catch (NullPointerException e){
            logger.info("返回为空；变量i:{}");
            return;
        }
        parseMaterialInfo(map_data);
    }
    /**
     * 物料搜索
     * @param tbkDgMaterialOptionalRequest 请求对象
     * @return
     */
    public String searchMaterial(TbkDgMaterialOptionalRequest tbkDgMaterialOptionalRequest){
        // 调用接口请求参数设置
        tbkDgMaterialOptionalRequest.setAdzoneId(adzoneid);
        tbkDgMaterialOptionalRequest.setSort("total_sales");
        tbkDgMaterialOptionalRequest.setHasCoupon(true);
        tbkDgMaterialOptionalRequest.setPageSize(100L);
        int pageNo =1;
        do {
            tbkDgMaterialOptionalRequest.setPageNo(Long.valueOf(pageNo));
            pageNo ++;
            searchMaterialAction(tbkDgMaterialOptionalRequest);
            try {
                Thread.sleep(2000);    //延时2秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (pageNo < this.total_count/100 + 1);
        return "Success";
    }

    /**
     * 根据ItemID 查询商品信息
     * @param tbkItemInfoGetRequest
     * @return
     */
    public String getItemInfo(TbkItemInfoGetRequest tbkItemInfoGetRequest){
        try {
            TbkItemInfoGetResponse rsp = taobaoClient.execute(tbkItemInfoGetRequest);
            JSONObject jsonObject = JSONObject.parseObject(rsp.getBody());
            logger.info("输出信息：{}",jsonObject.toJSONString());
            JSONObject results = jsonObject.getJSONObject("tbk_item_info_get_response").getJSONObject("results");
            JSONArray n_tbk_item = results.getJSONArray("n_tbk_item");
            if (n_tbk_item.size() == 1) {
                JSONObject itemJsonObject = n_tbk_item.getJSONObject(0);
                itemJsonObject.put("category_name",itemJsonObject.getString("cat_leaf_name"));
                itemJsonObject.put("level_one_category_name",itemJsonObject.getString("cat_name"));
                itemJsonObject.put("item_id",itemJsonObject.getLongValue("num_iid"));

                Item item = JSON.parseObject(itemJsonObject.toJSONString(), Item.class);
                Integer itemId = itemServer.addItem(item);
            } else{
                logger.error("getIteminfo response size {};info: {}",n_tbk_item.size(),n_tbk_item.toJSONString());
            }
        }catch (ApiException e) {
            e.printStackTrace();
        }
        return "Success";
    }

/*    *//**
     * 根据ItemId 查询商品的优惠券
     * @return
     *//*
    public String searchCouponByItemID(){
        taobaoClient = new DefaultTaobaoClient(url, appkey, secret);
        TbkItemidCouponGetRequest req = new TbkItemidCouponGetRequest();
        req.setPlatform(1L);
        req.setPid("mm_123_123_123");
        req.setNumIids("123,456");
        TbkItemidCouponGetResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
    }*/
}
