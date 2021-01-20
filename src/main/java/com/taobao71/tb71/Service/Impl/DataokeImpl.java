package com.taobao71.tb71.Service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao71.tb71.Service.Dataoke;
import com.taobao71.tb71.Utils.HttpUtil;
import com.taobao71.tb71.Utils.HttpUtils;
import com.taobao71.tb71.Utils.SignMD5Util;
import java.net.URISyntaxException;
import java.util.TreeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DataokeImpl implements Dataoke {
  static Logger logger = LoggerFactory.getLogger(DataokeImpl.class);

  @Value("${taoke.appKey}")
  private String appKey;

  @Value("${taoke.appSecret}")
  private String appSecret;
  ;

  private static String sendReqNew(String url, String secret, TreeMap<String, String> paraMap){
    if(null == url || "".equals(url)){
      return "请求地址不能为空";
    }
    if(null == secret || "".equals(secret)){
      return "secret不能为空";
    }
    if(null == paraMap || paraMap.size() < 1){
      return "参数不能为空";
    }

    String timer = String.valueOf(System.currentTimeMillis());
    paraMap.put("timer", timer);
    paraMap.put("nonce", "110505");
    paraMap.put("signRan", SignMD5Util.getSignStrNew(paraMap, secret));
    String data = "";
    try {
      data = HttpUtils.sendGet(url, paraMap);
    } catch (RuntimeException e) {
      e.printStackTrace();
    }

    return data;
  }

  private static String sendReq(String url, String secret, TreeMap<String, String> paraMap){
    if(null == url || "".equals(url)){
      return "请求地址不能为空";
    }
    if(null == secret || "".equals(secret)){
      return "secret不能为空";
    }
    if(null == paraMap || paraMap.size() < 1){
      return "参数不能为空";
    }

    paraMap.put("sign", SignMD5Util.getSignStr(paraMap, secret));
    String data = "";
    try {
      data = HttpUtil.httpGetRequest(url, paraMap);
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

    return data;
  }


  @Override
  public String preseContent(String tpwd) {
    String url = "https://openapi.dataoke.com/api/tb-service/parse-content";
    TreeMap<String, String> paraMap = new TreeMap<>();
    paraMap.put("version", "v1.0.0");
    paraMap.put("appKey", appKey);
    paraMap.put("content", tpwd);
    String data = DataokeImpl.sendReqNew(url, appSecret, paraMap);
    logger.info("获取返回结果：{}",data);
    JSONObject resultObject = JSONObject.parseObject(data);
    if(resultObject.getInteger("code") == 0){
      return resultObject.getJSONObject("data").getString("goodsId");
    }else{
      return null;
    }
  }
}
