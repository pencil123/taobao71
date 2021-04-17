package com.taobao71.tb71.wxHandler;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.bean.WxXmlOutNewsMessage;
import com.soecode.wxtools.bean.outxmlbuilder.NewsBuilder;
import com.soecode.wxtools.exception.WxErrorException;
import com.taobao71.tb71.Service.tk.DataokeServer;
import com.taobao71.tb71.Service.tk.TaobaoClientServer;
import com.taobao71.tb71.Service.tk.TaokeServer;
import com.taobao71.tb71.model.domain.Coupon;
import com.taobao71.tb71.model.domain.Item;
import com.taobao71.tb71.model.vo.Tpwd;
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
  private DataokeServer dataokeServer;

  public static TpwdHandler tbUrlHandler;

  @PostConstruct
  public void init() {
    tbUrlHandler = this;
    tbUrlHandler.tpwd = this.tpwd;
    tbUrlHandler.taobaoClientServer = this.taobaoClientServer;
    tbUrlHandler.taokeServer = this.taokeServer;
    tbUrlHandler.dataokeServer = this.dataokeServer;
  }

  static Logger logger = LoggerFactory.getLogger(TpwdHandler.class);

  @Override
  public WxXmlOutMessage handle(
      WxXmlMessage wxMessage, Map<String, Object> context, IService iService)
      throws WxErrorException {
    String pattern = "([\\w\\.]+)?[^\\u0000-\\uFFFF]?([\\W])?([a-zA-Z0-9]+)([\\W])?[^\\u0000-\\uFFFF]?";
    String line = wxMessage.getContent();
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(line);
    if (m.find()) {
      logger.info("Found Valuse:{}", m.group(0));
      logger.info("Found Valuse:{}", m.group(1));
      logger.info("Found Valuse:{}", m.group(2));
      logger.info("Found Valuse:{}", m.group(3));
    } else {
      logger.info("Not Match");
      return WxXmlOutMessage.TEXT().content("抱歉，此商品没有优惠券！").toUser(wxMessage.getFromUserName())
          .fromUser(wxMessage.getToUserName()).build();
    }
    String tPwd = m.group(3);
    String itemId = tbUrlHandler.dataokeServer.preseContent(tPwd);
    if(itemId == null){
      return  WxXmlOutMessage.TEXT().content("抱歉，此商品没有优惠券！").toUser(wxMessage.getFromUserName())
          .fromUser(wxMessage.getToUserName()).build();
    }

    Coupon coupon = tbUrlHandler.taokeServer.getCouponByItemId(itemId, true);
    Item item = tbUrlHandler.taokeServer.getItemByItemId(itemId);
    if (coupon != null || item != null) {
      return createNewsResponse(wxMessage, coupon, item);
    }
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    coupon = tbUrlHandler.taokeServer.getCouponByItemId(itemId, false);
    item = tbUrlHandler.taokeServer.getItemByItemId(itemId);
    if (coupon != null || item != null) {
      return createNewsResponse(wxMessage, coupon, item);
    } else {
      return WxXmlOutMessage.TEXT().content("抱歉，此商品没有优惠券！").toUser(wxMessage.getFromUserName())
          .fromUser(wxMessage.getToUserName()).build();
    }
  }

  private WxXmlOutMessage createNewsResponse(WxXmlMessage wxMessage, Coupon coupon, Item item)
      throws WxErrorException {
    NewsBuilder newsBuilder = WxXmlOutMessage.NEWS();
    String title, itemId, pictUrl;
    String desc = "";
    Double realPrice = 0.0;
    if (coupon != null) {
      title = coupon.getTitle();
      itemId = String.valueOf(coupon.getItemId());
      pictUrl = String.valueOf(coupon.getPictUrl());
      realPrice =
          Double.valueOf(coupon.getZkFinalPrice()) - Double.valueOf(coupon.getCouponAmount());
      desc = "券后：" + String.format("%.2f", realPrice) + "元\n";
      desc += "优惠：" + coupon.getCouponAmount() + "元券\n";
    } else {
      title = item.getTitle();
      itemId = String.valueOf(item.getItemId());
      pictUrl = String.valueOf(item.getPictUrl());
      desc = "券后：" + item.getZkFinalPrice() + "元\n";
      desc += "优惠：0元券\n";
    }
    logger.info("item info:{}", item.toString());
    if (realPrice == 0.0) {
      realPrice = Double.valueOf(item.getZkFinalPrice());
    }

    double ComRate = realPrice * Double.valueOf(item.getCommissionRate()) / 10000;
    desc += "佣金：" + String.format("%.2f", ComRate) + "元";

    WxXmlOutNewsMessage.Item itemMsg = new WxXmlOutNewsMessage.Item();
    itemMsg.setTitle(title);
    itemMsg.setDescription(desc);
    itemMsg.setUrl("http://api.taobao71.com/wx/coupon#" + itemId);
    String imgUrl = pictUrl.replace("s://img.alicdn", "://img.taobao71");
    itemMsg.setPicUrl(imgUrl + "_100x100.jpg");
    newsBuilder.addArticle(itemMsg);

    return newsBuilder.toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName())
        .build();
  }

}
