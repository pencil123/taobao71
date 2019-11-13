package com.taobao71.tb71.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author lyzhang
 * @since 2019/11/13 16:01
 */
public class Helper {
  /**
   * 参数排序
   * @param token
   * @param timestamp
   * @param nonce
   * @return
   */
  public static String sort(String token, String timestamp, String nonce) {
    String[] strArray = {token, timestamp, nonce};
    Arrays.sort(strArray);
    StringBuilder sb = new StringBuilder();
    for (String str : strArray) {
      sb.append(str);
    }
    return sb.toString();
  }

  /**
   * 字符串进行shal加密
   * @param str
   * @return
   */
  public static String shal(String str){
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-1");
      digest.update(str.getBytes());
      byte messageDigest[] = digest.digest();

      StringBuffer hexString = new StringBuffer();
      // 字节数组转换为 十六进制 数
      for (int i = 0; i < messageDigest.length; i++) {
        String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
        if (shaHex.length() < 2) {
          hexString.append(0);
        }
        hexString.append(shaHex);
      }
      return hexString.toString();

    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return "";
  }
}
