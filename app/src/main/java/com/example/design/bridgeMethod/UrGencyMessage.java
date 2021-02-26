package com.example.design.bridgeMethod;

public class UrGencyMessage extends AbstractMessage {

    public UrGencyMessage(IMessage message) {
        super(message);
    }

    @Override
    public void sendMessage(String msg, String toUser) {
        msg = "[加急]" + msg;
        super.sendMessage(msg, toUser);
    }
}
