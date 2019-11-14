package com.taobao71.tb71.Controllers;

import com.taobao71.tb71.Service.DataHandingService;
import com.taobao71.tb71.dao.MaterialDao;
import com.taobao71.tb71.domain.Material;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
  static Logger logger = LoggerFactory.getLogger(DataHandling.class);

  @RequestMapping("/")
  public String handing(){
    logger.info("DataHanding 处理数据");
    dataHandingService.updateCategoryID();
    return "Run success";
  }

  @RequestMapping("/guesslike")
  public String guesslike(){
    logger.info("DataHanding 猜你喜欢");
    dataHandingService.updateGuessLike();
    return "Run success";
  }
}
