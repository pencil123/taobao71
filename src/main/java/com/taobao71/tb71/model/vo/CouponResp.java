package com.taobao71.tb71.model.vo;

import org.springframework.stereotype.Component;
import lombok.Data;

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
@Data
public class CouponResp {
  private Long itemId;
  private String title;
  private String pictUrl;
  private String zkFinalPrice;
  private Integer couponTotalCount;
  private Integer couponRemainCount;
  private String couponInfo;
  private String couponStartFee;
  private String couponAmount;

  public Long getItemId() {
    return itemId;
  }

  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPictUrl() {
    return pictUrl;
  }

  public void setPictUrl(String pictUrl) {
    this.pictUrl = pictUrl;
  }

  public String getZkFinalPrice() {
    return zkFinalPrice;
  }

  public void setZkFinalPrice(String zkFinalPrice) {
    this.zkFinalPrice = zkFinalPrice;
  }

  public Integer getCouponTotalCount() {
    return couponTotalCount;
  }

  public void setCouponTotalCount(Integer couponTotalCount) {
    this.couponTotalCount = couponTotalCount;
  }

  public Integer getCouponRemainCount() {
    return couponRemainCount;
  }

  public void setCouponRemainCount(Integer couponRemainCount) {
    this.couponRemainCount = couponRemainCount;
  }

  public String getCouponInfo() {
    return couponInfo;
  }

  public void setCouponInfo(String couponInfo) {
    this.couponInfo = couponInfo;
  }

  public String getCouponStartFee() {
    return couponStartFee;
  }

  public void setCouponStartFee(String couponStartFee) {
    this.couponStartFee = couponStartFee;
  }

  public String getCouponAmount() {
    return couponAmount;
  }

  public void setCouponAmount(String couponAmount) {
    this.couponAmount = couponAmount;
  }
}
