package com.taobao71.tb71.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.stereotype.Component;

/**
 * num_iid	Number	556633720749	商品信息-宝贝id(该字段废弃，请勿再用) pict_url	String	https://img.alicdn.com/bao/uploaded/i4/745957850/TB1WzSRmV9gSKJjSspbXXbeNXXa_!!0-item_pic.jpg	商品信息-商品主图
 * small_images	String[]	https://img.alicdn.com/i4/3077291146/TB2NA3poDnI8KJjSszgXXc8ApXa_!!3077291146.jpg	商品信息-商品小图列表
 * include_mkt	String	false	商品信息-是否包含营销计划 include_dxjh	String	false	商品信息-是否包含定向计划
 * commission_rate	String	1550表示15.5%	商品信息-佣金比率。1550表示15.5% url	String	s.click.xxx	链接-宝贝推广链接
 * white_image	String	https://img.alicdn.com/bao/uploaded/i4/745957850/TB1WzSRmV9gSKJjSspbXXbeNXXa_!!0-item_pic.jpg	商品信息-商品白底图
 * tmall_play_activity_info	String	前n件x折	营销-天猫营销玩法 item_id	Number	5678899993	商品信息-宝贝id
 * real_post_fee	String	0.00	商品邮费 provcity	String	杭州	商品信息-宝贝所在地 x_id	String	uESS0mv8JvfJRMKlIgCD5At9VuHVBXoqBRihfQlo4ybLiKygRlqiN4eoxoZDfe38uSogWy6GB971jD2N8tLuuc	链接-物料块id(测试中请勿使用)
 *
 * commission_type	String	MKT表示营销计划，SP表示定向计划，COMMON表示通用计划	商品信息-佣金类型。MKT表示营销计划，SP表示定向计划，COMMON表示通用计划
 */
@Component
public class Item {

  @TableId(type = IdType.NONE)
  private Long itemId;
  private String title;
  private String pictUrl;
  private String zkFinalPrice;
  private Long sellerId;
  private String xId;
  private String url;
  private String realPostFee;
  private String commissionType;
  private String commissionRate;
  private String tmallPlayActivityInfo;
  private String includeDxjh;
  private String includeMkt;
  private String infoDxjh;


  public Long getItemId() {
    return itemId;
  }

  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }

  public Long getSellerId() {
    return sellerId;
  }

  public void setSellerId(Long sellerId) {
    this.sellerId = sellerId;
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

  public String getxId() {
    return xId;
  }

  public void setxId(String xId) {
    this.xId = xId;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getRealPostFee() {
    return realPostFee;
  }

  public void setRealPostFee(String realPostFee) {
    this.realPostFee = realPostFee;
  }

  public String getCommissionRate() {
    return commissionRate;
  }

  public void setCommissionRate(String commissionRate) {
    this.commissionRate = commissionRate;
  }

  public String getTmallPlayActivityInfo() {
    return tmallPlayActivityInfo;
  }

  public void setTmallPlayActivityInfo(String tmallPlayActivityInfo) {
    this.tmallPlayActivityInfo = tmallPlayActivityInfo;
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

  public String getCommissionType() {
    return commissionType;
  }

  public void setCommissionType(String commissionType) {
    this.commissionType = commissionType;
  }
}
