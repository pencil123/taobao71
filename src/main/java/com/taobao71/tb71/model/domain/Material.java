package com.taobao71.tb71.model.domain;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import org.springframework.stereotype.Component;

/**
 * @author lyzhang
 * @since 2019/11/4 16:31
 */


/**
 * 物料信息类
 * coupon_start_time	String	2017-10-29	优惠券信息-优惠券开始时间
 * coupon_end_time	String	2017-10-29	优惠券信息-优惠券结束时间
 * info_dxjh	Json	{"19013551":"2850","74510538":"2550"}	商品信息-定向计划信息
 * tk_total_sales	String	11	商品信息-淘客30天推广量
 * tk_total_commi	String	323	商品信息-月支出佣金(该字段废弃，请勿再用)
 * coupon_id	String	d62db1ab8d9546b1bf0ff49bda5fc33b	优惠券信息-优惠券id
 * num_iid	Number	556633720749	商品信息-宝贝id(该字段废弃，请勿再用)
 * title	String	毛呢阔腿裤港味复古女裤子秋冬九分裤萝卜裤显瘦高腰韩版2017新款	商品信息-商品标题
 * pict_url	String	https://img.alicdn.com/bao/uploaded/i4/745957850/TB1WzSRmV9gSKJjSspbXXbeNXXa_!!0-item_pic.jpg	商品信息-商品主图
 * small_images	String[]	https://img.alicdn.com/i4/3077291146/TB2NA3poDnI8KJjSszgXXc8ApXa_!!3077291146.jpg	商品信息-商品小图列表
 * reserve_price	String	102.00	商品信息-商品一口价格
 * zk_final_price	String	88.00	折扣价（元） 若属于预售商品，付定金时间内，折扣价=预售价
 * user_type	Number	1	店铺信息-卖家类型。0表示集市，1表示天猫
 * provcity	String	杭州	商品信息-宝贝所在地
 * item_url	String	https://item.taobao.com/item.htm?id=564591813536	链接-宝贝地址
 * include_mkt	String	false	商品信息-是否包含营销计划
 * include_dxjh	String	false	商品信息-是否包含定向计划
 * commission_rate	String	1550表示15.5%	商品信息-佣金比率。1550表示15.5%
 * volume	Number	123	商品信息-30天销量
 * seller_id	Number	232332	店铺信息-卖家id
 * coupon_total_count	Number	22323	优惠券信息-优惠券总量
 * coupon_remain_count	Number	111	优惠券信息-优惠券剩余量
 * coupon_info	String	满299元减20元	优惠券信息-优惠券满减信息
 * commission_type	String	MKT表示营销计划，SP表示定向计划，COMMON表示通用计划	商品信息-佣金类型。MKT表示营销计划，SP表示定向计划，COMMON表示通用计划
 * shop_title	String	xx旗舰店	店铺信息-店铺名称
 * shop_dsr	Number	13	店铺信息-店铺dsr评分
 * coupon_share_url	String	uland.xxx	链接-宝贝+券二合一页面链接
 * url	String	s.click.xxx	链接-宝贝推广链接
 * level_one_category_name	String	女装	商品信息-一级类目名称
 * level_one_category_id	Number	20	商品信息-一级类目ID
 * category_name	String	连衣裙	商品信息-叶子类目名称
 * category_id	Number	162201	商品信息-叶子类目id
 * short_title	String	xxsd	商品信息-商品短标题
 * white_image	String	https://img.alicdn.com/bao/uploaded/i4/745957850/TB1WzSRmV9gSKJjSspbXXbeNXXa_!!0-item_pic.jpg	商品信息-商品白底图
 * oetime	String	2018-08-21 11:23:43	拼团专用-拼团结束时间
 * ostime	String	2018-08-21 11:23:43	拼团专用-拼团开始时间
 * jdd_num	Number	10	拼团专用-拼团几人团
 * jdd_price	String	5	拼团专用-拼团拼成价，单位元
 * uv_sum_pre_sale	Number	23	预售专用-预售数量
 * x_id	String	uESS0mv8JvfJRMKlIgCD5At9VuHVBXoqBRihfQlo4ybLiKygRlqiN4eoxoZDfe38uSogWy6GB971jD2N8tLuuc	链接-物料块id(测试中请勿使用)
 * coupon_start_fee	String	29.00	优惠券信息-优惠券起用门槛，满X元可用。如：满299元减20元
 * coupon_amount	String	10.00	优惠券（元） 若属于预售商品，该优惠券付尾款可用，付定金不可用
 * item_description	String	季凉被 全棉亲肤	商品信息-宝贝描述(推荐理由)
 * nick	String	旗舰店	店铺信息-卖家昵称
 * orig_price	String	25	拼团专用-拼团一人价（原价)，单位元
 * total_stock	Number	5555	拼团专用-拼团库存数量
 * sell_num	Number	1111	拼团专用-拼团已售数量
 * stock	Number	4444	拼团专用-拼团剩余库存
 * tmall_play_activity_info	String	前n件x折	营销-天猫营销玩法
 * item_id	Number	5678899993	商品信息-宝贝id
 * real_post_fee	String	0.00	商品邮费
 * lock_rate	String	1567440000000	锁住的佣金率
 * lock_rate_end_time	Number	1567440000000	锁佣结束时间
 * lock_rate_start_time	Number	1567440000000	锁佣开始时间
 * presale_discount_fee_text	String	付定金立减5元	预售商品-优惠
 * presale_tail_end_time	Number	1567440000000	预售商品-付尾款结束时间（毫秒）
 * presale_tail_start_time	Number	1567440000000	预售商品-付尾款开始时间（毫秒）
 * presale_end_time	Number	1567440000000	预售商品-付定金结束时间（毫秒）
 * presale_start_time	Number	1567440000000	预售商品-付定金开始时间（毫秒）
 * presale_deposit	String	100	预售商品-定金（元）
 * ysyl_tlj_send_time	String	2019-11-10 21:59:59	预售有礼-淘礼金发放时间
 * ysyl_commission_rate	String	2030（表示20.3%）	预售有礼-佣金比例（ 预售有礼活动享受的推广佣金比例，注：推广该活动有特殊分成规则，请详见：https://tbk.bbs.taobao.com/detail.html?appId=45301&postId=9334376 ）
 * ysyl_tlj_face	String	0.6	预售有礼-预估淘礼金（元）
 * ysyl_click_url	String	https://uland.taobao.com	预售有礼-推广链接
 * ysyl_tlj_use_end_time	String	2019-11-10 21:59:59	预售有礼-淘礼金使用结束时间
 * ysyl_tlj_use_start_time	String	2019-11-10 21:59:59	预售有礼-淘礼金使用开始时间
 */

@Component
public class Material  implements Serializable {
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
  private String info_dxjh;
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCategory_id() {
    return category_id;
  }

  public void setCategory_id(Integer category_id) {
    this.category_id = category_id;
  }

  public Integer getMy_category_id() {
    return my_category_id;
  }

  public void setMy_category_id(Integer my_category_id) {
    this.my_category_id = my_category_id;
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

  public String getInfo_dxjh() {
    return info_dxjh;
  }

  public void setInfo_dxjh(String info_dxjh) {
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

  @Override
  public String toString() {
    return "Material{" +
            "id=" + id +
            ", category_id=" + category_id +
            ", my_category_id=" + my_category_id +
            ", category_name='" + category_name + '\'' +
            ", commission_rate='" + commission_rate + '\'' +
            ", commission_type='" + commission_type + '\'' +
            ", coupon_amount='" + coupon_amount + '\'' +
            ", coupon_end_time='" + coupon_end_time + '\'' +
            ", coupon_id='" + coupon_id + '\'' +
            ", coupon_info='" + coupon_info + '\'' +
            ", coupon_remain_count=" + coupon_remain_count +
            ", coupon_share_url='" + coupon_share_url + '\'' +
            ", coupon_start_fee='" + coupon_start_fee + '\'' +
            ", coupon_start_time='" + coupon_start_time + '\'' +
            ", coupon_total_count=" + coupon_total_count +
            ", include_dxjh='" + include_dxjh + '\'' +
            ", include_mkt='" + include_mkt + '\'' +
            ", info_dxjh='" + info_dxjh + '\'' +
            ", item_description='" + item_description + '\'' +
            ", item_id=" + item_id +
            ", item_url='" + item_url + '\'' +
            ", level_one_category_id=" + level_one_category_id +
            ", level_one_category_name='" + level_one_category_name + '\'' +
            ", nick='" + nick + '\'' +
            ", num_iid=" + num_iid +
            ", pict_url='" + pict_url + '\'' +
            ", presale_deposit='" + presale_deposit + '\'' +
            ", presale_end_time=" + presale_end_time +
            ", presale_start_time=" + presale_start_time +
            ", presale_tail_end_time=" + presale_tail_end_time +
            ", presale_tail_start_time=" + presale_tail_start_time +
            ", provcity='" + provcity + '\'' +
            ", real_post_fee='" + real_post_fee + '\'' +
            ", reserve_price='" + reserve_price + '\'' +
            ", seller_id='" + seller_id + '\'' +
            ", shop_dsr=" + shop_dsr +
            ", shop_title='" + shop_title + '\'' +
            ", short_title='" + short_title + '\'' +
            ", small_images=" + small_images +
            ", title='" + title + '\'' +
            ", tk_total_commi='" + tk_total_commi + '\'' +
            ", tk_total_sales='" + tk_total_sales + '\'' +
            ", url='" + url + '\'' +
            ", user_type=" + user_type +
            ", volume=" + volume +
            ", white_image='" + white_image + '\'' +
            ", x_id='" + x_id + '\'' +
            ", zk_final_price='" + zk_final_price + '\'' +
            '}';
  }
}
