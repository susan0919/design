package com.example.design.designCombat.orderState;

import com.example.design.designCombat.OrderInfoDTO;
import com.example.design.designCombat.dao.OrderInfoDao;

public abstract class AbstractOrderState implements OrderState {
    protected OrderInfoDao orderInfoDao;

    public AbstractOrderState(OrderInfoDao orderInfoDao) {
        this.orderInfoDao = orderInfoDao;
    }

    @Override
    public void doTransition(OrderInfoDTO orderInfoDTO) {
        Integer orderStatus = getOrderStatus(orderInfoDTO);
        orderInfoDTO.setOrderStatus(orderStatus);
//        orderInfoDao.update();
    }

    protected abstract Integer getOrderStatus(OrderInfoDTO orderInfoDTO);
}
