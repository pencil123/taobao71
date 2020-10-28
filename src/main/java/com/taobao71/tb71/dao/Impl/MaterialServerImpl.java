package com.taobao71.tb71.dao.Impl;

import com.taobao71.tb71.Service.Impl.TaobaoClientServerImpl;
import com.taobao71.tb71.dao.MaterialServer;
import com.taobao71.tb71.domain.Material;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MaterialServerImpl implements MaterialServer {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    static Logger logger = LoggerFactory.getLogger(MaterialServerImpl.class);

    public void addMaterial(Material material){
        try {
            jdbcTemplate.update("insert into material (category_id,category_name,commission_rate,commission_type,coupon_amount,"
                            + "coupon_end_time,coupon_id,coupon_info,coupon_remain_count,coupon_share_url,coupon_start_fee,coupon_start_time,"
                            + "coupon_total_count,include_dxjh,include_mkt,item_description,item_id,item_url,level_one_category_id,"
                            + "level_one_category_name,nick,num_iid,pict_url,presale_deposit,presale_end_time,presale_start_time,"
                            + "presale_tail_end_time,presale_tail_start_time,provcity,real_post_fee,reserve_price,seller_id,shop_dsr,"
                            + "shop_title,short_title,small_images,title,tk_total_commi,tk_total_sales,url,user_type,volume,white_image,x_id,zk_final_price) "
                            + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                    material.getCategory_id(),material.getCategory_name(),material.getCommission_rate(),
                    material.getCommission_type(),material.getCoupon_amount(),material.getCoupon_end_time(),material.getCoupon_id(),
                    material.getCoupon_info(),material.getCoupon_remain_count(),material.getCoupon_share_url(),material.getCoupon_start_fee(),
                    material.getCoupon_start_time(),material.getCoupon_total_count(),material.getInclude_dxjh(),material.getInclude_mkt(),
                    material.getItem_description(),material.getItem_id(),material.getItem_url(),material.getLevel_one_category_id(),
                    material.getLevel_one_category_name(),material.getNick(),material.getNum_iid(),material.getPict_url(),
                    material.getPresale_deposit(),material.getPresale_end_time(),material.getPresale_start_time(),material.getPresale_tail_end_time(),
                    material.getPresale_tail_start_time(),material.getProvcity(),material.getReal_post_fee(),material.getReserve_price(),material.getSeller_id(),material.getShop_dsr(),
                    material.getShop_title(),material.getShort_title(),material.getSmall_images().toJSONString(),
                    material.getTitle(),material.getTk_total_commi(),material.getTk_total_sales(),
                    material.getUrl(),material.getUser_type(),material.getVolume(),
                    material.getWhite_image(),material.getX_id(),material.getZk_final_price());
        } catch (InvalidResultSetAccessException e) {
            logger.warn("Dao#数据写入失败:InvalidResultSetAccessException: {}",e.toString());
        } catch (DataAccessException e) {
            logger.warn("Dao#数据写入失败:DataAccessException; {}",e.toString());
        }
    }
}
