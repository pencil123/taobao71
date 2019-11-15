package com.taobao71.tb71.Controllers;

import java.io.UnsupportedEncodingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lyzhang
 * @since 2019/11/15 10:22
 */
@RestController
@RequestMapping("/search")
public class Search {
  @Autowired
  TaoKe taoKe;
  static Logger logger = LoggerFactory.getLogger(Search.class);

  @RequestMapping("/spring/")
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
