package com.taobao71.tb71.dao;

import com.taobao71.tb71.domain.Material;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author lyzhang
 * @since 2019/11/13 20:45
 */
@Component
public class WeChatDao {
  @Autowired
  private JdbcTemplate jdbcTemplate;
  @Autowired
  Material material;

  public Map<String,String> singleMaterial(String keyword){
    Map<String,String> result = new HashMap();
    String sql = "select short_title,title,id,pict_url from material where title like ? order by volume DESC LIMIT 1";
    try{
      Map map = jdbcTemplate.queryForMap(sql,new Object [] {"%" + keyword + "%"});
      for(Object key : map.keySet()) {
        if(String.valueOf(key).equals("short_title")){
          result.put("title",String.valueOf(map.get(key)));
        }
        if(String.valueOf(key).equals("title")){
          result.put("description",String.valueOf(map.get(key)));
        }
        if(String.valueOf(key).equals("id")){
          result.put("url","https://taobao71.com/goods/info/" + String.valueOf(map.get(key)) + ".html");
        }
        if(String.valueOf(key).equals("pict_url")){
          result.put("img_url",String.valueOf(map.get(key)));
        }
      }
      return result;
    } catch (EmptyResultDataAccessException e){
      e.printStackTrace();
      return result;
    }
  }
}
