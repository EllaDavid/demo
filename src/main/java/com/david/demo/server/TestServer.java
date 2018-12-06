package com.david.demo.server;

import com.david.demo.socket.IMessageAction;
import com.david.demo.socket.SocialSecuritySocket;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 测试服务
 */
@Service
public class TestServer implements IMessageAction {
    private boolean standby = true;
    private SocialSecuritySocket socialSecuritySocket = new SocialSecuritySocket("127.0.0.1", 9527);

    public void action() {
        try {
            socialSecuritySocket.start();
            socialSecuritySocket.sendMessage("TEST");

            socialSecuritySocket.addAction("aaa", this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(standby) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void doAction(String message) {
        standby = false;
    }
}
