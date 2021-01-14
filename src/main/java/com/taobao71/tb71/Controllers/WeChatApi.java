package com.taobao71.tb71.Controllers;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.result.WxCurMenuInfoResult;
import com.taobao71.tb71.domain.CouponResp;
import com.taobao71.tb71.domain.ItemResp;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

  /**
   * 获取当前 GZH 菜单栏配置
   * @return
   */
  public WxCurMenuInfoResult gainCurMenuInfo();

  /**
   * 获取Coupon 信息
   * @param itemid
   * @return
   */
  public CouponResp getCouponResp(@RequestParam(value = "itemid",required = true) String itemid);

  /**
   * 获取搜索结果信息 item search
   */
  public List<ItemResp> searchItemResp(String searchid);
}
