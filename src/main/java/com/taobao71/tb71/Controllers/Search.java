package com.taobao71.tb71.Controllers;

import java.io.UnsupportedEncodingException;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao71.tb71.Service.TaobaoClientServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lyzhang
 * @since 2019/11/15 10:22
 */
@RestController
@ResponseBody
@Controller
@RequestMapping("/search")
public class Search {
  @Autowired
  TaoKe taoKe;
  static Logger logger = LoggerFactory.getLogger(Search.class);

  @Autowired
  private TaobaoClientServer taobaoClientServer;

  @GetMapping("hello")
  public String  getTest(){
    TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();
    req.setQ("man");
    req.setPageNo(Long.valueOf(1000));
//    req.setIncludePayRate30(true);
 //   req.setIsTmall(true);
 //   req.setSort("total_sales");
 //   req.setIsTmall(true)
 //   req.setHasCoupon(true);
    req.setPageSize(100L);
//    taobaoClientServer.test("hello");
   taobaoClientServer.searchMaterial(req);
   return  "hello";
  }

  @RequestMapping("spring")
  public ModelAndView test(@RequestParam(value = "keyword",required = false,defaultValue = "女装") String keyword){
    logger.info("Search# 搜索关键词: {}",keyword);
    Thread t = new Thread(new Runnable() {
      @Override
      public void run() {
        try{
          taoKe.materialBySelf(keyword);
        }catch (Exception e) {
          e.printStackTrace();
        }
      }});
    t.start();

    try{
      String encodeKeyword = java.net.URLEncoder.encode(keyword,"UTF-8");
      return new ModelAndView("redirect:/search/?keyword="+encodeKeyword);
    }catch (UnsupportedEncodingException e){
      System.out.println(e.getMessage());
      return new ModelAndView("/");
    }
  }
}
