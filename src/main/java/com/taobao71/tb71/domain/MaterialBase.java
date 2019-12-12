package com.taobao71.tb71.domain;

import com.alibaba.fastjson.JSONObject;

/**
 * @author lyzhang
 * @since 2019/12/12 17:00
 */
public class MaterialBase{

  private Integer id;
  private Integer category_id;
  private Integer my_category_id;
  private String category_name;
  private String commission_rate;
  private String commission_type;
  private String coupon_amount;
  private String coupon_end_time;
  private String coupon_id;
  private String coupon_info;
  private Integer coupon_remain_count;
  private String coupon_share_url;
  private String coupon_start_fee;
  private String coupon_start_time;
  private Integer coupon_total_count;
  private String include_dxjh;
  private String include_mkt;
  private JSONObject info_dxjh;
  private String item_description;
  private Long item_id;
  private String item_url;
  private Integer level_one_category_id;
  private String level_one_category_name;
  private String nick;
  private Long num_iid;
  private String pict_url;
  private String presale_deposit;
  private Integer presale_end_time;
  private Integer presale_start_time;
  private Integer presale_tail_end_time;
  private Integer presale_tail_start_time;
  private String provcity;
  private String real_post_fee;
  private String reserve_price;
  private String seller_id;
  private Integer shop_dsr;
  private String shop_title;
  private String short_title;
  private JSONObject small_images;
  private String title;
  private String tk_total_commi;
  private String tk_total_sales;
  private String url;
  private Integer user_type;
  private Integer volume;
  private String white_image;
  private String x_id;
  private String zk_final_price;

  public Integer getId() {return id;  }
  public void setId(Integer id) {this.id = id; }
  public Integer getCategory_id() {
    return category_id;
  }

  public void setCategory_id(Integer category_id) {
    this.category_id = category_id;
  }

  public Integer getMy_category_id() {return my_category_id;  }

  public void setMy_category_id(Integer my_category_id) {this.my_category_id = my_category_id;  }

  public String getCategory_name() {
    return category_name;
  }

  public void setCategory_name(String category_name) {
    this.category_name = category_name;
  }

  public String getCommission_rate() {
    return commission_rate;
  }

  public void setCommission_rate(String commission_rate) {
    this.commission_rate = commission_rate;
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

  public String getInclude_dxjh() {
    return include_dxjh;
  }

  public void setInclude_dxjh(String include_dxjh) {
    this.include_dxjh = include_dxjh;
  }

  public String getInclude_mkt() {
    return include_mkt;
  }

  public void setInclude_mkt(String include_mkt) {
    this.include_mkt = include_mkt;
  }

  public JSONObject getInfo_dxjh() {
    return info_dxjh;
  }

  public void setInfo_dxjh(JSONObject info_dxjh) {
    this.info_dxjh = info_dxjh;
  }

  public String getItem_description() {
    return item_description;
  }

  public void setItem_description(String item_description) {
    this.item_description = item_description;
  }

  public Long getItem_id() {
    return item_id;
  }

  public void setItem_id(Long item_id) {
    this.item_id = item_id;
  }

  public String getItem_url() {
    return item_url;
  }

  public void setItem_url(String item_url) {
    this.item_url = item_url;
  }

  public Integer getLevel_one_category_id() {
    return level_one_category_id;
  }

  public void setLevel_one_category_id(Integer level_one_category_id) {
    this.level_one_category_id = level_one_category_id;
  }

  public String getLevel_one_category_name() {
    return level_one_category_name;
  }

  public void setLevel_one_category_name(String level_one_category_name) {
    this.level_one_category_name = level_one_category_name;
  }

  public String getNick() {
    return nick;
  }

  public void setNick(String nick) {
    this.nick = nick;
  }

  public Long getNum_iid() {
    return num_iid;
  }

  public void setNum_iid(Long num_iid) {
    this.num_iid = num_iid;
  }

  public String getPict_url() {
    return pict_url;
  }

  public void setPict_url(String pict_url) {
    this.pict_url = pict_url;
  }

  public String getPresale_deposit() {
    return presale_deposit;
  }

  public void setPresale_deposit(String presale_deposit) {
    this.presale_deposit = presale_deposit;
  }

  public Integer getPresale_end_time() {
    return presale_end_time;
  }

  public void setPresale_end_time(Integer presale_end_time) {
    this.presale_end_time = presale_end_time;
  }

  public Integer getPresale_start_time() {
    return presale_start_time;
  }

  public void setPresale_start_time(Integer presale_start_time) {
    this.presale_start_time = presale_start_time;
  }

  public Integer getPresale_tail_end_time() {
    return presale_tail_end_time;
  }

  public void setPresale_tail_end_time(Integer presale_tail_end_time) {
    this.presale_tail_end_time = presale_tail_end_time;
  }

  public Integer getPresale_tail_start_time() {
    return presale_tail_start_time;
  }

  public void setPresale_tail_start_time(Integer presale_tail_start_time) {
    this.presale_tail_start_time = presale_tail_start_time;
  }

  public String getProvcity() {
    return provcity;
  }

  public void setProvcity(String provcity) {
    this.provcity = provcity;
  }

  public String getReal_post_fee() {
    return real_post_fee;
  }

  public void setReal_post_fee(String real_post_fee) {
    this.real_post_fee = real_post_fee;
  }

  public String getReserve_price() {
    return reserve_price;
  }

  public void setReserve_price(String reserve_price) {
    this.reserve_price = reserve_price;
  }

  public String getSeller_id() {
    return seller_id;
  }

  public void setSeller_id(String seller_id) {
    this.seller_id = seller_id;
  }

  public Integer getShop_dsr() {
    return shop_dsr;
  }

  public void setShop_dsr(Integer shop_dsr) {
    this.shop_dsr = shop_dsr;
  }

  public String getShop_title() {
    return shop_title;
  }

  public void setShop_title(String shop_title) {
    this.shop_title = shop_title;
  }

  public String getShort_title() {
    return short_title;
  }

  public void setShort_title(String short_title) {
    this.short_title = short_title;
  }

  public String getSmall_images() {
    return small_images.toJSONString();
  }

  public void setSmall_images(JSONObject small_images) {
    this.small_images = small_images;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Integer getUser_type() {
    return user_type;
  }

  public void setUser_type(Integer user_type) {
    this.user_type = user_type;
  }

  public Integer getVolume() {
    return volume;
  }

  public void setVolume(Integer volume) {
    this.volume = volume;
  }

  public String getWhite_image() {
    return white_image;
  }

  public void setWhite_image(String white_image) {
    this.white_image = white_image;
  }

  public String getX_id() {
    return x_id;
  }

  public void setX_id(String x_id) {
    this.x_id = x_id;
  }

  public String getZk_final_price() {
    return zk_final_price;
  }

  public void setZk_final_price(String zk_final_price) {
    this.zk_final_price = zk_final_price;
  }


}
