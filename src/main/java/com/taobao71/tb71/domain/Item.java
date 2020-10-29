package com.taobao71.tb71.domain;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

/**
 * num_iid	Number	556633720749	商品信息-宝贝id(该字段废弃，请勿再用)
 * title	String	毛呢阔腿裤港味复古女裤子秋冬九分裤萝卜裤显瘦高腰韩版2017新款	商品信息-商品标题
 * pict_url	String	https://img.alicdn.com/bao/uploaded/i4/745957850/TB1WzSRmV9gSKJjSspbXXbeNXXa_!!0-item_pic.jpg	商品信息-商品主图
 * small_images	String[]	https://img.alicdn.com/i4/3077291146/TB2NA3poDnI8KJjSszgXXc8ApXa_!!3077291146.jpg	商品信息-商品小图列表
 * reserve_price	String	102.00	商品信息-商品一口价格
 * zk_final_price	String	88.00	折扣价（元） 若属于预售商品，付定金时间内，折扣价=预售价
 * item_url	String	https://item.taobao.com/item.htm?id=564591813536	链接-宝贝地址
 * include_mkt	String	false	商品信息-是否包含营销计划
 * include_dxjh	String	false	商品信息-是否包含定向计划
 * commission_rate	String	1550表示15.5%	商品信息-佣金比率。1550表示15.5%
 * volume	Number	123	商品信息-30天销量
 * url	String	s.click.xxx	链接-宝贝推广链接
 * level_one_category_name	String	女装	商品信息-一级类目名称
 * level_one_category_id	Number	20	商品信息-一级类目ID
 * category_name	String	连衣裙	商品信息-叶子类目名称
 * category_id	Number	162201	商品信息-叶子类目id
 * short_title	String	xxsd	商品信息-商品短标题
 * white_image	String	https://img.alicdn.com/bao/uploaded/i4/745957850/TB1WzSRmV9gSKJjSspbXXbeNXXa_!!0-item_pic.jpg	商品信息-商品白底图
 * item_description	String	季凉被 全棉亲肤	商品信息-宝贝描述(推荐理由)
 * tmall_play_activity_info	String	前n件x折	营销-天猫营销玩法
 * item_id	Number	5678899993	商品信息-宝贝id
 * real_post_fee	String	0.00	商品邮费
 * provcity	String	杭州	商品信息-宝贝所在地
 * x_id	String	uESS0mv8JvfJRMKlIgCD5At9VuHVBXoqBRihfQlo4ybLiKygRlqiN4eoxoZDfe38uSogWy6GB971jD2N8tLuuc	链接-物料块id(测试中请勿使用)
 */
@Component
public class Item {
    private Integer id;
    private Integer shop_id;
    private String x_id;
    private Long item_id;
    private String item_url;
    private String item_description;
    private Integer category_id;
    private String category_name;
    private String commission_rate;
    private String tmall_play_activity_info;
    private String provcity;
    private String include_dxjh;
    private String include_mkt;
    private Integer level_one_category_id;
    private String level_one_category_name;
    private String pict_url;
    private String real_post_fee;
    private String reserve_price;
    private String short_title;
    private JSONObject small_images;
    private String title;
    private String url;
    private Integer volume;
    private String white_image;
    private String info_dxjh;
    private String zk_final_price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public String getX_id() {
        return x_id;
    }

    public void setX_id(String x_id) {
        this.x_id = x_id;
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

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

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

    public String getTmall_play_activity_info() {
        return tmall_play_activity_info;
    }

    public void setTmall_play_activity_info(String tmall_play_activity_info) {
        this.tmall_play_activity_info = tmall_play_activity_info;
    }

    public String getProvcity() {
        return provcity;
    }

    public void setProvcity(String provcity) {
        this.provcity = provcity;
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

    public String getPict_url() {
        return pict_url;
    }

    public void setPict_url(String pict_url) {
        this.pict_url = pict_url;
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

    public String getShort_title() {
        return short_title;
    }

    public void setShort_title(String short_title) {
        this.short_title = short_title;
    }

    public JSONObject getSmall_images() {
        return small_images;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getZk_final_price() {
        return zk_final_price;
    }

    public void setZk_final_price(String zk_final_price) {
        this.zk_final_price = zk_final_price;
    }

    public String getInfo_dxjh() {
        return info_dxjh;
    }

    public void setInfo_dxjh(String info_dxjh) {
        this.info_dxjh = info_dxjh;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", x_id='" + x_id + '\'' +
                ", item_id=" + item_id +
                ", item_url='" + item_url + '\'' +
                ", item_description='" + item_description + '\'' +
                ", category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                ", commission_rate='" + commission_rate + '\'' +
                ", tmall_play_activity_info='" + tmall_play_activity_info + '\'' +
                ", provcity='" + provcity + '\'' +
                ", include_dxjh='" + include_dxjh + '\'' +
                ", include_mkt='" + include_mkt + '\'' +
                ", level_one_category_id=" + level_one_category_id +
                ", level_one_category_name='" + level_one_category_name + '\'' +
                ", pict_url='" + pict_url + '\'' +
                ", real_post_fee='" + real_post_fee + '\'' +
                ", reserve_price='" + reserve_price + '\'' +
                ", short_title='" + short_title + '\'' +
                ", small_images=" + small_images +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", volume=" + volume +
                ", white_image='" + white_image + '\'' +
                ", info_dxjh='" + info_dxjh + '\'' +
                ", zk_final_price='" + zk_final_price + '\'' +
                '}';
    }
}
