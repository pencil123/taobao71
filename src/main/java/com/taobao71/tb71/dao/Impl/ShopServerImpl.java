package com.taobao71.tb71.dao.Impl;

import com.taobao71.tb71.dao.ShopServer;
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
public class ShopServerImpl implements ShopServer {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    static Logger logger = LoggerFactory.getLogger(ShopServerImpl.class);

    private Integer shopExistRetrunId(Shop shop) {
        try {
            String sqlString = "select id from shop where seller_id = ?";
            Integer id = jdbcTemplate.queryForObject(sqlString, Integer.class, shop.getSeller_id());
            return id;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public Integer addShop(Shop shop) {
        // 判断数据库中是否已经存在；如果已经存储
        Integer id = shopExistRetrunId(shop);
        if(id > 0) {return id;}

        //如果数据库中没有存储；
        try {
            String sqlString = "insert into shop (seller_id,user_type,nick,shop_dsr,shop_title) values(?,?,?,?,?)";

            KeyHolder holder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,shop.getSeller_id());
                ps.setInt(2, shop.getUser_type());
                ps.setString(3, shop.getNick());
                ps.setInt(4, shop.getShop_dsr());
                ps.setString(5, shop.getShop_title());
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
