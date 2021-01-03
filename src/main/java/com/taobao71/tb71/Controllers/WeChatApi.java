package com.taobao71.tb71.Controllers;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxService;
import org.springframework.web.bind.annotation.GetMapping;

public interface WeChatApi {
  public String test();
  public String check(String signature, String timestamp, String nonce, String echostr) ;
}
