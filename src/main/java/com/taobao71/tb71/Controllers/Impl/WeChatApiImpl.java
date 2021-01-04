package com.taobao71.tb71.Controllers.Impl;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConsts;
import com.soecode.wxtools.api.WxMessageRouter;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.util.xml.XStreamTransformer;
import com.taobao71.tb71.Controllers.WeChatApi;
import com.taobao71.tb71.wxHandler.WhoAmIHandler;
import com.taobao71.tb71.wxMatcher.WhoAmIMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/wxapi")
public class WeChatApiImpl implements WeChatApi {

  private IService iService = new WxService();
  static Logger logger = LoggerFactory.getLogger(WeChatApiImpl.class);

  @GetMapping
  public String check(String signature, String timestamp, String nonce, String echostr)  {
    if (iService.checkSignature(signature, timestamp, nonce, echostr))  {
      logger.info("服务器地址接入成功！");
      return echostr;
    }
    return null;
  }


  @PostMapping
  public void handle(HttpServletRequest request, HttpServletResponse response) {
    PrintWriter out = null;
    try {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      out = response.getWriter();

      // 微信服务器推送过来的是XML格式。
      WxXmlMessage wx = XStreamTransformer.fromXml(WxXmlMessage.class, request.getInputStream());
      logger.info("消息：{}",wx.toString());

      WxMessageRouter router = new WxMessageRouter(iService);

      router.rule().msgType(
          WxConsts.XML_MSG_TEXT).matcher(new WhoAmIMatcher()).handler(new WhoAmIHandler()).end();
      // 把消息传递给路由器进行处理
      WxXmlOutMessage xmlOutMsg = router.route(wx);

      if(xmlOutMsg != null){
        out.print(xmlOutMsg.toXml());
      }
    }catch (IOException  e){
      logger.error("接受到的消息解码失败");
    }catch (Exception e) {
      e.printStackTrace();
    } finally {
      out.close();
    }
  }
}
