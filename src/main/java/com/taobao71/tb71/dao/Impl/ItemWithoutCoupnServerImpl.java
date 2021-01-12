package com.taobao71.tb71.dao.Impl;

import com.taobao71.tb71.dao.ItemWithoutCoupnServer;
import com.taobao71.tb71.domain.ItemWithoutCoupon;
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
public class ItemWithoutCoupnServerImpl implements ItemWithoutCoupnServer {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    static Logger logger = LoggerFactory.getLogger(ItemWithoutCoupnServer.class);

    @Override
    public Integer addItemWithoutCoupon(ItemWithoutCoupon itemWithoutCoupon) {
        // 判断数据库中是否已经存在；如果已经存储
        Integer id = getItemByItemID(itemWithoutCoupon.getItem_id());
        if(id > 0) {return id;}

        //如果数据库中没有存储；
        try {
            String sqlString = "insert into item_without_coupon (item_id) values(?)";
            KeyHolder holder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
                ps.setLong(1,itemWithoutCoupon.getItem_id());
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

    @Override
    public Integer getItemByItemID(Long item_id) {
        try {
            String sqlString = "select id from item_without_coupon where item_id = ?";
            Integer id = jdbcTemplate.queryForObject(sqlString, Integer.class, item_id);
            return id;
        }catch (Exception e){
            return 0;
        }
    }
}
