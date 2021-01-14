package com.taobao71.tb71.domain;

import org.springframework.stereotype.Component;

/**
 * 物料影响信息
 * 不在数据库中创建对应的表
 * item_id	Number	556633720749	商品信息-宝贝id(该字段废弃，请勿再用)
 * title	String	毛呢阔腿裤港味复古女裤子秋冬九分裤萝卜裤显瘦高腰韩版2017新款	商品信息-商品标题
 * pict_url	String	https://img.alicdn.com/bao/uploaded/i4/745957850/TB1WzSRmV9gSKJjSspbXXbeNXXa_!!0-item_pic.jpg	商品信息-商品主图
 * zk_final_price	String	88.00	折扣价（元） 若属于预售商品，付定金时间内，折扣价=预售价
 *---------------------
 * coupon_total_count	Number	22323	优惠券信息-优惠券总量
 * coupon_remain_count	Number	111	优惠券信息-优惠券剩余量
 * coupon_info	String	满299元减20元	优惠券信息-优惠券满减信息
 * coupon_start_fee	String	29.00	优惠券信息-优惠券起用门槛，满X元可用。如：满299元减20元
 * coupon_amount	String	10.00	优惠券（元） 若属于预售商品，该优惠券付尾款可用，付定金不可用
 */
@Component
public class ItemResp {
  private Long item_id;
  private String title;
  private String pict_url;
  private String zk_final_price;

  private Integer coupon_total_count;
  private Integer coupon_remain_count;
  private String coupon_info;
  private String coupon_start_fee;
  private String coupon_amount;

  public Long getItem_id() {
    return item_id;
  }

  public void setItem_id(Long item_id) {
    this.item_id = item_id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPict_url() {
    return pict_url;
  }

  public void setPict_url(String pict_url) {
    this.pict_url = pict_url;
  }

  public String getZk_final_price() {
    return zk_final_price;
  }

  public void setZk_final_price(String zk_final_price) {
    this.zk_final_price = zk_final_price;
  }

  public Integer getCoupon_total_count() {
    return coupon_total_count;
  }

  public void setCoupon_total_count(Integer coupon_total_count) {
    this.coupon_total_count = coupon_total_count;
  }

  public Integer getCoupon_remain_count() {
    return coupon_remain_count;
  }

  public void setCoupon_remain_count(Integer coupon_remain_count) {
    this.coupon_remain_count = coupon_remain_count;
  }

  public String getCoupon_info() {
    return coupon_info;
  }

  public void setCoupon_info(String coupon_info) {
    this.coupon_info = coupon_info;
  }

  public String getCoupon_start_fee() {
    return coupon_start_fee;
  }

  public void setCoupon_start_fee(String coupon_start_fee) {
    this.coupon_start_fee = coupon_start_fee;
  }

  public String getCoupon_amount() {
    return coupon_amount;
  }

  public void setCoupon_amount(String coupon_amount) {
    this.coupon_amount = coupon_amount;
  }
}
