package com.taobao71.tb71.domain;

import com.alibaba.fastjson.JSONObject;
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
    private Integer id;
    private Long item_id;
    private String commission_type;
    private String coupon_amount;
    private String coupon_end_time;
    private String coupon_id;
    private String coupon_info;
    private Integer coupon_remain_count;
    private String coupon_share_url;
    private String zk_final_price;
    private String coupon_start_fee;
    private String coupon_start_time;
    private String commission_rate;
    private Integer coupon_total_count;
    private String tk_total_commi;
    private String tk_total_sales;
    private String title;
    private String pict_url;
    private String search_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public String getCommission_type() {
        return commission_type;
    }

    public void setCommission_type(String commission_type) {
        this.commission_type = commission_type;
    }

    public String getCoupon_amount() {
        return coupon_amount;
    }

    public void setCoupon_amount(String coupon_amount) {
        this.coupon_amount = coupon_amount;
    }

    public String getCoupon_end_time() {
        return coupon_end_time;
    }

    public void setCoupon_end_time(String coupon_end_time) {
        this.coupon_end_time = coupon_end_time;
    }

    public String getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(String coupon_id) {
        this.coupon_id = coupon_id;
    }

    public String getCoupon_info() {
        return coupon_info;
    }

    public void setCoupon_info(String coupon_info) {
        this.coupon_info = coupon_info;
    }

    public Integer getCoupon_remain_count() {
        return coupon_remain_count;
    }

    public void setCoupon_remain_count(Integer coupon_remain_count) {
        this.coupon_remain_count = coupon_remain_count;
    }

    public String getCoupon_share_url() {
        return coupon_share_url;
    }

    public void setCoupon_share_url(String coupon_share_url) {
        this.coupon_share_url = coupon_share_url;
    }

    public String getCoupon_start_fee() {
        return coupon_start_fee;
    }

    public void setCoupon_start_fee(String coupon_start_fee) {
        this.coupon_start_fee = coupon_start_fee;
    }

    public String getCoupon_start_time() {
        return coupon_start_time;
    }

    public void setCoupon_start_time(String coupon_start_time) {
        this.coupon_start_time = coupon_start_time;
    }

    public Integer getCoupon_total_count() {
        return coupon_total_count;
    }

    public void setCoupon_total_count(Integer coupon_total_count) {
        this.coupon_total_count = coupon_total_count;
    }

    public String getTk_total_commi() {
        return tk_total_commi;
    }

    public void setTk_total_commi(String tk_total_commi) {
        this.tk_total_commi = tk_total_commi;
    }

    public String getTk_total_sales() {
        return tk_total_sales;
    }

    public void setTk_total_sales(String tk_total_sales) {
        this.tk_total_sales = tk_total_sales;
    }

    public String getCommission_rate() {
        return commission_rate;
    }

    public void setCommission_rate(String commission_rate) {
        this.commission_rate = commission_rate;
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

    public String getSearch_id() {
        return search_id;
    }

    public void setSearch_id(String search_id) {
        this.search_id = search_id;
    }
}
