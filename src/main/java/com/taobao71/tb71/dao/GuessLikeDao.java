package com.taobao71.tb71.dao;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author lyzhang
 * @since 2019/11/11 17:24
 */
@Component
public class GuessLikeDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public Boolean updateGuessLike() {
    String deleteString = "truncate table guess_like";
    try {
      jdbcTemplate.execute(deleteString);
    }catch (Exception e) {
      System.out.println(e.getMessage());
    }
    String selectString = "select id from category";
    List categoryIDs = jdbcTemplate.queryForList(selectString);

    for(int i=0;i<categoryIDs.size();i++) {
      Map<String,Integer> categoryInfo = (Map<String,Integer>) categoryIDs.get(i);
      Integer categoryID = categoryInfo.get("id");

      String updateString = "insert into guess_like (goods_id,category_id,goods_name,goods_img) select id,my_category_id,title,pict_url from material where my_category_id = ? order by volume  desc limit 20";
      jdbcTemplate.update(updateString,categoryID);
    }
    return true;
  }
}
