package com.taobao71.tb71.dao.Impl;

import com.taobao71.tb71.dao.ItemSearchServer;
import com.taobao71.tb71.domain.ItemSearch;
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
public class ItemSearchServerImpl implements ItemSearchServer {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    static Logger logger = LoggerFactory.getLogger(ItemSearchServerImpl.class);

    /**
     * 数据库中是否存储搜索记录
     * @param keyword
     * @return 搜索记录ID search_id
     */
    private Long itemSearchExist(String keyword) {
        try {
            String sqlString = "select search_id from item_search where keyword = ?";
            Long searchId = jdbcTemplate.queryForObject(sqlString, Long.class, keyword);
            return searchId;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 将用户搜索的商品信息，写入到数据库
     * @param itemSearch
     * @return 返回 search_id
     */
    public Long addItemSearch(ItemSearch itemSearch){
        // 判断数据库中是否已经存在；如果已经存储
        Long searchId = itemSearchExist(itemSearch.getKeyword());
        if(searchId != null){
            return searchId;
        }
        //如果数据库中没有存储；
        try {
            String sqlString = "insert into item_search(keyword,search_id) values(?,?)";
            jdbcTemplate.update(sqlString,itemSearch.getKeyword(),itemSearch.getSearch_id());
        } catch (InvalidResultSetAccessException e) {
            logger.warn("Dao#数据写入失败:InvalidResultSetAccessException: {}",e.toString());
        } catch (DataAccessException e) {
            logger.warn("Dao#数据写入失败:DataAccessException; {}",e.toString());
        }
        return itemSearch.getSearch_id();
    }
}
