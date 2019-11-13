package com.taobao71.tb71.dao;

import org.springframework.beans.factory.annotation.Autowired;
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
}
