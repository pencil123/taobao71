package com.taobao71.tb71.dao;

import com.taobao71.tb71.domain.Material;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author lyzhang
 * @since 2019/11/4 16:56
 */
@Component
public class MaterialDao {
  @Autowired
  private JdbcTemplate jdbcTemplate;
  static Logger logger = LoggerFactory.getLogger(MaterialDao.class);
  /**
   * 将从API获取的数据，插入到数据库中
   * @param materials 数据对象
   */
  public void insertMegs(LinkedList<Material> materials ) {
    for(int i=0;i< materials.size();i++) {
      Material material = materials.get(i);
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
                            material.getShop_title(),material.getShort_title(),material.getSmall_images(),
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


  /**
   * 对未设置商品类型的商品取商品类别名称
   * @return 未设置类别ID的商量类别去重
   */
  public List categoryNameUnique(){
    String sql = "select level_one_category_name from material where my_category_id is NULL group by level_one_category_name";
    List categoryNames = jdbcTemplate.queryForList(sql);
    return categoryNames;
  }

  /**
   * 更新商品的所属类别ID
   * @param categoryFullName 类别的名称
   * @param categoryId  类别所属的ID
   * @return
   */
  public boolean updateCategoryID(String categoryFullName,Integer categoryId){
    String updateSQL = "update material set my_category_id = ? where level_one_category_name = ? and my_category_id is NULL";
    jdbcTemplate.update(updateSQL,categoryId,categoryFullName);
    return true;
  }

  public List getItems(){
    String selectSQL = "select id,item_id from material limit 100";
    List item_ids = jdbcTemplate.queryForList(selectSQL);
    return item_ids;
  }


}
