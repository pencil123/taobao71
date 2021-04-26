package com.taobao71.tb71.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus配置
 *
 * @author 20113368
 * @date 2021/1/20 14:30
 */
@Configuration
@MapperScan("com.dts.paas.elasticer.mapper")
public class MybatisPlusConfig {

  @Bean
  public PaginationInterceptor paginationInterceptor() {
    PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
    // 开启 count 的 join 优化,只针对部分 left join
    paginationInterceptor.setSqlParser(new JsqlParserCountOptimize());
    return paginationInterceptor;
  }
}