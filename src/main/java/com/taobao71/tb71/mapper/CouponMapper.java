package com.taobao71.tb71.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taobao71.tb71.model.domain.Coupon;
import com.taobao71.tb71.model.vo.ItemResp;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponMapper extends BaseMapper<Coupon> {

  @Select("select item_id,title,pict_url,zk_final_price,coupon_total_count,coupon_remain_count,coupon_info,coupon_start_fee,coupon_amount from coupon where search_id=#{search_id}")
  List<ItemResp> selectItemRespBySearchId(@Param("search_id") String search_id);

}
