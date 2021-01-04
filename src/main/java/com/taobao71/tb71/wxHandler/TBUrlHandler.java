package com.taobao71.tb71.wxHandler;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;
import com.taobao71.tb71.Controllers.Impl.WeChatApiImpl;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TBUrlHandler implements WxMessageHandler {

  static Logger logger = LoggerFactory.getLogger(WxMessageHandler.class);

  @Override
  public WxXmlOutMessage handle(
      WxXmlMessage wxMessage, Map<String, Object> context, IService iService) throws WxErrorException {
    String pattern = "https://item.taobao.com/item.htm\\?id=(\\d+)";
    String line = wxMessage.getContent();

    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(line);

    if (m.find()){
      logger.info("Found Valuse:{}",m.group(0));
      logger.info("Found Valuse:{}",m.group(1));
    } else {
      logger.info("Not Match");
    }
    return WxXmlOutMessage.TEXT().content(m.group(1)).toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
  }

}
