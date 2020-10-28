package com.taobao71.tb71.dao.Impl;

import com.taobao71.tb71.dao.ItemServer;
import com.taobao71.tb71.domain.Item;
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
public class ItemServerImpl implements ItemServer {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    static Logger logger = LoggerFactory.getLogger(ItemServerImpl.class);

    private Integer itemExistRetrunId(Item item) {
        try {
            String sqlString = "select id item from item where num_iid = ?";
            Integer id = jdbcTemplate.queryForObject(sqlString, Integer.class, item.getNum_iid());
            return id;
        }catch (Exception e){
            return 0;
        }
    }

    public Integer addItem(Item item){
        // 判断数据库中是否已经存在；如果已经存储
        Integer id = itemExistRetrunId(item);
        if(id > 0) {return id;}

        logger.info("ItemImpl info:{}",item.toString());
        //如果数据库中没有存储；
        try {
            String sqlString = "insert into item (x_id,item_id,num_iid,short_title,title,item_url," +
                    "item_description,provcity,pict_url,small_images,white_image,real_post_fee,reserve_price," +
                    "zk_final_price,volume,category_id,category_name,level_one_category_id,level_one_category_name,url," +
                    "commission_rate,tmall_play_activity_info,include_dxjh,info_dxjh,include_mkt,shop_id) values(?,?,?,?,?," +
                    "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            KeyHolder holder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,item.getX_id());
                ps.setLong(2, item.getItem_id());
                ps.setLong(3, item.getNum_iid());
                ps.setString(4, item.getShort_title());
                ps.setString(5, item.getTitle());
                ps.setString(6,item.getItem_url());
                ps.setString(7, item.getItem_description());
                ps.setString(8, item.getProvcity());
                ps.setString(9, item.getPict_url());
                ps.setString(10, item.getSmall_images() == null ? "{}": item.getSmall_images().toJSONString());
                ps.setString(11,item.getWhite_image());
                ps.setString(12, item.getReal_post_fee());
                ps.setString(13, item.getReserve_price());
                ps.setString(14, item.getZk_final_price());
                ps.setInt(15, item.getVolume());
                ps.setInt(16,item.getCategory_id());
                ps.setString(17, item.getCategory_name());
                ps.setInt(18, item.getLevel_one_category_id());
                ps.setString(19, item.getLevel_one_category_name());
                ps.setString(20, item.getUrl());
                ps.setString(21,item.getCommission_rate());
                ps.setString(22, item.getTmall_play_activity_info());
                ps.setString(23, item.getInclude_dxjh());
                ps.setString(24, item.getInfo_dxjh());
                ps.setString(25, item.getInclude_mkt());
                ps.setInt(26, item.getShop_id());
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
