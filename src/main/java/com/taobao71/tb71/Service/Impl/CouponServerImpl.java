package com.taobao71.tb71.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taobao71.tb71.Service.CouponServer;
import com.taobao71.tb71.mapper.CouponMapper;
import com.taobao71.tb71.model.domain.Coupon;
import com.taobao71.tb71.model.vo.ItemResp;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CouponServerImpl extends ServiceImpl<CouponMapper,Coupon> implements CouponServer {

  public List<ItemResp> searchCouponBySearchId(String searchid){
    return baseMapper.selectItemRespBySearchId(searchid);
  }
}
