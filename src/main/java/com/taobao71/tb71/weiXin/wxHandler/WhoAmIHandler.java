package com.taobao71.tb71.weiXin.wxHandler;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxUserList;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;
import java.util.Map;

public class WhoAmIHandler implements WxMessageHandler {
  @Override
  public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, IService iService) throws WxErrorException {
    return WxXmlOutMessage.TEXT().content(wxMessage.getContent()).toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
  }
}
