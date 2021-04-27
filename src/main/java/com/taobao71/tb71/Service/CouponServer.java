package com.taobao71.tb71.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.taobao71.tb71.model.domain.Coupon;
import com.taobao71.tb71.model.vo.CouponResp;
import org.springframework.stereotype.Service;

@Service
public interface CouponServer extends IService<Coupon> {

  Page<CouponResp> searchCouponBySearchId(String searchid, Integer currentPage, Integer pageSize);

  Coupon getCouponByItemId(String itemId);

  IPage<Coupon> queryCouponBy1stCat(Integer levelOneCategoryId, Integer currentPage,
      Integer pageSize);
}
