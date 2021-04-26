package com.taobao71.tb71.weiXin.wxMatcher;

import com.soecode.wxtools.api.WxMessageMatcher;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderMatcher implements WxMessageMatcher {
  static Logger logger = LoggerFactory.getLogger(OrderMatcher.class);
  @Override
  public boolean match(WxXmlMessage message) {
    if (StringUtils.isNotEmpty(message.getContent())) {
      if (message.getContent().matches("\\d{18,21}")) {
        return true;
      }
      return false;
    }
    return false;
  }
}
