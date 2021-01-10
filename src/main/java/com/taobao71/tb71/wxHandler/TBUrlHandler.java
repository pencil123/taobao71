package com.taobao71.tb71.wxHandler;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.bean.WxXmlOutNewsMessage;
import com.soecode.wxtools.bean.outxmlbuilder.NewsBuilder;
import com.soecode.wxtools.exception.WxErrorException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.taobao71.tb71.Service.TaobaoClientServer;
import com.taobao71.tb71.Service.TaokeServer;
import com.taobao71.tb71.domain.Coupon;
import com.taobao71.tb71.domain.Tpwd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TBUrlHandler implements WxMessageHandler {
  @Autowired
  private TaokeServer taokeServer;
  @Autowired
  private Tpwd tpwd;
  @Autowired
  private TaobaoClientServer taobaoClientServer;

  public static TBUrlHandler tbUrlHandler;
  @PostConstruct
  public void init(){
    tbUrlHandler = this;
    tbUrlHandler.tpwd = this.tpwd;
    tbUrlHandler.taobaoClientServer = this.taobaoClientServer;
    tbUrlHandler.taokeServer = this.taokeServer;
  }

  static Logger logger = LoggerFactory.getLogger(WxMessageHandler.class);

  @Override
  public WxXmlOutMessage handle(
          WxXmlMessage wxMessage, Map<String, Object> context, IService iService) throws WxErrorException {
      String pattern = "https://item.taobao.com/item.htm\\?id=(\\d+)";
      String line = wxMessage.getContent();
      Pattern r = Pattern.compile(pattern);
      Matcher m = r.matcher(line);

      if (m.find()) {
          logger.info("Found Valuse:{}", m.group(0));
          logger.info("Found Valuse:{}", m.group(1));
      } else {
          logger.info("Not Match");
      }

      Coupon coupon = tbUrlHandler.taokeServer.getCouponByItemId(m.group(1));
      if (coupon != null) {
          return createNewsResponse(wxMessage, coupon);
      } else if (tbUrlHandler.taokeServer.ItemExists(m.group(1))) {
          return WxXmlOutMessage.TEXT().content("抱歉，此商品没有优惠券！").toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
      } else{
          try {
              Thread.sleep(2000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          coupon = tbUrlHandler.taokeServer.getCouponByItemId(m.group(1));
          if (coupon != null) {
              return createNewsResponse(wxMessage, coupon);
          } else if (tbUrlHandler.taokeServer.ItemExists(m.group(1))) {
              return WxXmlOutMessage.TEXT().content("抱歉，此商品没有优惠券！").toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
          }else{
              return WxXmlOutMessage.TEXT().content("正在查找优惠券，请稍后两分钟重试。").toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
          }
      }
  }

  private WxXmlOutMessage createNewsResponse(WxXmlMessage wxMessage,Coupon coupon) throws WxErrorException{
    NewsBuilder newsBuilder = WxXmlOutMessage.NEWS();
    Tpwd tpwd = tbUrlHandler.taobaoClientServer.gainTpwd("https:" + coupon.getCoupon_share_url());

    WxXmlOutNewsMessage.Item item = new WxXmlOutNewsMessage.Item();
    item.setTitle(coupon.getTitle());
    item.setDescription(coupon.getCoupon_info());
    item.setUrl("http://api.taobao71.com/wx/coupon#" + coupon.getItem_id());
    String imgUrl = coupon.getPict_url().replace("s://img.alicdn","://img.taobao71");
    item.setPicUrl(imgUrl + "_100x100.jpg");
    newsBuilder.addArticle(item);

    return newsBuilder.toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
  }

}
