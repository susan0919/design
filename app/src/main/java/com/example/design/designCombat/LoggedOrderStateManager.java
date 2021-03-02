package com.example.design.designCombat;

public class LoggedOrderStateManager implements OrderStateManager {

    private OrderStateManagerImpl orderStateManager;
//    private OrderOperateLogDao

    @Override

    public void create(OrderInfoDTO orderInfoDTO) {

    }

    @Override
    public Boolean canCancel(OrderInfoDTO orderInfoDTO) {
        return null;
    }

    @Override
    public void cancel(OrderInfoDTO orderInfoDTO) {

    }
}
