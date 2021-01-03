package com.taobao71.tb71.Controllers.Impl;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxService;
import com.taobao71.tb71.Controllers.WeChatApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wxapi")
public class WeChatApiImpl implements WeChatApi {

  static Logger logger = LoggerFactory.getLogger(WeChatApiImpl.class);
  private IService iService = new WxService();

  @GetMapping("test")
  public String test(){
    return "Test Success";
  }

  @GetMapping("check")
  public String check(String signature, String timestamp, String nonce, String echostr)  {
    if (iService.checkSignature(signature, timestamp, nonce, echostr))  {
      logger.info("服务器地址接入成功！");
      return echostr;
    }
    return null;
  }
}
