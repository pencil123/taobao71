package com.taobao71.tb71.Service;

import com.taobao71.tb71.Controllers.TaoKe;
import com.taobao71.tb71.Controllers.WeChat;
import com.taobao71.tb71.dao.WeChatDao;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lyzhang
 * @since 2019/11/13 19:40
 */
@Service
public class WeChatService {

  @Autowired
  private WeChatDao weChatDao;
  @Autowired
  TaoKe taoKe;
  static Logger logger = LoggerFactory.getLogger(WeChat.class);
  /**
   * 解析微信发来的请求（XML）
   * @param request
   * @return map
   * @throws Exception
   */
  public Map<String,String> parseXml(HttpServletRequest request) throws Exception {
    // 将解析结果存储在HashMap中
    Map<String,String> map = new HashMap();
    // 从request中取得输入流
    InputStream inputStream = request.getInputStream();
    // 读取输入流
    SAXReader reader = new SAXReader();
    Document document = reader.read(inputStream);
    // 得到xml根元素
    Element root = document.getRootElement();
    // 得到根元素的所有子节点
    List<Element> elementList = root.elements();
    // 遍历所有子节点
    for (Element e : elementList) {
      map.put(e.getName(), e.getText());
    }
    // 释放资源
    inputStream.close();
    inputStream = null;
    return map;
  }

  /**
   * 根据消息类型 构造返回消息
   */
  public String buildXml(Map<String,String> map) {
    String result;
    String msgType = map.get("MsgType").toString();
    if(msgType.toUpperCase().equals("TEXT")){
      logger.info("Wechat# client input {}",map.get("Content"));
      Map<String,String> material = weChatDao.singleMaterial(map.get("Content"));
      if (!material.isEmpty()) {
        result = buildNewsMessage(map,material);
      } else {
        logger.info("Wechat# 没有找到关键词 : {}",map.get("Content"));
        Thread t = new Thread(new Runnable() {
          @Override
          public void run() {
            try{
              taoKe.materialBySelf(map.get("Content"));
            }catch (Exception e) {
              e.printStackTrace();
            }
          }});
        t.start();
        result = buildTextMessage(map, "暂时没有找到您要的优惠券，请几分钟后重试！");
      }
    }else{
      logger.info("Wechat# client input not TEXT :{}",msgType);
      result = buildTextMessage(map, "请输入您查找优惠券的关键词");
    }
    return result;
  }

  public String buildTextMessage(Map<String,String> map, String Content){
    String fromUserName = map.get("FromUserName");
    String toUserName = map.get("ToUserName");
    return  String
        .format(
            "<xml>" +
                "<ToUserName><![CDATA[%s]]></ToUserName>" +
                "<FromUserName><![CDATA[%s]]></FromUserName>" +
                "<CreateTime>%s</CreateTime>" +
                "<MsgType><![CDATA[text]]></MsgType>" +
                "<Content><![CDATA[%s]]></Content>" +
                "</xml>",
            fromUserName, toUserName, getUtcTime(),Content);
  }
  /**
   * 构造图文消息
   *
   * @param map
   * @param material map type
   * @return
   */
  private String buildNewsMessage(Map<String,String> map, Map<String,String> material) {
    //发送方帐号
    String fromUserName = map.get("FromUserName");
    // 开发者微信号
    String toUserName = map.get("ToUserName");

    String title = material.get("title");
    String description = material.get("description");
    String url = material.get("url");
    String img_url = material.get("img_url");
    /**
     * 文本消息XML数据格式
     */
    return String.format(
        "<xml>" +
            "<ToUserName><![CDATA[%s]]></ToUserName>" +
            "<FromUserName><![CDATA[%s]]></FromUserName>" +
            "<CreateTime>%s</CreateTime>" +
            "<MsgType><![CDATA[news]]></MsgType>" +
            "<ArticleCount>1</ArticleCount>" +
            "<Articles><item>" +
               " <Title><![CDATA[%s]]></Title>" +
               "<Description><![CDATA[%s]]></Description>" +
               "<PicUrl><![CDATA[%s]]></PicUrl>" +
               "<Url><![CDATA[%s]]></Url>" +
            " </item></Articles></xml>",
        fromUserName, toUserName, getUtcTime(),title,description,img_url,url);
  }

  private String getUtcTime() {
    Date dt = new Date();// 如果不需要格式,可直接用dt,dt就是当前系统时间
    DateFormat df = new SimpleDateFormat("yyyyMMddhhmm");// 设置显示格式
    String nowTime = df.format(dt);
    long dd = (long) 0;
    try {
      dd = df.parse(nowTime).getTime();
    } catch (Exception e) {
    }
    return String.valueOf(dd);
  }
}
