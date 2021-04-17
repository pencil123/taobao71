package com.taobao71.tb71.model.vo;

import org.springframework.stereotype.Component;

/**
 * 淘口令对象；不存入数据库
 */
@Component
public class Tpwd {
    private String model;
    private String passwordSimple;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPasswordSimple() {
        return passwordSimple;
    }

    public void setPasswordSimple(String passwordSimple) {
        this.passwordSimple = passwordSimple;
    }
}
