package com.taobao71.tb71;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
public class test3 {
  static Logger logger = LoggerFactory.getLogger(test3.class);
  public static void main(String[] args) {
    String words= "1516986828629419750";
   // String pattern = "([\\w\\.]+)?[^\\u0000-\\uFFFF]?([\\W}]+)?([a-zA-Z0-9]+)([\\p{Sc}]+)?[^\\u0000-\\uFFFF]?";
   //String pattern = "([\\w\\.]+)?[^\\u0000-\\uFFFF]?([\\W])?([a-zA-Z0-9]+)([\\W])?[^\\u0000-\\uFFFF]?";
    String pattern = "\\d{18,21}";
    logger.info("接受到的消息：{}",words);
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(words);

    if(words.matches("\\d{18,21}")) {
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
