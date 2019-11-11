package com.taobao71.tb71.Controllers;

import com.taobao71.tb71.Service.DataHandingService;
import com.taobao71.tb71.dao.MaterialDao;
import com.taobao71.tb71.domain.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyzhang
 * @since 2019/11/7 10:33
 */
@RestController
@RequestMapping("/datahanding")
public class DataHandling {
  @Autowired
  DataHandingService dataHandingService;

  @RequestMapping("/")
  public String handing(){
    dataHandingService.updateCategoryID();
    return "Run success";
  }

  @RequestMapping("/guesslike")
  public String guesslike(){
    dataHandingService.updateGuessLike();
    return "Run success";
  }
}
