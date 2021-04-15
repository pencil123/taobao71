package com.taobao71.tb71.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taobao71.tb71.Service.ItemWithoutCouponServer;
import com.taobao71.tb71.mapper.CouponMapper;
import com.taobao71.tb71.mapper.ItemWithoutCouponMapper;
import com.taobao71.tb71.model.domain.Coupon;
import com.taobao71.tb71.model.domain.ItemWithoutCoupon;
import org.springframework.stereotype.Service;

@Service
public class ItemWithoutCouponServerImpl extends ServiceImpl<ItemWithoutCouponMapper, ItemWithoutCoupon> implements ItemWithoutCouponServer {

}
