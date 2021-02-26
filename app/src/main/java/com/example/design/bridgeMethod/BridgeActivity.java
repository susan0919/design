package com.example.design.bridgeMethod;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.design.R;

public class BridgeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridge);
    }

    public void onNormalMsgSend(View view) {
        IMessage message = new SmsMessage();
        AbstractMessage abstractMessage = new NormalMessage(message);
        abstractMessage.sendMessage("加班申请速批", "C语言中文网严总");
    }

    public void onUrgencyMsgSend(View view) {
        IMessage message = new EmailMessage();
        AbstractMessage abstractMessage = new UrGencyMessage(message);
        abstractMessage.sendMessage("加班申请速批", "C语言中文网严总");

    }
}
