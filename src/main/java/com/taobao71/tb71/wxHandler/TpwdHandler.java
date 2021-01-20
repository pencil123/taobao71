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
import com.taobao71.tb71.dao.ItemWithoutCoupnServer;
import com.taobao71.tb71.domain.Coupon;
import com.taobao71.tb71.domain.Item;
import com.taobao71.tb71.domain.Tpwd;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TpwdHandler implements WxMessageHandler {
  @Autowired
  private TaokeServer taokeServer;
  @Autowired
  private Tpwd tpwd;
  @Autowired
  private TaobaoClientServer taobaoClientServer;
  @Autowired
  private ItemWithoutCoupnServer itemWithoutCoupnServer;

  public static TpwdHandler tbUrlHandler;
  @PostConstruct
  public void init(){
    tbUrlHandler = this;
    tbUrlHandler.tpwd = this.tpwd;
    tbUrlHandler.taobaoClientServer = this.taobaoClientServer;
    tbUrlHandler.taokeServer = this.taokeServer;
    tbUrlHandler.itemWithoutCoupnServer = this.itemWithoutCoupnServer;
  }

  static Logger logger = LoggerFactory.getLogger(WxMessageHandler.class);

  @Override
  public WxXmlOutMessage handle(
          WxXmlMessage wxMessage, Map<String, Object> context, IService iService) throws WxErrorException {
      String pattern = ".*(https://m.tb.cn/.+)\\s.+";
      String line = wxMessage.getContent();
      Pattern r = Pattern.compile(pattern);
      Matcher m = r.matcher(line);
      if (m.find()) {
          logger.info("Found Valuse:{}", m.group(0));
          logger.info("Found Valuse:{}", m.group(1));
      } else {
          logger.info("Not Match");
      }
      String itemId = m.group(1);

      return WxXmlOutMessage.TEXT().content(itemId).toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();

  }

}
