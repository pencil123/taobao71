package com.taobao71.tb71.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taobao71.tb71.Service.CouponServer;
import com.taobao71.tb71.mapper.CouponMapper;
import com.taobao71.tb71.model.domain.Coupon;
import com.taobao71.tb71.model.vo.CouponResp;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CouponServerImpl extends ServiceImpl<CouponMapper,Coupon> implements CouponServer {

  public Page<CouponResp> searchCouponBySearchId(String searchid,Integer currentPage, Integer pageSize){
    Page<CouponResp> page = new Page<>(currentPage,pageSize);
    page.setRecords(baseMapper.selectItemRespBySearchId(page,searchid));
    return page;
  }

  public Coupon getCouponByItemId(String itemId){
    QueryWrapper<Coupon> wrapper = new QueryWrapper<>();
    wrapper.eq("item_id", itemId);
    return getOne(wrapper);
  }
}
