package com.example.design.designCombat.orderState;

import com.example.design.designCombat.OrderInfoDTO;

public class WaitForPayOrderState implements OrderState {
    @Override
    public void doTransition(OrderInfoDTO orderInfoDTO) {

    }

    @Override
    public boolean canCancel(OrderInfoDTO orderInfoDTO) {
        return false;
    }
}
