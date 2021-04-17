package com.taobao71.tb71.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@TableName(value = "order_tk")
public class Order {
    @TableId(type= IdType.AUTO)
    private Long orderid;
    private int userId;
    private Long itemId;
    private Timestamp payTime;
    private float payMoney;
    private float guessIncome;
    private float income;

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    public float getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(float payMoney) {
        this.payMoney = payMoney;
    }

    public float getGuessIncome() {
        return guessIncome;
    }

    public void setGuessIncome(float guessIncome) {
        this.guessIncome = guessIncome;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}
