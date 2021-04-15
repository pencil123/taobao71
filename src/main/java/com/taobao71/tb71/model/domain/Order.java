package com.taobao71.tb71.model.domain;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class Order {
    private Long orderid;
    private int user_id;
    private Long item_id;
    private Timestamp pay_time;
    private float pay_money;
    private float guess_income;
    private float income;

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Timestamp getPay_time() {
        return pay_time;
    }

    public void setPay_time(Timestamp pay_time) {
        this.pay_time = pay_time;
    }

    public float getPay_money() {
        return pay_money;
    }

    public void setPay_money(float pay_money) {
        this.pay_money = pay_money;
    }

    public float getGuess_income() {
        return guess_income;
    }

    public void setGuess_income(float guess_income) {
        this.guess_income = guess_income;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}
