package com.taobao71.tb71.dao.Impl;

import com.taobao71.tb71.dao.CouponResultServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CouponResultServerImpl implements CouponResultServer {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    static Logger logger = LoggerFactory.getLogger(CouponResultServerImpl.class);

    public String couponExist(Long item_id){
        try {
            String sqlString = "select coupon_share_url from coupon_result where item_id = ?";
            String coupon_share_url = jdbcTemplate.queryForObject(sqlString, String.class, item_id);
            return coupon_share_url;
        }catch (Exception e){
            return null;
        }
    }
}
