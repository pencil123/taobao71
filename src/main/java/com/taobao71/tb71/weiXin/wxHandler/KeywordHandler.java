package com.taobao71.tb71.weiXin.wxHandler;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.bean.WxXmlOutNewsMessage;
import com.soecode.wxtools.bean.outxmlbuilder.NewsBuilder;
import com.soecode.wxtools.exception.WxErrorException;
import com.taobao71.tb71.Service.ItemSearchServer;
import com.taobao71.tb71.model.domain.ItemSearch;
import com.taobao71.tb71.rabbitmq.Publisher;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KeywordHandler implements WxMessageHandler {
  @Autowired
  private Publisher publisher;
  @Autowired
  private ItemSearchServer itemSearchServer;
  public static KeywordHandler tbUrlHandler;

  @PostConstruct
  public void init(){
    tbUrlHandler = this;
    tbUrlHandler.publisher = this.publisher;
    tbUrlHandler.itemSearchServer = this.itemSearchServer;
  }

  static Logger logger = LoggerFactory.getLogger(WxMessageHandler.class);

  @Override
  public WxXmlOutMessage handle(
          WxXmlMessage wxMessage, Map<String, Object> context, IService iService) throws WxErrorException {
    String line = wxMessage.getContent();
    Long searchId = System.currentTimeMillis();
    logger.info("获取参数keyword:{}",line);
    ItemSearch itemSearch =tbUrlHandler.itemSearchServer.getByKeyword(line);
    if(itemSearch == null){
      ItemSearch itemSearch1 = new ItemSearch();
      itemSearch1.setKeyword(line);
      itemSearch1.setSearchId(searchId);
      tbUrlHandler.itemSearchServer.save(itemSearch1);
      Map<String, String> map = new HashMap<>();
      map.put("type", "searchCouponByKeyword");
      map.put("keyword", line);
      map.put("searchId", String.valueOf(searchId));
      tbUrlHandler.publisher.sendMapMesssage(map);
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }else{
      searchId = itemSearch.getSearchId();
    }
    NewsBuilder newsBuilder = WxXmlOutMessage.NEWS();
    WxXmlOutNewsMessage.Item item = new WxXmlOutNewsMessage.Item();
    item.setTitle(line);
    item.setDescription(line);
    item.setUrl("http://api.taobao71.com/wx/recommend/#" + String.valueOf(searchId));
    item.setPicUrl("http://api.taobao71.com/favicon.ico");
    newsBuilder.addArticle(item);
    return newsBuilder.toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
  }
}
