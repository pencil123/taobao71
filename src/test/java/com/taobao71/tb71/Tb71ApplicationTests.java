package com.taobao71.tb71;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/*@RunWith(SpringRunner.class)*/
@SpringBootTest
public  class Tb71ApplicationTests {

    static Logger logger = LoggerFactory.getLogger(Tb71ApplicationTests.class);
    private     int counter = 1;
/*  @Test
  void contextLoads() {}*/
@Test
public  void main() {
    Thread t1 = new Thread(() -> {
        sendMsg("t1");
    },"t1");
    Thread t2 = new Thread(() -> {
        sendMsg("t2");
    },"t2");
    Thread t3 = new Thread(() -> {
        sendMsg("t3");
    },"t3");
    t1.start();
    t2.start();
    t3.start();
}

    public  void sendMsg(String keyStr) {
    Map<String,Object> objectMap = new HashMap<String,Object>();
    if(!objectMap.containsKey(keyStr)){
        objectMap.put(keyStr,new Object());
    }

    synchronized (objectMap.get(keyStr)){
        for(int i=1;i<30;i++) {
            logger.info("int i :{}",i);
            counter++;
            logger.info("counter:{}", counter);
            try {
                Thread.sleep(2000);
                counter++;
                logger.info("counter:{}", counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
                counter++;
                logger.info("counter:{}", counter);
            }
            counter++;
            logger.info("counter:{}", counter);
        }
    }
}
}
