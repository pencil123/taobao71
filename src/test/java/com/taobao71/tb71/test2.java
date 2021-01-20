package com.taobao71.tb71;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class test2 {
  static Logger logger = LoggerFactory.getLogger(test2.class);
  public static void main(String[] args) {
    String words= "5\uD83D\uDC48\uD83D\uDCB0wtXIcumwK7b¢\uD83D\uDC49淘了宝\uD83D\uDC48 https://m.tb.cn/h.4idHlIK?sm=bbda52【切条做的神器家用机用土豆";
    String pattern = "[^\\u0000-\\uFFFF]([\\p{Sc}])?([a-zA-Z0-9]+)([\\W]+)?[^\\u0000-\\uFFFF]";
    logger.info("接受到的消息：{}",words);
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(words);

    if(words.matches(".*https://m.tb.cn/.*")) {
      logger.info("匹配成功");
    }

    if (m.find()) {
      logger.info("Found Valuse:{}", m.group(0));
      logger.info("Found Valuse:{}", m.group(1));
      logger.info("Found Valuse:{}", m.group(2));
    } else {
      logger.info("Not Match");
    }
  }
}
