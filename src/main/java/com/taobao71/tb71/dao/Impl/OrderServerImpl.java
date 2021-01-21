package com.taobao71.tb71.dao.Impl;

import com.taobao71.tb71.dao.OrderServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderServerImpl implements OrderServer {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    static Logger logger = LoggerFactory.getLogger(OrderServerImpl.class);


    private boolean orderExist(Long orderId){
        try {
            String sqlString = "select user_id from user where orderid = ?";
            Integer user_id = jdbcTemplate.queryForObject(sqlString, Integer.class, orderId);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 向数据库中添加订单信息
     * @param orderId 订单ID
     * @param userId 用户ID
     * @return 0:插入成功； 1：已经存在；2：插入失败
     */
    @Override
    public Integer addOrder(Long orderId, Integer userId) {
        if( orderExist(orderId) ){
            return 1;
        }

        try {
            String sqlString = "insert into order_tk (orderid,user_id) values(?,?)";
            jdbcTemplate.update(sqlString,orderId,userId);
            return 0;
        } catch (InvalidResultSetAccessException e) {
            logger.warn("Dao#数据写入失败:InvalidResultSetAccessException: {}",e.toString());
            return 2;
        } catch (DataAccessException e) {
            logger.warn("Dao#数据写入失败:DataAccessException; {}",e.toString());
            return 2;
        }
    }
}
