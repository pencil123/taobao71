package com.taobao71.tb71.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taobao71.tb71.Service.ShopServer;
import com.taobao71.tb71.mapper.ShopMapper;
import com.taobao71.tb71.model.domain.Shop;
import org.springframework.stereotype.Service;

@Service
public class ShopServerImpl extends ServiceImpl<ShopMapper, Shop> implements ShopServer {
}
