package com.taobao71.tb71.dao.Impl;

import com.taobao71.tb71.dao.CouponServer;
import com.taobao71.tb71.domain.Coupon;
import com.taobao71.tb71.domain.Shop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;

@Service
public class CouponServerImpl implements CouponServer {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    static Logger logger = LoggerFactory.getLogger(ShopServerImpl.class);

    private Integer couponExistRetrunId(Coupon coupon) {
        try {
            String sqlString = "select id from coupon where coupon_id = ?";
            Integer id = jdbcTemplate.queryForObject(sqlString, Integer.class, coupon.getCoupon_id());
            return id;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public Integer addCoupon(Coupon coupon) {
        // 判断数据库中是否已经存在；如果已经存储
        Integer id = couponExistRetrunId(coupon);
        if(id > 0) {return id;}

        //如果数据库中没有存储；
        try {
            String sqlString = "insert into coupon (coupon_id,coupon_info,coupon_share_url,coupon_total_count," +
                    "coupon_remain_count,coupon_start_fee,coupon_amount,coupon_start_time,coupon_end_time," +
                    "commission_rate,commission_type,tk_total_sales,tk_total_commi,item_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            KeyHolder holder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,coupon.getCoupon_id());
                ps.setString(2, coupon.getCoupon_info());
                ps.setString(3, coupon.getCoupon_share_url());
                ps.setInt(4, coupon.getCoupon_total_count());
                ps.setInt(5, coupon.getCoupon_remain_count());

                ps.setString(6,coupon.getCoupon_start_fee());
                ps.setString(7, coupon.getCoupon_amount());
                ps.setString(8, coupon.getCoupon_start_time());
                ps.setString(9, coupon.getCoupon_end_time());
                ps.setString(10, coupon.getCommission_rate());

                ps.setString(11,coupon.getCommission_type());
                ps.setString(12, coupon.getTk_total_sales());
                ps.setString(13, coupon.getTk_total_commi());
                ps.setInt(14, coupon.getItem_id_tk());
                return ps;
            }, holder);
            id = Objects.requireNonNull(holder.getKey()).intValue();
        } catch (InvalidResultSetAccessException e) {
            logger.warn("Dao#数据写入失败:InvalidResultSetAccessException: {}",e.toString());
        } catch (DataAccessException e) {
            logger.warn("Dao#数据写入失败:DataAccessException; {}",e.toString());
        }
        return Integer.valueOf(id);
    }
}
