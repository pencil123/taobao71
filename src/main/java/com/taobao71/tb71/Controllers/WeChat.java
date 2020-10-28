package com.taobao71.tb71.Controllers;


import com.taobao71.tb71.Service.WeChatService;
import com.taobao71.tb71.Utils.Helper;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyzhang
 * @since 2019/11/13 15:27
 */
@RestController
@RequestMapping("/wechat")
public class WeChat {
  @Autowired
  private WeChatService weChatService;
  static Logger logger = LoggerFactory.getLogger(WeChat.class);
  private final String TOKEN = "cherry";

  @RequestMapping(value = "auth",method = RequestMethod.GET)
  public void auth(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String signature = req.getParameter("signature");
    String timestamp = req.getParameter("timestamp");
    String nonce = req.getParameter("nonce");//随机数
    String echostr = req.getParameter("echostr");//随机字符串

    /**
     * 将token、timestamp、nonce三个参数进行字典序排序
     * 并拼接为一个字符串
     */
    String sortStr = Helper.sort(TOKEN, timestamp, nonce);
    System.out.println(sortStr);
    /**
     * 字符串进行shal加密
     */
    String mySignature = Helper.shal(sortStr);
    /**
     * 校验微信服务器传递过来的签名 和  加密后的字符串是否一致, 若一致则签名通过
     */
    if(!"".equals(signature) && !"".equals(mySignature) && signature.equals(mySignature)){
      logger.info("Wechat# 校验签名成功");
      resp.getWriter().write(echostr);
    }else {
      logger.info("Wechat# 校验签名失败");
    }
  }

/*  @RequestMapping(value = "auth",method = RequestMethod.POST)
  public String deal(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    try{
      Map<String,String> map = weChatService.parseXml(req);
      return weChatService.buildXml(map);
    }catch (Exception e){
      e.printStackTrace();
    }
    return "success";
  }*/
}
