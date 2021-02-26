package com.example.design.bridgeMethod;

public class NormalMessage extends AbstractMessage {
    public NormalMessage(IMessage message) {
        super(message);
    }

    @Override
    public void sendMessage(String msg, String toUser) {
        super.sendMessage(msg, toUser);
    }
}
