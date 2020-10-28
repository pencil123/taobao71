package com.taobao71.tb71.dao;

import com.taobao71.tb71.domain.Shop;
import org.springframework.stereotype.Service;

@Service
public interface ShopServer {
    public Integer addShop(Shop shop);
}
