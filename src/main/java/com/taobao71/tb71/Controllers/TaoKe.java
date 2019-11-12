package com.taobao71.tb71.Controllers;

import com.taobao71.tb71.Service.TaokeService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


  @RequestMapping("/materialall")
  public String materialAll(@RequestParam(value = "keyword",required = false,defaultValue = "女装") String keyword) {
    taokeService.materialOptionalAll(keyword);
    return "RUN success";
  }

  public String materialBySelf(String keyword) {
    taokeService.materialOptionalAll(keyword);
    return "RUN success";
  }

  @RequestMapping("/materialscan")
  public String materialScan(@RequestParam(value = "keyword",required = false,defaultValue = "女装") String keyword,
                             @RequestParam(value = "pagenum",required = false,defaultValue = "1") Long pagenum) {
    taokeService.materialOptionalRequest(keyword,pagenum);
    return "RUN success";
  }

  @RequestMapping("/goodsinfoget")
  public String goodsInfoGet(@RequestParam(value = "numids",required = true,defaultValue = "123") String str_iids) {
    System.out.println(str_iids);
/*    String[] iids = str_iids.split(",");
    for(String iid : iids) {
      Long.valueOf(iid);
    }*/
    taokeService.goodsInfoGet(str_iids);
    return "Run Success";
  }
}
