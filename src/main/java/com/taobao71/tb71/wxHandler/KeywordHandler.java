package com.taobao71.tb71.wxHandler;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.bean.WxXmlOutNewsMessage;
import com.soecode.wxtools.bean.outxmlbuilder.NewsBuilder;
import com.soecode.wxtools.exception.WxErrorException;
import com.taobao71.tb71.Service.TaobaoClientServer;
import com.taobao71.tb71.Service.TaokeServer;
import com.taobao71.tb71.dao.ItemSearchServer;
import com.taobao71.tb71.dao.ItemWithoutCoupnServer;
import com.taobao71.tb71.domain.Coupon;
import com.taobao71.tb71.domain.ItemSearch;
import com.taobao71.tb71.domain.Tpwd;
import com.taobao71.tb71.rabbitmq.Publisher;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
  @Autowired
  private ItemSearch itemSearch;

  public static KeywordHandler tbUrlHandler;


  @PostConstruct
  public void init(){
    tbUrlHandler = this;
    tbUrlHandler.publisher = this.publisher;
    tbUrlHandler.itemSearchServer = this.itemSearchServer;
    tbUrlHandler.itemSearch = this.itemSearch;
  }

  static Logger logger = LoggerFactory.getLogger(WxMessageHandler.class);

  @Override
  public WxXmlOutMessage handle(
          WxXmlMessage wxMessage, Map<String, Object> context, IService iService) throws WxErrorException {
    String line = wxMessage.getContent();
    Long searchId = System.currentTimeMillis();

    tbUrlHandler.itemSearch.setKeyword(line);
    tbUrlHandler.itemSearch.setSearch_id(searchId);
    Long realSearchId = tbUrlHandler.itemSearchServer.addItemSearch(tbUrlHandler.itemSearch);
    if (realSearchId != searchId) {
      searchId = realSearchId;
    } else {
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
