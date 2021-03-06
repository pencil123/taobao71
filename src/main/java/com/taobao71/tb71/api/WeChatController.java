package com.taobao71.tb71.api;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConsts;
import com.soecode.wxtools.api.WxMessageRouter;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.bean.result.WxCurMenuInfoResult;
import com.soecode.wxtools.exception.WxErrorException;
import com.soecode.wxtools.util.xml.XStreamTransformer;
import com.taobao71.tb71.Service.CouponServer;
import com.taobao71.tb71.Service.tk.TaokeServer;
import com.taobao71.tb71.model.vo.CouponPwdResp;
import com.taobao71.tb71.weiXin.wxHandler.KeywordHandler;
import com.taobao71.tb71.weiXin.wxHandler.OrderHandler;
import com.taobao71.tb71.weiXin.wxHandler.TBUrlHandler;
import com.taobao71.tb71.weiXin.wxHandler.TpwdHandler;
import com.taobao71.tb71.weiXin.wxHandler.WhoAmIHandler;
import com.taobao71.tb71.weiXin.wxMatcher.KeywordMatcher;
import com.taobao71.tb71.weiXin.wxMatcher.OrderMatcher;
import com.taobao71.tb71.weiXin.wxMatcher.TBUrlMatcher;
import com.taobao71.tb71.weiXin.wxMatcher.TpwdMatcher;
import com.taobao71.tb71.weiXin.wxMatcher.WhoAmIMatcher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wxapi")
public class WeChatController {
  private IService iService = new WxService();
  static Logger logger = LoggerFactory.getLogger(WeChatController.class);
  @Autowired
  private TaokeServer taokeServer;
  @Autowired
  private CouponServer couponServer;

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
          WxConsts.XML_MSG_TEXT).matcher(new WhoAmIMatcher()).handler(new WhoAmIHandler()).end()
          .rule().msgType(WxConsts.XML_MSG_TEXT).matcher(new OrderMatcher()).handler(new OrderHandler()).end()
          .rule().msgType(WxConsts.XML_MSG_TEXT).matcher(new TpwdMatcher()).handler(new TpwdHandler()).end()
          .rule().msgType(WxConsts.XML_MSG_TEXT).matcher(new TBUrlMatcher()).handler(new TBUrlHandler()).end()
          .rule().msgType(WxConsts.XML_MSG_TEXT).matcher(new KeywordMatcher()).handler(new KeywordHandler()).end();
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

  /**
   * 获取当前 GZH 菜单栏配置
   * @return
   */
  @GetMapping("curmenu")
  public WxCurMenuInfoResult gainCurMenuInfo(){
    try {
      WxCurMenuInfoResult result = iService.getMenuCurInfo();
      logger.info(result.toString());
      return result;
    } catch (WxErrorException e) {
      e.printStackTrace();
      return null;
    }
  }
  /**
   * 获取Coupon 信息
   * @param itemid
   * @return
   */
  @GetMapping("couponresp")
  public CouponPwdResp getCouponResp(@RequestParam(value = "itemid",required = true) String itemid){
    logger.info("the item_id param:{}",itemid);
    return  taokeServer.getCouponResp(itemid);
  }
}
