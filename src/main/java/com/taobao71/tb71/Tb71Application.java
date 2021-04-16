package com.taobao71.tb71;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.taobao71.tb71.mapper")
public class Tb71Application {
  public static void main(String[] args) {
    SpringApplication.run(Tb71Application.class, args);
  }
}
