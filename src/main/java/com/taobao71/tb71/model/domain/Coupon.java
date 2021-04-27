package com.taobao71.tb71.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 * 物料信息类 coupon_id	String	d62db1ab8d9546b1bf0ff49bda5fc33b	优惠券信息-优惠券id
 * coupon_info	String	满299元减20元	优惠券信息-优惠券满减信息 coupon_amount	String	10.00	优惠券（元）
 * 若属于预售商品，该优惠券付尾款可用，付定金不可用 coupon_start_time	String	2017-10-29	优惠券信息-优惠券开始时间
 * coupon_end_time	String	2017-10-29	优惠券信息-优惠券结束时间 coupon_start_fee	String	29.00	优惠券信息-优惠券起用门槛，满X元可用。如：满299元减20元
 * coupon_total_count	Number	22323	优惠券信息-优惠券总量 coupon_remain_count	Number	111	优惠券信息-优惠券剩余量
 * coupon_share_url	String	uland.xxx	链接-宝贝+券二合一页面链接 zk_final_price	String	88.00	折扣价（元）
 * 若属于预售商品，付定金时间内，折扣价=预售价 tk_total_sales	String	11	商品信息-淘客30天推广量 tk_total_commi	String	323	商品信息-月支出佣金(该字段废弃，请勿再用)
 * reserve_price	String	102.00	商品信息-商品一口价格
 *
 * short_title	String	xxsd	商品信息-商品短标题 title	String	毛呢阔腿裤港味复古女裤子秋冬九分裤萝卜裤显瘦高腰韩版2017新款	商品信息-商品标题
 * item_description	String	季凉被 全棉亲肤	商品信息-宝贝描述(推荐理由)
 *
 *
 * item_url	String	https://item.taobao.com/item.htm?id=564591813536	链接-宝贝地址
 *
 * volume	Number	123	商品信息-30天销量 category_name	String	连衣裙	商品信息-叶子类目名称
 * category_id	Number	162201	商品信息-叶子类目id level_one_category_name	String	女装	商品信息-一级类目名称
 * level_one_category_id	Number	20	商品信息-一级类目ID
 */

@Component
public class Coupon implements Serializable {

  @TableId(type = IdType.AUTO)
  private Integer id;
  private Long itemId;
  private String couponId;
  private String couponInfo;
  private String couponAmount;
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date couponStartTime;
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date couponEndTime;
  private String couponStartFee;
  private Integer couponTotalCount;
  private Integer couponRemainCount;
  private String couponShareUrl;
  private String zkFinalPrice;
  private String tkTotalCommi;
  private String tkTotalSales;
  private String reservePrice;

  private String shortTitle;
  private String title;
  private String itemUrl;
  private String itemDescription;
  private String pictUrl;
  private String whiteImage;
  private String smallImages;

  private Integer volume;
  private String provcity;
  private Integer categoryId;
  private String categoryName;
  private Integer levelOneCategoryId;
  private String levelOneCategoryName;

  private Long searchId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Long getItemId() {
    return itemId;
  }

  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }

  public String getCouponInfo() {
    return couponInfo;
  }

  public void setCouponInfo(String couponInfo) {
    this.couponInfo = couponInfo;
  }

  public String getCouponId() {
    return couponId;
  }

  public void setCouponId(String couponId) {
    this.couponId = couponId;
  }

  public String getCouponAmount() {
    return couponAmount;
  }

  public void setCouponAmount(String couponAmount) {
    this.couponAmount = couponAmount;
  }

  public Date getCouponStartTime() {
    return couponStartTime;
  }

  public void setCouponStartTime(Date couponStartTime) {
    this.couponStartTime = couponStartTime;
  }

  public Date getCouponEndTime() {
    return couponEndTime;
  }

  public void setCouponEndTime(Date couponEndTime) {
    this.couponEndTime = couponEndTime;
  }

  public String getCouponStartFee() {
    return couponStartFee;
  }

  public void setCouponStartFee(String couponStartFee) {
    this.couponStartFee = couponStartFee;
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

  public String getCouponShareUrl() {
    return couponShareUrl;
  }

  public void setCouponShareUrl(String couponShareUrl) {
    this.couponShareUrl = couponShareUrl;
  }

  public String getZkFinalPrice() {
    return zkFinalPrice;
  }

  public void setZkFinalPrice(String zkFinalPrice) {
    this.zkFinalPrice = zkFinalPrice;
  }

  public String getTkTotalCommi() {
    return tkTotalCommi;
  }

  public void setTkTotalCommi(String tkTotalCommi) {
    this.tkTotalCommi = tkTotalCommi;
  }

  public String getTkTotalSales() {
    return tkTotalSales;
  }

  public void setTkTotalSales(String tkTotalSales) {
    this.tkTotalSales = tkTotalSales;
  }

  public String getReservePrice() {
    return reservePrice;
  }

  public void setReservePrice(String reservePrice) {
    this.reservePrice = reservePrice;
  }

  public String getShortTitle() {
    return shortTitle;
  }

  public void setShortTitle(String shortTitle) {
    this.shortTitle = shortTitle;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getItemUrl() {
    return itemUrl;
  }

  public void setItemUrl(String itemUrl) {
    this.itemUrl = itemUrl;
  }

  public String getItemDescription() {
    return itemDescription;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }

  public String getPictUrl() {
    return pictUrl;
  }

  public void setPictUrl(String pictUrl) {
    this.pictUrl = pictUrl;
  }

  public String getWhiteImage() {
    return whiteImage;
  }

  public void setWhiteImage(String whiteImage) {
    this.whiteImage = whiteImage;
  }

  public String getSmallImages() {
    return smallImages;
  }

  public void setSmallImages(String smallImages) {
    this.smallImages = smallImages;
  }

  public Integer getVolume() {
    return volume;
  }

  public void setVolume(Integer volume) {
    this.volume = volume;
  }

  public String getProvcity() {
    return provcity;
  }

  public void setProvcity(String provcity) {
    this.provcity = provcity;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public Integer getLevelOneCategoryId() {
    return levelOneCategoryId;
  }

  public void setLevelOneCategoryId(Integer levelOneCategoryId) {
    this.levelOneCategoryId = levelOneCategoryId;
  }

  public String getLevelOneCategoryName() {
    return levelOneCategoryName;
  }

  public void setLevelOneCategoryName(String levelOneCategoryName) {
    this.levelOneCategoryName = levelOneCategoryName;
  }

  public Long getSearchId() {
    return searchId;
  }

  public void setSearchId(Long searchId) {
    this.searchId = searchId;
  }
}
