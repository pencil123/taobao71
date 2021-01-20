package com.taobao71.tb71.Service;

import org.springframework.stereotype.Service;

/**
 * dataoke 调用
 */
@Service
public interface Dataoke {

  /**
   * 解析口令
   * @param tpwd
   * @return item_id
   */
  public String preseContent(String tpwd);
}
