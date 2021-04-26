package com.taobao71.tb71.exception;

import com.taobao71.tb71.Utils.SpringUtils;
import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.util.StringUtils;

/**
 * 异常封装
 *
 * @author 20113368
 * @date 2021/1/18 14:52
 */
public interface ExceptionResolvable {

  /**
   * 获取code
   */
  Integer getCode();

  /**
   * 获取message
   */
  String getMessage();

  /**
   * 默认信息
   */
  default String getMessage(String message) {

    MessageSource messageSource = SpringUtils.getBean(ReloadableResourceBundleMessageSource.class);
    Locale locale = LocaleContextHolder.getLocale();
    String localeMessage = messageSource.getMessage(message, null, "", locale);
    if (StringUtils.isEmpty(localeMessage)) {
      localeMessage = message;
    }
    return localeMessage;
  }
}
