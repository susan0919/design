package com.example.design.designCombat.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class OrderInfo {
    private int OrderId;
    private String orderName;
    private String orderTime;

    @Generated(hash = 2083649068)
    public OrderInfo(int OrderId, String orderName, String orderTime) {
        this.OrderId = OrderId;
        this.orderName = orderName;
        this.orderTime = orderTime;
    }

    @Generated(hash = 1695813404)
    public OrderInfo() {
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }
}
