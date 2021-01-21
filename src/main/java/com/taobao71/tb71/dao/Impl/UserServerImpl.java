package com.taobao71.tb71.dao.Impl;

import com.taobao71.tb71.dao.UserServer;
import com.taobao71.tb71.domain.Shop;
import com.taobao71.tb71.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;

@Component
public class UserServerImpl implements UserServer {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    static Logger logger = LoggerFactory.getLogger(UserServerImpl.class);

    private Integer UserExistReturnId(String openid) {
        try {
            String sqlString = "select id from user where openid = ?";
            Integer id = jdbcTemplate.queryForObject(sqlString, Integer.class, openid);
            return id;
        }catch (Exception e){
            return 0;
        }
    }

    public Integer addUser(String openid){
        // 判断数据库中是否已经存在；如果已经存储
        Integer id = UserExistReturnId(openid);
        if(id > 0) {return id;}

        //如果数据库中没有存储；
        try {
            String sqlString = "insert into user (openid) values(?)";
            KeyHolder holder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,openid);
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
