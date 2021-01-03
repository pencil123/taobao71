package com.taobao71.tb71.Controllers;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxService;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 微信接口调用
 */
public interface WeChatApi {
  /**
   * 服务器端验证接口  Get 请求
   * @param signature
   * @param timestamp
   * @param nonce
   * @param echostr
   * @return
   */
  public String check(String signature, String timestamp, String nonce, String echostr) ;

  /**
   * 接受客户端发送的信息 Post 请求
   * @param request
   * @param response
   */
  public void handle(HttpServletRequest request, HttpServletResponse response);
}
