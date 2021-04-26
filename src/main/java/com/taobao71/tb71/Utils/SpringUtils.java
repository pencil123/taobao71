package com.taobao71.tb71.Utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * spring工具类封装
 *
 * @author 20113368
 * @date 2021/1/18 14:52
 */
public class SpringUtils implements ApplicationContextAware {

  private static ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) {
    SpringUtils.applicationContext = applicationContext;
  }

  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }

  @SuppressWarnings("unchecked")
  public static <T> T getBean(String name) {
    return (T) applicationContext.getBean(name);
  }

  @SuppressWarnings("unchecked")
  public static <T> T getBean(Class<?> clz) {
    return (T) applicationContext.getBean(clz);
  }
}
