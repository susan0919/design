package com.example.design.designCombat;

import com.example.design.designCombat.orderState.CanceledOrderState;
import com.example.design.designCombat.orderState.OrderState;
import com.example.design.designCombat.orderState.WaitForPayOrderState;

public class OrderStateManagerImpl implements OrderStateManager {

    private CanceledOrderState canceledOrderState;
    private WaitForPayOrderState waitForPayOrderState;

    public void create(OrderInfoDTO orderInfoDTO) {

    }

    @Override
    public Boolean canCancel(OrderInfoDTO orderInfoDTO) {
        return null;
    }

    @Override
    public void cancel(OrderInfoDTO orderInfoDTO) {

    }

//    private OrderState getOrderState(OrderInfoDTO orderInfoDTO) {
////        return orderInfoDTO.getOrderStatus();
//    }
}
