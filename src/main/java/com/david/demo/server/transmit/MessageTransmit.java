package com.david.demo.server.transmit;

/**
 * 报文值传递类
 *
 * @2018-11-29
 * @David
 */
public class MessageTransmit {
    private boolean success;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void init(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
