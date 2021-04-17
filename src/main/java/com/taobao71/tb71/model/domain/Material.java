package com.taobao71.tb71.model.domain;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
  @TableId(type= IdType.AUTO)
  private Integer id;
  private Integer categoryId;
  private Integer myCategoryId;
  private String categoryName;
  private String commissionRate;
  private String commissionType;
  private String couponAmount;
  private String couponEndTime;
  private String couponId;
  private String couponInfo;
  private Integer couponRemainCount;
  private String couponShareUrl;
  private String couponStartFee;
  private String couponStartTime;
  private Integer couponTotalCount;
  private String includeDxjh;
  private String includeMkt;
  private String infoDxjh;
  private String itemDescription;
  private Long itemId;
  private String itemUrl;
  private Integer levelOneCategoryId;
  private String levelOneCategoryName;
  private String nick;
  private Long numIid;
  private String pictUrl;
  private String presaleDeposit;
  private Integer presaleEndTime;
  private Integer presaleStartTime;
  private Integer presaleTailEndTime;
  private Integer presaleTailStartTime;
  private String provcity;
  private String realPostFee;
  private String reservePrice;
  private String sellerId;
  private Integer shopDsr;
  private String shopTitle;
  private String shortTitle;
  private JSONObject smallImages;
  private String title;
  private String tkTotalCommi;
  private String tkTotalSales;
  private String url;
  private Integer userType;
  private Integer volume;
  private String whiteImage;
  private String xId;
  private String zkFinalPrice;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public Integer getMyCategoryId() {
    return myCategoryId;
  }

  public void setMyCategoryId(Integer myCategoryId) {
    this.myCategoryId = myCategoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public String getCommissionRate() {
    return commissionRate;
  }

  public void setCommissionRate(String commissionRate) {
    this.commissionRate = commissionRate;
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

  public Integer getCouponTotalCount() {
    return couponTotalCount;
  }

  public void setCouponTotalCount(Integer couponTotalCount) {
    this.couponTotalCount = couponTotalCount;
  }

  public String getIncludeDxjh() {
    return includeDxjh;
  }

  public void setIncludeDxjh(String includeDxjh) {
    this.includeDxjh = includeDxjh;
  }

  public String getIncludeMkt() {
    return includeMkt;
  }

  public void setIncludeMkt(String includeMkt) {
    this.includeMkt = includeMkt;
  }

  public String getInfoDxjh() {
    return infoDxjh;
  }

  public void setInfoDxjh(String infoDxjh) {
    this.infoDxjh = infoDxjh;
  }

  public String getItemDescription() {
    return itemDescription;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }

  public Long getItemId() {
    return itemId;
  }

  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }

  public String getItemUrl() {
    return itemUrl;
  }

  public void setItemUrl(String itemUrl) {
    this.itemUrl = itemUrl;
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

  public String getNick() {
    return nick;
  }

  public void setNick(String nick) {
    this.nick = nick;
  }

  public Long getNumIid() {
    return numIid;
  }

  public void setNumIid(Long numIid) {
    this.numIid = numIid;
  }

  public String getPictUrl() {
    return pictUrl;
  }

  public void setPictUrl(String pictUrl) {
    this.pictUrl = pictUrl;
  }

  public String getPresaleDeposit() {
    return presaleDeposit;
  }

  public void setPresaleDeposit(String presaleDeposit) {
    this.presaleDeposit = presaleDeposit;
  }

  public Integer getPresaleEndTime() {
    return presaleEndTime;
  }

  public void setPresaleEndTime(Integer presaleEndTime) {
    this.presaleEndTime = presaleEndTime;
  }

  public Integer getPresaleStartTime() {
    return presaleStartTime;
  }

  public void setPresaleStartTime(Integer presaleStartTime) {
    this.presaleStartTime = presaleStartTime;
  }

  public Integer getPresaleTailEndTime() {
    return presaleTailEndTime;
  }

  public void setPresaleTailEndTime(Integer presaleTailEndTime) {
    this.presaleTailEndTime = presaleTailEndTime;
  }

  public Integer getPresaleTailStartTime() {
    return presaleTailStartTime;
  }

  public void setPresaleTailStartTime(Integer presaleTailStartTime) {
    this.presaleTailStartTime = presaleTailStartTime;
  }

  public String getProvcity() {
    return provcity;
  }

  public void setProvcity(String provcity) {
    this.provcity = provcity;
  }

  public String getRealPostFee() {
    return realPostFee;
  }

  public void setRealPostFee(String realPostFee) {
    this.realPostFee = realPostFee;
  }

  public String getReservePrice() {
    return reservePrice;
  }

  public void setReservePrice(String reservePrice) {
    this.reservePrice = reservePrice;
  }

  public String getSellerId() {
    return sellerId;
  }

  public void setSellerId(String sellerId) {
    this.sellerId = sellerId;
  }

  public Integer getShopDsr() {
    return shopDsr;
  }

  public void setShopDsr(Integer shopDsr) {
    this.shopDsr = shopDsr;
  }

  public String getShopTitle() {
    return shopTitle;
  }

  public void setShopTitle(String shopTitle) {
    this.shopTitle = shopTitle;
  }

  public String getShortTitle() {
    return shortTitle;
  }

  public void setShortTitle(String shortTitle) {
    this.shortTitle = shortTitle;
  }

  public JSONObject getSmallImages() {
    return smallImages;
  }

  public void setSmallImages(JSONObject smallImages) {
    this.smallImages = smallImages;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Integer getUserType() {
    return userType;
  }

  public void setUserType(Integer userType) {
    this.userType = userType;
  }

  public Integer getVolume() {
    return volume;
  }

  public void setVolume(Integer volume) {
    this.volume = volume;
  }

  public String getWhiteImage() {
    return whiteImage;
  }

  public void setWhiteImage(String whiteImage) {
    this.whiteImage = whiteImage;
  }

  public String getxId() {
    return xId;
  }

  public void setxId(String xId) {
    this.xId = xId;
  }

  public String getZkFinalPrice() {
    return zkFinalPrice;
  }

  public void setZkFinalPrice(String zkFinalPrice) {
    this.zkFinalPrice = zkFinalPrice;
  }

  @Override
  public String toString() {
    return "Material{" +
            "id=" + id +
            ", categoryId=" + categoryId +
            ", myCategoryId=" + myCategoryId +
            ", categoryName='" + categoryName + '\'' +
            ", commissionRate='" + commissionRate + '\'' +
            ", commissionType='" + commissionType + '\'' +
            ", couponAmount='" + couponAmount + '\'' +
            ", couponEndTime='" + couponEndTime + '\'' +
            ", couponId='" + couponId + '\'' +
            ", couponInfo='" + couponInfo + '\'' +
            ", couponRemainCount=" + couponRemainCount +
            ", couponShareUrl='" + couponShareUrl + '\'' +
            ", couponStartFee='" + couponStartFee + '\'' +
            ", couponStartTime='" + couponStartTime + '\'' +
            ", couponTotalCount=" + couponTotalCount +
            ", includeDxjh='" + includeDxjh + '\'' +
            ", includeMkt='" + includeMkt + '\'' +
            ", infoDxjh='" + infoDxjh + '\'' +
            ", itemDescription='" + itemDescription + '\'' +
            ", itemId=" + itemId +
            ", itemUrl='" + itemUrl + '\'' +
            ", levelOneCategoryId=" + levelOneCategoryId +
            ", levelOneCategoryName='" + levelOneCategoryName + '\'' +
            ", nick='" + nick + '\'' +
            ", numIid=" + numIid +
            ", pictUrl='" + pictUrl + '\'' +
            ", presaleDeposit='" + presaleDeposit + '\'' +
            ", presaleEndTime=" + presaleEndTime +
            ", presaleStartTime=" + presaleStartTime +
            ", presaleTailEndTime=" + presaleTailEndTime +
            ", presaleTailStartTime=" + presaleTailStartTime +
            ", provcity='" + provcity + '\'' +
            ", realPostFee='" + realPostFee + '\'' +
            ", reservePrice='" + reservePrice + '\'' +
            ", sellerId='" + sellerId + '\'' +
            ", shopDsr=" + shopDsr +
            ", shopTitle='" + shopTitle + '\'' +
            ", shortTitle='" + shortTitle + '\'' +
            ", smallImages=" + smallImages +
            ", title='" + title + '\'' +
            ", tkTotalCommi='" + tkTotalCommi + '\'' +
            ", tkTotalSales='" + tkTotalSales + '\'' +
            ", url='" + url + '\'' +
            ", userType=" + userType +
            ", volume=" + volume +
            ", whiteImage='" + whiteImage + '\'' +
            ", xId='" + xId + '\'' +
            ", zkFinalPrice='" + zkFinalPrice + '\'' +
            '}';
  }
}
