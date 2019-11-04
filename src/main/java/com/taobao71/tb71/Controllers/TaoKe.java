package com.taobao71.tb71.Controllers;

import com.taobao71.tb71.Service.TaokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyzhang
 * @since 2019/11/4 15:00
 */
@RestController
@RequestMapping("/taoke")
public class TaoKe {
  @Autowired
  private TaokeService taokeService;

  @RequestMapping("/")
  public String helloworld() {
    String searchkeyword = "女装";
    long pagenum = 1;
    taokeService.MaterialOptionalRequest(searchkeyword,pagenum);
    return "hel";
  }


}
