package com.taobao71.tb71.Service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao71.tb71.Service.TaobaoClientServer;
import com.taobao71.tb71.Service.TaokeService;
import com.taobao71.tb71.domain.Material;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private TaobaoClient taobaoClient;

    static Logger logger = LoggerFactory.getLogger(TaobaoClientServerImpl.class);

    /**
     * 物料搜索
     * @param tbkDgMaterialOptionalRequest 请求对象
     * @return
     */
    public String searchMaterial(TbkDgMaterialOptionalRequest tbkDgMaterialOptionalRequest){
        taobaoClient = new DefaultTaobaoClient(url, appkey, secret);
        logger.info("search# 关键词:{},页面:{} result is null",tbkDgMaterialOptionalRequest.getQ().toString());
        try {
            tbkDgMaterialOptionalRequest.setAdzoneId(adzoneid);
            taobaoClient.execute(tbkDgMaterialOptionalRequest);
            TbkDgMaterialOptionalResponse rsp = taobaoClient.execute(tbkDgMaterialOptionalRequest);
            JSONObject jsonObject = JSONObject.parseObject(rsp.getBody());
            logger.info("search# 关键词:{},页面:{} result is null",jsonObject.toString());
            JSONObject result_list = jsonObject.getJSONObject("tbk_dg_material_optional_response");
            LinkedList<Material> materials =  new LinkedList<>();
            if (result_list == null) {
                logger.info("search# 关键词:{},页面:{} result is null",tbkDgMaterialOptionalRequest.getQ().toString());
            }

            JSONObject map_data = result_list.getJSONObject("result_list");
            JSONArray infos = map_data.getJSONArray("map_data");
            for (int i=0;i< infos.size();i++) {
                Material material = new Material();
                JSONObject info = infos.getJSONObject(i);
                material.setCategory_id((int) info.get("category_id"));
                material.setCategory_name((String) info.get("category_name"));
                material.setCommission_rate((String) info.get("commission_rate"));
                material.setCommission_type((String) info.get("commission_type"));
                material.setCoupon_amount((String) info.get("coupon_amount"));
                material.setCoupon_end_time((String) info.get("coupon_end_time"));
                material.setCoupon_id((String) info.get("coupon_id"));
                material.setCoupon_info((String) info.get("coupon_info"));
                material.setCoupon_remain_count((Integer) info.get("coupon_remain_count"));
                material.setCoupon_share_url((String) info.get("coupon_share_url"));
                material.setCoupon_start_fee((String) info.get("coupon_start_fee"));
                material.setCoupon_start_time((String) info.get("coupon_start_time"));
                material.setCoupon_total_count((Integer) info.get("coupon_total_count"));
                material.setInclude_dxjh((String) info.get("include_dxjh"));
                material.setInclude_mkt((String) info.get("include_mkt"));
                material.setItem_description((String) info.get("item_description"));
                material.setItem_id((Long) info.get("item_id"));
                material.setItem_url((String) info.get("item_url"));
                material.setLevel_one_category_id((Integer) info.get("level_one_category_id"));
                material.setLevel_one_category_name((String) info.get("level_one_category_name"));
                material.setNick((String) info.get("nick"));
                material.setNum_iid((Long) info.get("num_iid"));
                material.setPict_url((String) info.get("pict_url"));
                material.setPresale_deposit((String) info.get("presale_deposit"));
                material.setPresale_end_time((Integer) (info.get("presale_end_time") instanceof Long ? ((Long) info.get("presale_end_time")).intValue() : info.get("presale_end_time")));
                material.setPresale_start_time((Integer) (info.get("presale_start_time") instanceof Long ? ((Long) info.get("presale_start_time")).intValue() : info.get("presale_start_time")));
                material.setPresale_tail_end_time((Integer) (info.get("presale_tail_end_time") instanceof Long ? ((Long) info.get("presale_tail_end_time")).intValue() : info.get("presale_tail_end_time")));
                material.setPresale_tail_start_time((Integer) (info.get("presale_tail_start_time") instanceof Long ? ((Long) info.get("presale_tail_start_time")).intValue() : info.get("presale_tail_start_time")));
                material.setProvcity((String) info.get("provcity"));
                material.setReal_post_fee((String) info.get("real_post_fee"));
                material.setReserve_price((String) info.get("reserve_price"));
                material.setSeller_id(info.getString("seller_id"));
                material.setShop_dsr((Integer) info.get("shop_dsr"));
                material.setShop_title((String) info.get("shop_title"));
                material.setShort_title((String) info.get("short_title"));
                material.setSmall_images(info.containsKey("small_images") ? (JSONObject) info.get("small_images") : JSONObject.parseObject("{}"));
                material.setTitle((String) info.get("title"));
                material.setTk_total_commi((String) info.get("tk_total_commi"));
                material.setTk_total_sales((String) info.get("tk_total_sales"));
                material.setUrl((String) info.get("url"));
                material.setUser_type((Integer) info.get("user_type"));
                material.setVolume((Integer) info.get("volume"));
                material.setWhite_image((String) info.get("white_image"));
                material.setX_id((String) info.get("x_id"));
                material.setZk_final_price((String) info.get("zk_final_price"));
                materials.add(material);
            }
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return "hello";
    }
}
