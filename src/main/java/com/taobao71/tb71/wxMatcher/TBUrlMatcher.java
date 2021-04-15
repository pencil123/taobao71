package com.taobao71.tb71.wxMatcher;

import com.soecode.wxtools.api.WxMessageMatcher;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TBUrlMatcher implements WxMessageMatcher {
  static Logger logger = LoggerFactory.getLogger(TBUrlMatcher.class);
  @Override
  public boolean match(WxXmlMessage message) {
    if (StringUtils.isNotEmpty(message.getContent())) {

      if (message.getContent().matches("https://item.taobao.com/item.htm\\?id=\\d+")) {
        return true;
      }
      return false;
    }
    return false;
  }
}
