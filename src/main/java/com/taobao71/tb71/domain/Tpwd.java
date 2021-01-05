package com.taobao71.tb71.domain;

import org.springframework.stereotype.Component;

/**
 * 淘口令对象；不存入数据库
 */
@Component
public class Tpwd {
    private String model;
    private String password_simple;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPassword_simple() {
        return password_simple;
    }

    public void setPassword_simple(String password_simple) {
        this.password_simple = password_simple;
    }
}
