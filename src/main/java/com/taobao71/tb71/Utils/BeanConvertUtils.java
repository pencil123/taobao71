package com.taobao71.tb71.Utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.taobao71.tb71.model.domain.Coupon;
import com.taobao71.tb71.model.vo.CouponResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * Bean转换
 *
 * @author 20113368
 * @date 2021/1/19 16:43
 */
public class BeanConvertUtils {

  private BeanConvertUtils() {
  }

  private static final Logger logger = LoggerFactory.getLogger(BeanConvertUtils.class);

  /**
   * @param source Object
   * @param targetClass Class
   * @param <T> T
   * @return T
   */
  public static <T> T copyProperties(Object source, Class<T> targetClass) {
    T doInstance = null;
    try {
      doInstance = targetClass.newInstance();
      BeanUtils.copyProperties(source, doInstance);
    } catch (Exception e) {
      logger.error("copyProperties error:{}", e);
    }
    return doInstance;
  }
}
