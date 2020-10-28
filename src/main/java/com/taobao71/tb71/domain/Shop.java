package com.taobao71.tb71.domain;

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
    private Integer id;
    private String seller_id;
    private String shop_title;
    private Integer shop_dsr;
    private Integer user_type;

    private String nick;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getShop_title() {
        return shop_title;
    }

    public void setShop_title(String shop_title) {
        this.shop_title = shop_title;
    }

    public Integer getShop_dsr() {
        return shop_dsr;
    }

    public void setShop_dsr(Integer shop_dsr) {
        this.shop_dsr = shop_dsr;
    }

    public Integer getUser_type() {
        return user_type;
    }

    public void setUser_type(Integer user_type) {
        this.user_type = user_type;
    }


    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
