package com.taobao71.tb71.weiXin.wxMatcher;

import com.soecode.wxtools.api.WxMessageMatcher;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TpwdMatcher implements WxMessageMatcher {

  static Logger logger = LoggerFactory.getLogger(TpwdMatcher.class);
  @Override
  public boolean match(WxXmlMessage message) {
    logger.info("获取信息：{}",message.getContent());
    if (StringUtils.isNotEmpty(message.getContent())) {
      if (message.getContent().matches(".*https://m.tb.cn/.*")) {
        return true;
      }
      return false;
    }
    return false;
  }
}
