package com.taobao71.tb71.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 物料信息类
 * coupon_start_time	String	2017-10-29	优惠券信息-优惠券开始时间
 * coupon_end_time	String	2017-10-29	优惠券信息-优惠券结束时间
 * info_dxjh	Json	{"19013551":"2850","74510538":"2550"}	商品信息-定向计划信息
 * coupon_id	String	d62db1ab8d9546b1bf0ff49bda5fc33b	优惠券信息-优惠券id
 * coupon_total_count	Number	22323	优惠券信息-优惠券总量
 * coupon_remain_count	Number	111	优惠券信息-优惠券剩余量
 * coupon_info	String	满299元减20元	优惠券信息-优惠券满减信息
 * commission_type	String	MKT表示营销计划，SP表示定向计划，COMMON表示通用计划	商品信息-佣金类型。MKT表示营销计划，SP表示定向计划，COMMON表示通用计划
 * coupon_share_url	String	uland.xxx	链接-宝贝+券二合一页面链接
 * coupon_start_fee	String	29.00	优惠券信息-优惠券起用门槛，满X元可用。如：满299元减20元
 * coupon_amount	String	10.00	优惠券（元） 若属于预售商品，该优惠券付尾款可用，付定金不可用
 * tk_total_sales	String	11	商品信息-淘客30天推广量
 * tk_total_commi	String	323	商品信息-月支出佣金(该字段废弃，请勿再用)
 */

@Component
public class Coupon  implements Serializable {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private Long itemId;
    private String commissionType;
    private String couponAmount;
    private String couponEndTime;
    private String couponId;
    private String couponInfo;
    private Integer couponRemainCount;
    private String couponShareUrl;
    private String zkFinalPrice;
    private String couponStartFee;
    private String couponStartTime;
    private String commissionRate;
    private Integer couponTotalCount;
    private String tkTotalCommi;
    private String tkTotalSales;
    private String title;
    private String pictUrl;
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

    public String getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(String commissionType) {
        this.commissionType = commissionType;
    }

    public String getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(String couponAmount) {
        this.couponAmount = couponAmount;
    }

    public String getCouponEndTime() {
        return couponEndTime;
    }

    public void setCouponEndTime(String couponEndTime) {
        this.couponEndTime = couponEndTime;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponInfo() {
        return couponInfo;
    }

    public void setCouponInfo(String couponInfo) {
        this.couponInfo = couponInfo;
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

    public String getCouponStartFee() {
        return couponStartFee;
    }

    public void setCouponStartFee(String couponStartFee) {
        this.couponStartFee = couponStartFee;
    }

    public String getCouponStartTime() {
        return couponStartTime;
    }

    public void setCouponStartTime(String couponStartTime) {
        this.couponStartTime = couponStartTime;
    }

    public String getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(String commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Integer getCouponTotalCount() {
        return couponTotalCount;
    }

    public void setCouponTotalCount(Integer couponTotalCount) {
        this.couponTotalCount = couponTotalCount;
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

    public Long getSearchId() {
        return searchId;
    }

    public void setSearchId(Long searchId) {
        this.searchId = searchId;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", commissionType='" + commissionType + '\'' +
                ", couponAmount='" + couponAmount + '\'' +
                ", couponEndTime='" + couponEndTime + '\'' +
                ", couponId='" + couponId + '\'' +
                ", couponInfo='" + couponInfo + '\'' +
                ", couponRemainCount=" + couponRemainCount +
                ", couponShareUrl='" + couponShareUrl + '\'' +
                ", zkFinalPrice='" + zkFinalPrice + '\'' +
                ", couponStartFee='" + couponStartFee + '\'' +
                ", couponStartTime='" + couponStartTime + '\'' +
                ", commissionRate='" + commissionRate + '\'' +
                ", couponTotalCount=" + couponTotalCount +
                ", tkTotalCommi='" + tkTotalCommi + '\'' +
                ", tkTotalSales='" + tkTotalSales + '\'' +
                ", title='" + title + '\'' +
                ", pictUrl='" + pictUrl + '\'' +
                ", searchId=" + searchId +
                '}';
    }
}
