package com.david.demo.socket.demo;

import com.david.demo.socket.IMessageAction;

public class HandleDemo implements IMessageAction {
    @Override
    public void doAction(String message) {
        System.out.println(message);
    }
}
