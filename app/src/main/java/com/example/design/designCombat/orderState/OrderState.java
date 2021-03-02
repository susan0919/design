package com.example.design.designCombat.orderState;

import com.example.design.designCombat.OrderInfoDTO;

public interface OrderState {
    void doTransition(OrderInfoDTO orderInfoDTO);

    boolean canCancel(OrderInfoDTO orderInfoDTO);

}
