package com.taobao71.tb71.model.vo;

import java.io.Serializable;
import org.springframework.stereotype.Component;

/**
 * 优惠券响应wx信息
 * 不存储数据库
 */

@Component
public class CouponPwdResp implements Serializable {
    private String title;
    private String pictUrl;
    private String tpwd;
    private String smallImages;

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

    public String getTpwd() {
        return tpwd;
    }

    public void setTpwd(String tpwd) {
        this.tpwd = tpwd;
    }

    public String getSmallImages() {
        return smallImages;
    }

    public void setSmallImages(String smallImages) {
        this.smallImages = smallImages;
    }
}
