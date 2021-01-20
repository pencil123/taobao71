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
    String words= "3.0\uD83C\uDF81x2X0cumCeuI\uD83D\uDDDD\uD83D\uDC49䛬\uD83D\uDC48 https://m.tb.cn/h.4RsKidc?sm=dab2be";
   // String pattern = "([\\w\\.]+)?[^\\u0000-\\uFFFF]?([\\W}]+)?([a-zA-Z0-9]+)([\\p{Sc}]+)?[^\\u0000-\\uFFFF]?";
    String pattern = "([\\w\\.]+)?[^\\u0000-\\uFFFF]?([\\W])?([a-zA-Z0-9]+)([\\W])?[^\\u0000-\\uFFFF]?";
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
      logger.info("Found Valuse:{}", m.group(3));
    } else {
      logger.info("Not Match");
    }
  }
}
