package com.taobao71.tb71.dao.Impl;

import com.taobao71.tb71.dao.ItemServer;
import com.taobao71.tb71.domain.Coupon;
import com.taobao71.tb71.domain.Item;
import com.taobao71.tb71.domain.Shop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

    public Item getItemByItemId(Long itemId){
        try{
            String sqlString = "select * from item where item_id = ?";
            Item item = jdbcTemplate.queryForObject(sqlString,new BeanPropertyRowMapper<Item>(Item.class),itemId);
            return item;
        }catch (Exception e){
            logger.info(e.getMessage());
            return null;
        }
    }

    public Integer addItem(Item item){
        // 判断数据库中是否已经存在；如果已经存储
        Item item1  = getItemByItemId(item.getItem_id());
        if(item1 != null) {return item1.getId();}
        Integer id = 0;

        logger.info("ItemImpl info:{}",item.toString());
        //如果数据库中没有存储；
        try {
            String sqlString = "insert into item (x_id,item_id,short_title,title,item_url," +
                    "item_description,provcity,pict_url,small_images,white_image,real_post_fee,reserve_price," +
                    "zk_final_price,volume,category_id,category_name,level_one_category_id,level_one_category_name,url," +
                    "commission_rate,tmall_play_activity_info,include_dxjh,info_dxjh,include_mkt,shop_id) values(?,?,?,?,?," +
                    "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            KeyHolder holder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,item.getX_id());
                ps.setLong(2, item.getItem_id());
                ps.setString(3, item.getShort_title());
                ps.setString(4, item.getTitle());
                ps.setString(5,item.getItem_url());
                ps.setString(6, item.getItem_description());
                ps.setString(7, item.getProvcity());
                ps.setString(8, item.getPict_url());
                ps.setString(9, item.getSmall_images() == null ? "{}": item.getSmall_images());
                ps.setString(10,item.getWhite_image());
                ps.setString(11, item.getReal_post_fee());
                ps.setString(12, item.getReserve_price());
                ps.setString(13, item.getZk_final_price());
                ps.setInt(14, item.getVolume());
                ps.setInt(15,item.getCategory_id() ==null ? 0 : item.getCategory_id());
                ps.setString(16, item.getCategory_name());
                ps.setInt(17, item.getLevel_one_category_id() == null ? 0:item.getLevel_one_category_id());
                ps.setString(18, item.getLevel_one_category_name());
                ps.setString(19, item.getUrl());
                ps.setString(20,item.getCommission_rate());
                ps.setString(21, item.getTmall_play_activity_info());
                ps.setString(22, item.getInclude_dxjh());
                ps.setString(23, item.getInfo_dxjh());
                ps.setString(24, item.getInclude_mkt());
                ps.setInt(25, item.getShop_id() ==null?0:item.getShop_id());
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
