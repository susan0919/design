package com.example.design.bridgeMethod;

public abstract class AbstractMessage {

    public IMessage message;

    public AbstractMessage(IMessage message) {
        this.message = message;
    }

    public void sendMessage(String msg, String toUser) {
        this.message.send(msg, toUser);
    }
}
