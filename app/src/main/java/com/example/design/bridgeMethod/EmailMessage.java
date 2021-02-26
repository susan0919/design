package com.example.design.bridgeMethod;

import android.util.Log;

public class EmailMessage implements IMessage {
    @Override
    public void send(String msg, String toUser) {
        Log.d("Bridge", "使用邮件消息发送" + msg + "给" + toUser);
    }
}
