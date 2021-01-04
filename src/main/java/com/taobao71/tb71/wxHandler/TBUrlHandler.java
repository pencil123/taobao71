package com.taobao71.tb71.wxHandler;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.bean.WxXmlOutNewsMessage;
import com.soecode.wxtools.bean.outxmlbuilder.NewsBuilder;
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
    return createNewsResponse(wxMessage);
    //return WxXmlOutMessage.TEXT().content(m.group(1)).toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
  }

  private WxXmlOutMessage createNewsResponse(WxXmlMessage wxMessage) throws WxErrorException{
    NewsBuilder newsBuilder = WxXmlOutMessage.NEWS();

    WxXmlOutNewsMessage.Item item = new WxXmlOutNewsMessage.Item();
    item.setTitle("title item");
    item.setDescription("Descripton tiem");
    item.setUrl("https://www.baidu.com");
    item.setPicUrl("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg22.hc360.cn%2F22%2Fcorpinfo%2F202%2F469%2Fb%2F22-2024692.jpg&refer=http%3A%2F%2Fimg22.hc360.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1612341860&t=d98e01a20d7ea20f1e7f69ac9aa5ab24");
    newsBuilder.addArticle(item);

    return newsBuilder.toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
  }
}
