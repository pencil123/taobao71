package com.taobao71.tb71.Service.tk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.request.TbkTpwdCreateRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao.api.response.TbkItemInfoGetResponse;
import com.taobao.api.response.TbkTpwdCreateResponse;
import com.taobao71.tb71.Service.CouponServer;
import com.taobao71.tb71.Service.ItemServer;
import com.taobao71.tb71.Service.ItemWithoutCouponServer;
import com.taobao71.tb71.Service.ShopServer;
import com.taobao71.tb71.model.domain.Coupon;
import com.taobao71.tb71.model.domain.Item;
import com.taobao71.tb71.model.domain.ItemWithoutCoupon;
import com.taobao71.tb71.model.domain.Shop;
import com.taobao71.tb71.model.vo.Tpwd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TaobaoClientServer {

  @Value("${taobao.appkey}")
  private String appkey;
  @Value("${taobao.secret}")
  private String secret;
  @Value("${taobao.url}")
  private String url;
  @Value("${taobao.AdzoneID}")
  private Long adzoneid;

  @Autowired
  private ShopServer shopServer;
  @Autowired
  private ItemServer itemServer;
  @Autowired
  private CouponServer couponServer;
  @Autowired
  private ItemWithoutCoupon itemWithoutCoupon;
  @Autowired
  private ItemWithoutCouponServer itemWithoutCouponServer;

  private TaobaoClient taobaoClient;
  private int total_count = 0;

  static Logger logger = LoggerFactory.getLogger(TaobaoClientServer.class);

  @Autowired
  public void setTaobaoClient() {
    this.taobaoClient = new DefaultTaobaoClient(url, appkey, secret);
  }

  /**
   * 生成淘口令
   */
  public Tpwd gainTpwd(String targetUrl) {
    TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
    //req.setUserId("123");
    req.setText("恭喜发财");
    req.setUrl(targetUrl);
    //req.setLogo("https://uland.taobao.com/");
    //req.setExt("{}");
    try {
      TbkTpwdCreateResponse rsp = taobaoClient.execute(req);
      System.out.println(rsp.getBody());
      logger.info("gain淘口令响应:{}", rsp.getBody());
      JSONObject jsonObject = JSONObject.parseObject(rsp.getBody());
      JSONObject tpwdJsonObject = jsonObject.getJSONObject("tbk_tpwd_create_response")
          .getJSONObject("data");
      Tpwd tpwd = JSON.parseObject(tpwdJsonObject.toJSONString(), Tpwd.class);
      return tpwd;
    } catch (ApiException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * 解析接口返回的数据，并解析，并写入到数据库
   */
  private void parseMaterialInfo(JSONArray infos, String searchId) {
    //查询接口处理
    for (int i = 0; i < infos.size(); i++) {
      QueryWrapper<Shop> shopWrapper = new QueryWrapper<>();
      QueryWrapper<Item> itemWrapper = new QueryWrapper<>();
      QueryWrapper<Coupon> couponWrapper = new QueryWrapper<>();

      JSONObject info = infos.getJSONObject(i);
      logger.info("items info:{}", info.getLong("num_iid"));

      //商店信息处理
      Shop shop = JSON.parseObject(info.toJSONString(), Shop.class);
      shopWrapper.eq("seller_id", shop.getSellerId());

      if (shopServer.getOne(shopWrapper) == null && !shopServer.save(shop)) {
        logger.warn("Shop 数据库插入失败");
      }

      //商品信息处理
      Item item = JSON.parseObject(info.toJSONString(), Item.class);
      itemWrapper.eq("item_id", item.getItemId());
      Item itemExist = itemServer.getOne(itemWrapper);
      if (itemServer.getOne(itemWrapper) == null && !itemServer.save(item)) {
        logger.warn("Item 数据库插入失败");
      }

      //优惠券处理
      Coupon coupon = JSON.parseObject(info.toJSONString(), Coupon.class);
      couponWrapper.eq("item_id", coupon.getItemId());
      if (couponServer.getOne(couponWrapper) == null && !coupon.getCouponId().equals("")) {
        if (!searchId.equals("")) {
          coupon.setSearchId(Long.valueOf(searchId));
        }
        couponServer.save(coupon);
      } else {
        logger.info("没有优惠券");
      }
    }
  }

  /**
   * 实际执行接口调用的函数，并将执行结果写入到数据库
   */
  private void searchMaterialAction(TbkDgMaterialOptionalRequest tbkDgMaterialOptionalRequest) {
    JSONObject result_list;
    JSONArray map_data;
    JSONObject tbk_dg_material_optional_response;
    try {
      // 执行调用接口
      TbkDgMaterialOptionalResponse rsp = taobaoClient.execute(tbkDgMaterialOptionalRequest);
      JSONObject jsonObject = JSONObject.parseObject(rsp.getBody());
      tbk_dg_material_optional_response = jsonObject
          .getJSONObject("tbk_dg_material_optional_response");
      logger.info("返回的信息：{}", tbk_dg_material_optional_response.toJSONString());
    } catch (ApiException e) {
      e.printStackTrace();
      return;
    }
    // 调用接口返回值的数量
    if (this.total_count == 0) {
      this.total_count = tbk_dg_material_optional_response.getIntValue("total_results");
    }
    // 处理返回的值为空的情况
    try {
      // 接口不稳定；有时候返回数据为空
      result_list = tbk_dg_material_optional_response.getJSONObject("result_list");
      map_data = result_list.getJSONArray("map_data");
    } catch (NullPointerException e) {
      logger.info("返回为空；变量i:{}");
      return;
    }
    parseMaterialInfo(map_data, "");
  }


  /**
   * 实际执行接口调用的函数，并将执行结果写入到数据库
   */
  private Integer searchMaterialAction(TbkDgMaterialOptionalRequest tbkDgMaterialOptionalRequest,
      String searchId) {
    JSONObject result_list;
    JSONArray map_data;
    JSONObject tbk_dg_material_optional_response;
    try {
      // 执行调用接口
      TbkDgMaterialOptionalResponse rsp = taobaoClient.execute(tbkDgMaterialOptionalRequest);
      JSONObject jsonObject = JSONObject.parseObject(rsp.getBody());
      tbk_dg_material_optional_response = jsonObject
          .getJSONObject("tbk_dg_material_optional_response");
    } catch (ApiException e) {
      e.printStackTrace();
      return 0;
    }
    // 调用接口返回值的数量
    if (this.total_count == 0) {
      this.total_count = tbk_dg_material_optional_response.getIntValue("total_results");
      this.total_count = this.total_count > 100 ? 100 : this.total_count;
      logger.info("同样的查询首次调用返回的匹配总量：{}", this.total_count);
    }
    // 处理返回的值为空的情况
    try {
      // 接口不稳定；有时候返回数据为空
      result_list = tbk_dg_material_optional_response.getJSONObject("result_list");
      map_data = result_list.getJSONArray("map_data");
    } catch (NullPointerException e) {
      logger.info("返回为空；变量i:{}");
      return 0;
    }
    parseMaterialInfo(map_data, searchId);
    return map_data.size();
  }

  /**
   * 物料搜索
   *
   * @param tbkDgMaterialOptionalRequest 请求对象
   */
  public String searchMaterial(TbkDgMaterialOptionalRequest tbkDgMaterialOptionalRequest) {
    // 调用接口请求参数设置
    tbkDgMaterialOptionalRequest.setAdzoneId(adzoneid);
    //tbkDgMaterialOptionalRequest.setSort("total_sales");
    // tbkDgMaterialOptionalRequest.setHasCoupon(true);
    tbkDgMaterialOptionalRequest.setPageSize(100L);
    int pageNo = 1;
    do {
      tbkDgMaterialOptionalRequest.setPageNo(Long.valueOf(pageNo));
      pageNo++;
      searchMaterialAction(tbkDgMaterialOptionalRequest);
      try {
        Thread.sleep(2000);    //延时2秒
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } while (pageNo < this.total_count / 100 + 1);
    return "Success";
  }

  /**
   * 物料搜索
   *
   * @param tbkDgMaterialOptionalRequest 请求对象
   * @return 调用接口获取的物料数量
   */
  public Integer searchMaterial(TbkDgMaterialOptionalRequest tbkDgMaterialOptionalRequest,
      String searchId) {
    // 调用接口请求参数设置
    tbkDgMaterialOptionalRequest.setAdzoneId(adzoneid);
    tbkDgMaterialOptionalRequest.setSort("total_sales");
    tbkDgMaterialOptionalRequest.setNeedFreeShipment(true);
    tbkDgMaterialOptionalRequest.setNeedPrepay(true);
    //tbkDgMaterialOptionalRequest.setHasCoupon(true);
    tbkDgMaterialOptionalRequest.setPageSize(100L);
    int pageNo = 1;
    int total_count = 0;
    do {
      tbkDgMaterialOptionalRequest.setPageNo(Long.valueOf(pageNo));
      pageNo++;
      total_count += searchMaterialAction(tbkDgMaterialOptionalRequest, searchId);
      logger.info("调用接口返回的数据量：{}", total_count);
      try {
        Thread.sleep(2000);    //延时2秒
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } while (pageNo < this.total_count / 100 + 1);
    return total_count;
  }

  /**
   * 根据ItemID 查询商品信息
   *
   * @return 获取商品失败返回null
   */
  public Item getItemInfo(TbkItemInfoGetRequest tbkItemInfoGetRequest) {
    try {
      TbkItemInfoGetResponse rsp = taobaoClient.execute(tbkItemInfoGetRequest);
      JSONObject jsonObject = JSONObject.parseObject(rsp.getBody());
      logger.info("输出信息：{}", jsonObject.toJSONString());
      JSONObject results = jsonObject.getJSONObject("tbk_item_info_get_response")
          .getJSONObject("results");
      JSONArray n_tbk_item = results.getJSONArray("n_tbk_item");
      if (n_tbk_item.size() == 1) {
        JSONObject itemJsonObject = n_tbk_item.getJSONObject(0);
//                itemJsonObject.put("category_name",itemJsonObject.getString("cat_leaf_name"));
//                itemJsonObject.put("level_one_category_name",itemJsonObject.getString("cat_name"));
//                itemJsonObject.put("item_id",itemJsonObject.getLongValue("num_iid"));

        Item item = JSON.parseObject(itemJsonObject.toJSONString(), Item.class);
        return itemServer.save(item) ? item : null;
      } else {
        logger.error("getIteminfo response size {};info: {}", n_tbk_item.size(),
            n_tbk_item.toJSONString());
        return null;
      }
    } catch (ApiException e) {
      e.printStackTrace();
      return null;
    } catch (NullPointerException e) {
      itemWithoutCoupon.setItemId(Long.valueOf(tbkItemInfoGetRequest.getNumIids()));
      itemWithoutCouponServer.save(itemWithoutCoupon);
      e.printStackTrace();
      return null;
    }
  }

  /**
   * 根据商品信息，搜索商品的Coupon
   *
   * @return true找到了，false 没找到
   */
  public Boolean gainItemsByItem(Item item) {
//        // 根据商品信息，搜索优惠券信息
    if (item != null) {
      TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();
      req.setQ(item.getTitle());
      req.setSellerIds(item.getSellerId().toString());
      //req.setCat(itemSearch.getCategory_name() + "," + itemSearch.getLevel_one_category_name());
      //req.setItemloc(itemSearch.getProvcity());
      req.setStartPrice(Double.valueOf(item.getZkFinalPrice()).longValue());
      req.setEndPrice(Double.valueOf(item.getZkFinalPrice()).longValue() + 1);
      logger.info("根据商品找优惠券;遍历了{}商品", searchMaterial(req));
    }
    String couoponUrl2 = couponServer.getCouponByItemId(item.getItemId().toString())
        .getCouponShareUrl();
    if (couoponUrl2 != null) {
      return true;
    }
    return false;
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
