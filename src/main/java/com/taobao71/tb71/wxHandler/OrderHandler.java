package com.taobao71.tb71.wxHandler;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;

import com.soecode.wxtools.exception.WxErrorException;
import com.taobao71.tb71.dao.OrderServer;
import com.taobao71.tb71.dao.UserServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class OrderHandler implements WxMessageHandler {

  @Autowired
  private UserServer userServer;
  @Autowired
  private OrderServer orderServer;

  public static OrderHandler tbUrlHandler;

  @PostConstruct
  public void init() {
    tbUrlHandler = this;
    tbUrlHandler.userServer = this.userServer;
    tbUrlHandler.orderServer = this.orderServer;
  }

  static Logger logger = LoggerFactory.getLogger(OrderHandler.class);

  @Override
  public WxXmlOutMessage handle(
      WxXmlMessage wxMessage, Map<String, Object> context, IService iService)
      throws WxErrorException {
    String orderId = wxMessage.getContent();
    logger.info("接受到的订单ID：{}",orderId);
    Integer userId = tbUrlHandler.userServer.addUser(wxMessage.getFromUserName());
    Integer resultId = tbUrlHandler.orderServer.addOrder(Long.valueOf(orderId),userId);
// 0:插入成功； 1：已经存在；2：插入失败
    if( resultId == 0){
      return WxXmlOutMessage.TEXT().content("订单信息已记录，24小时内会同步订单信息，请耐心等待！").toUser(wxMessage.getFromUserName())
              .fromUser(wxMessage.getToUserName()).build();
    }else if( resultId ==1){
      return WxXmlOutMessage.TEXT().content("订单已经存在，请勿重复提交！").toUser(wxMessage.getFromUserName())
              .fromUser(wxMessage.getToUserName()).build();
    }else {
      return WxXmlOutMessage.TEXT().content("订单接受失败，请稍后重试！").toUser(wxMessage.getFromUserName())
              .fromUser(wxMessage.getToUserName()).build();
    }
  }

}
