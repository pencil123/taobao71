package com.taobao71.tb71.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taobao71.tb71.model.domain.Coupon;
import com.taobao71.tb71.model.vo.ItemResp;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CouponServer extends IService<Coupon> {

  public List<ItemResp> searchCouponBySearchId(String searchid);

  public Coupon getCouponByItemId(String itemId);
}
