package com.taobao71.tb71.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

/**
 * @author lyzhang
 * @since 2019/11/7 13:35
 */
@Component
public class CategoryDao {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public Integer categoryAdd(String categoryName) {
    String selectSQL= "select id from category where category_name = ?";
    try {
      return jdbcTemplate.queryForObject(selectSQL,Integer.class,categoryName);
    }catch (EmptyResultDataAccessException e) {
      String insertSQL = "insert into category (category_name) values(?)";
      KeyHolder holder = new GeneratedKeyHolder();
      PreparedStatementCreator preparedStatementCreator = connection -> {
        PreparedStatement ps = connection.prepareStatement(insertSQL,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,categoryName);
        return ps;
      };
      jdbcTemplate.update(preparedStatementCreator,holder);
      return holder.getKey().intValue();
    }
  }
}
