package com.example.design.designCombat;

public class OrderInfoDTO {

    private OrderStateManager orderStateManager;

    public OrderInfoDTO save(OrderInfoDTO order) {
        if (!isStockEnough(order)) {
            return order;
        }
        saveOrder(order);
        orderStateManager.create(order);
        return order;
    }

    private void saveOrder(OrderInfoDTO order) {
    }

    private boolean isStockEnough(OrderInfoDTO orderInfoDTO) {
        return false;
    }

    public Integer getOrderStatus() {
        return 0;
    }

    public void setOrderStatus(Integer orderStatus) {
    }


    public static class OrderStatus {
        private static final int WAIT_FOR_PAY = 0;
//        private static final int WAIT_FOR_PAY=2;
    }
}
