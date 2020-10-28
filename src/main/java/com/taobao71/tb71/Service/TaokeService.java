package com.taobao71.tb71.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkDgOptimusMaterialRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.request.TbkItemWordGetRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao.api.response.TbkDgOptimusMaterialResponse;
import com.taobao.api.response.TbkItemInfoGetResponse;
import com.taobao.api.response.TbkItemWordGetResponse;
import com.taobao71.tb71.Controllers.TaoKe;
import com.taobao71.tb71.dao.MaterialDao;
import com.taobao71.tb71.domain.Material;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * @author lyzhang
 * @since 2019/11/4 15:36
 */
@Service
public class TaokeService {
  @Value("${taobao.appkey}")
  private String appkey;
  @Value("${taobao.secret}")
  private String secret;
  @Value("${taobao.url}")
  private String url;
  @Value("${taobao.AdzoneID}")
  private Long adzoneid;

  @Autowired
  MaterialDao materialDao;

  static Logger logger = LoggerFactory.getLogger(TaokeService.class);


  /**
   * 获取商品信息
   * @param num_iids 商品的ID
   * @return
   */
  public Boolean goodsInfoGet(String num_iids) {
    TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
    TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
    req.setNumIids(num_iids);
    try {
      TbkItemInfoGetResponse rsp = client.execute(req);
      System.out.println(rsp.getBody());
    }catch (ApiException e) {
      e.printStackTrace();
    }
    return true;
  }

  public Boolean updateAllKeyword(){
    List item_ids = materialDao.getItems();
    Map<String, Long> item_info = new HashMap();
    for(int i=0;i<item_ids.size();i++){
      item_info = (Map<String, Long>) item_ids.get(i);
      updateKeyword(item_info.get("item_id"),item_info.get("id").intValue());
    }
    return true;
  }

  public Boolean updateKeyword(Long item_id,Integer good_id) {
    TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
    TbkItemWordGetRequest req = new TbkItemWordGetRequest();
    req.setAdzoneId(adzoneid);
    req.setCount(5L);
    req.setItemId(item_id);
    System.out.println(item_id);
    try{
      TbkItemWordGetResponse rsp = client.execute(req);
      System.out.println(rsp.getBody());
    } catch (ApiException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }


  public Boolean optimusMaterial(){
    TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
    TbkDgOptimusMaterialRequest req = new TbkDgOptimusMaterialRequest();
    req.setPageSize(20L);
    req.setAdzoneId(adzoneid);
    req.setPageNo(1L);
    req.setMaterialId(3767L);
/*    req.setDeviceValue("xxx");
    req.setDeviceEncrypt("MD5");
    req.setDeviceType("IMEI");*/
/*    req.setContentId(323L);
    req.setContentSource("xxx");
    req.setItemId(33243L);*/
    try {
      TbkDgOptimusMaterialResponse rsp = client.execute(req);
      System.out.println(rsp.getBody());
      return true;
    }catch (ApiException e) {
      return false;
    }
  }
}
