package com.taobao71.tb71.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * seller_id	Number	232332	店铺信息-卖家id
 * shop_title	String	xx旗舰店	店铺信息-店铺名称
 * shop_dsr	Number	13	店铺信息-店铺dsr评分
 * user_type	Number	1	店铺信息-卖家类型。0表示集市，1表示天猫
 * provcity	String	杭州	商品信息-宝贝所在地
 * nick	String	旗舰店	店铺信息-卖家昵称
 */
@Component
public class Shop  implements Serializable {
    @TableId(type= IdType.NONE)
    private String sellerId;
    private String shopTitle;
    private Integer shopDsr;
    private Integer userType;
    private String nick;

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getShopTitle() {
        return shopTitle;
    }

    public void setShopTitle(String shopTitle) {
        this.shopTitle = shopTitle;
    }

    public Integer getShopDsr() {
        return shopDsr;
    }

    public void setShopDsr(Integer shopDsr) {
        this.shopDsr = shopDsr;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
