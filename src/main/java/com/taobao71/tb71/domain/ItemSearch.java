package com.taobao71.tb71.domain;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

/**
 *num_iid ->item_id Number 商品ID
 * title String 商品标题
 * volume Number 30天销量
 * pict_url String 商品主图
 * provcity String 商品所在地
 * reserve_price String 商品一口价格
 * seller_id Number 卖家id
 * cat_leaf_name ->category_name String 叶子类目名称
 * cat_name -> level_one_category_name String 一级类目名称
 * free_shipment Boolean 是否包邮
 * item_url String 商品链接
 * ju_online_end_time String 聚划算信息-聚淘结束时间（毫秒）
 * ju_online_start_time String 聚划算信息-聚淘开始时间（毫秒）
 * ju_pre_show_end_time String 聚划算信息-商品预热结束时间（毫秒）
 * ju_pre_show_start_time String 聚划算信息-商品预热开始时间（毫秒）
 * material_lib_type String 商品库类型，支持多库类型输出，以英文逗号分隔“,”分隔，1:营销商品主推库，如果值为空则不属于1这种商品类型
 * presale_deposit String 预售商品-定金（元）
 * presale_end_time Number 预售商品-付定金结束时间（毫秒）
 * presale_start_time Number 预售商品-付定金开始时间（毫秒）
 * presale_tail_end_time Number  预售商品-付定金结束时间（毫秒）
 * presale_tail_start_time Number 预售商品-付尾款开始时间（毫秒）
 * small_images String[] 商品小图列表
 * superior_brand String 是否品牌精选，0不是，1是
 * tmall_play_activity_end_time Number 天猫限时抢可售 -结束时间（毫秒）
 * tmall_play_activity_start_time Number 天猫限时抢可售 -开始时间（毫秒）
 * user_type Number 卖家类型，0表示集市，1表示商城
 * zk_final_price String 折扣价（元） 若属于预售商品，付定金时间内，折扣价=预售价
 * ############################################
 * is_prepay Boolean 是否加入消费者保障
 * shop_dsr Number 店铺dsr 评分
 * ratesum Number 卖家等级
 * i_rfd_rate Boolean 退款率是否低于行业均值
 * h_good_rate Boolean 好评率是否高于行业均值
 * h_pay_rate30 Boolean 成交转化是否高于行业均值
 * presale_discount_fee_text String 预售商品-商品优惠信息
 * ju_play_end_time Number 聚划算满减 -结束时间（毫秒）
 * ju_play_start_time Number 聚划算满减 -开始时间（毫秒）
 * play_info String  1聚划算满减：满N件减X元，满N件X折，满N件X元） 2天猫限时抢：前N分钟每件X元，前N分钟满N件每件X元，前N件每件X元）
 * sale_price String 活动价
 * kuadian_promotion_info String 跨店满减信息
 */

@Component
public class ItemSearch {
    private Integer id;
    private Long item_id;
    private String title;
    private Integer volume;
    private String pict_url;
    private String provcity;
    private String reserve_price;
    private Long seller_id;
    private String category_name;
    private String level_one_category_name;
    private Boolean free_shipment;
    private String item_url;
    private String presale_deposit;
    private JSONObject small_images;
    private String superior_brand;
    private Integer user_type;
    private String zk_final_price;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getPict_url() {
        return pict_url;
    }

    public void setPict_url(String pict_url) {
        this.pict_url = pict_url;
    }

    public String getProvcity() {
        return provcity;
    }

    public void setProvcity(String provcity) {
        this.provcity = provcity;
    }

    public String getReserve_price() {
        return reserve_price;
    }

    public void setReserve_price(String reserve_price) {
        this.reserve_price = reserve_price;
    }

    public Long getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Long seller_id) {
        this.seller_id = seller_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getLevel_one_category_name() {
        return level_one_category_name;
    }

    public void setLevel_one_category_name(String level_one_category_name) {
        this.level_one_category_name = level_one_category_name;
    }

    public Boolean getFree_shipment() {
        return free_shipment;
    }

    public void setFree_shipment(Boolean free_shipment) {
        this.free_shipment = free_shipment;
    }

    public String getItem_url() {
        return item_url;
    }

    public void setItem_url(String item_url) {
        this.item_url = item_url;
    }

    public String getPresale_deposit() {
        return presale_deposit;
    }

    public void setPresale_deposit(String presale_deposit) {
        this.presale_deposit = presale_deposit;
    }

    public JSONObject getSmall_images() {
        return small_images;
    }

    public void setSmall_images(JSONObject small_images) {
        this.small_images = small_images;
    }

    public String getSuperior_brand() {
        return superior_brand;
    }

    public void setSuperior_brand(String superior_brand) {
        this.superior_brand = superior_brand;
    }

    public Integer getUser_type() {
        return user_type;
    }

    public void setUser_type(Integer user_type) {
        this.user_type = user_type;
    }

    public String getZk_final_price() {
        return zk_final_price;
    }

    public void setZk_final_price(String zk_final_price) {
        this.zk_final_price = zk_final_price;
    }
}
