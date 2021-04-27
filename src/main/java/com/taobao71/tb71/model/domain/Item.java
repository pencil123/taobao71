package com.taobao71.tb71.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String xId;
    private Long itemId;
    private String itemUrl;
    private String itemDescription;
    private Integer categoryId;
    private String categoryName;
    private String commissionRate;
    private String tmallPlayActivityInfo;
    private String provcity;
    private String includeDxjh;
    private String includeMkt;
    private Integer levelOneCategoryId;
    private String levelOneCategoryName;
    private String pictUrl;
    private String realPostFee;
    private String reservePrice;
    private String shortTitle;
    private String smallImages;
    private String title;
    private String url;
    private Integer volume;
    private String whiteImage;
    private String infoDxjh;
    private String zkFinalPrice;
    private String sellerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getxId() {
        return xId;
    }

    public void setxId(String xId) {
        this.xId = xId;
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

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
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

    public String getProvcity() {
        return provcity;
    }

    public void setProvcity(String provcity) {
        this.provcity = provcity;
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

    public String getPictUrl() {
        return pictUrl;
    }

    public void setPictUrl(String pictUrl) {
        this.pictUrl = pictUrl;
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

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getSmallImages() {
        return smallImages;
    }

    public void setSmallImages(String smallImages) {
        this.smallImages = smallImages;
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

    public String getWhiteImage() {
        return whiteImage;
    }

    public void setWhiteImage(String whiteImage) {
        this.whiteImage = whiteImage;
    }

    public String getInfoDxjh() {
        return infoDxjh;
    }

    public void setInfoDxjh(String infoDxjh) {
        this.infoDxjh = infoDxjh;
    }

    public String getZkFinalPrice() {
        return zkFinalPrice;
    }

    public void setZkFinalPrice(String zkFinalPrice) {
        this.zkFinalPrice = zkFinalPrice;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", xId='" + xId + '\'' +
                ", itemId=" + itemId +
                ", itemUrl='" + itemUrl + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", commissionRate='" + commissionRate + '\'' +
                ", tmallPlayActivityInfo='" + tmallPlayActivityInfo + '\'' +
                ", provcity='" + provcity + '\'' +
                ", includeDxjh='" + includeDxjh + '\'' +
                ", includeMkt='" + includeMkt + '\'' +
                ", levelOneCategoryId=" + levelOneCategoryId +
                ", levelOneCategoryName='" + levelOneCategoryName + '\'' +
                ", pictUrl='" + pictUrl + '\'' +
                ", realPostFee='" + realPostFee + '\'' +
                ", reservePrice='" + reservePrice + '\'' +
                ", shortTitle='" + shortTitle + '\'' +
                ", smallImages='" + smallImages + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", volume=" + volume +
                ", whiteImage='" + whiteImage + '\'' +
                ", infoDxjh='" + infoDxjh + '\'' +
                ", zkFinalPrice='" + zkFinalPrice + '\'' +
                ", sellerId='" + sellerId + '\'' +
                '}';
    }
}
