package com.taobao71.tb71.wxMatcher;

import com.soecode.wxtools.api.WxMessageMatcher;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.util.StringUtils;

public class KeywordMatcher implements WxMessageMatcher {

  @Override
  public boolean match(WxXmlMessage message) {
    if (StringUtils.isNotEmpty(message.getContent())) {
      if (message.getContent().matches("^[A-Za-z0-9\\s]+$")) {
        return false;
      }
      return true;
    }
    return false;
  }
}
