package com.example.design.factoryMethod;

public class PayFactory {

    public static PayChannel getPayChannel(String type) {
        PayChannel payChannel = null;
        switch (type) {
            case "wechat":
                payChannel = new WecharPay();
                break;
            case "aliy":
                payChannel = new AliPay();
                break;
            case "union":
                payChannel = new UnionPay();
                break;
            default:
                // do nothing
                break;
        }
        return payChannel;
    }

    public static PayChannel getEasyPaychannel(Class<? extends PayChannel> clz) {
        PayChannel payChannel = null;
        try {
            payChannel = (PayChannel) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return payChannel;
    }
}
