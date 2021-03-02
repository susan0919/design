package com.example.design.designCombat;

public interface OrderStateManager {

    void create(OrderInfoDTO orderInfoDTO);

    Boolean canCancel(OrderInfoDTO orderInfoDTO);

    void cancel(OrderInfoDTO orderInfoDTO);

}
