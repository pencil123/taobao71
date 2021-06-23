package com.taobao71.tb71.Controllers;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.taobao71.tb71.Service.CouponServer;
import com.taobao71.tb71.Utils.PageResult;
import com.taobao71.tb71.model.domain.Coupon;
import com.taobao71.tb71.model.json.JsonResult;
import com.taobao71.tb71.model.vo.CouponResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/coupon")
public class CouponController {

  @Autowired
  private CouponServer couponServer;
  static Logger logger = LoggerFactory.getLogger(CouponController.class);

  @GetMapping("/page/searchbyid")
  public JsonResult<PageResult<CouponResp>> searchCouponBySearchId(
      @RequestParam(required = false, defaultValue = "1") Integer currentPage,
      @RequestParam(required = false, defaultValue = "20") Integer pageSize,
      @RequestParam(required = true) String searchid) {

    IPage<CouponResp> couponRespIpage = couponServer
        .searchCouponBySearchId(searchid, currentPage, pageSize);
    PageResult<CouponResp> result = new PageResult<>(couponRespIpage);
    return JsonResult.success(result);
  }

  @GetMapping("/page/1stcat")
  public JsonResult<PageResult<Coupon>> getCouponBy1stCat(
      @RequestParam(required = false, defaultValue = "1") Integer currentPage,
      @RequestParam(required = false, defaultValue = "20") Integer pageSize,
      @RequestParam(required = true) Integer levelOneCategoryId) {

    IPage<Coupon> couponIPage = couponServer
        .queryCouponBy1stCat(levelOneCategoryId, currentPage, pageSize);
    PageResult<Coupon> result = new PageResult<>(couponIPage);
    return JsonResult.success(result);
  }
}
