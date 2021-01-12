package com.taobao71.tb71.domain;

import org.springframework.stereotype.Component;

@Component
public class ItemWithoutCoupon {
    private Integer id;
    private Long item_id;

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
}
