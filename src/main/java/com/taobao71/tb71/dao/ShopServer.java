package com.taobao71.tb71.dao;

import com.taobao71.tb71.domain.Shop;
import org.springframework.stereotype.Service;

/**
 * 逻辑：自建库处理
 * 商家店铺信息Shop 管理
 */
@Service
public interface ShopServer {

    /**
     * 向数据库中插入商品店家信息
     * @param shop
     * @return 商铺ID
     */
    public Integer addShop(Shop shop);
}
