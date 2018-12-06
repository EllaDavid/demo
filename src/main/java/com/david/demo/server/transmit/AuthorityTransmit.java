package com.david.demo.server.transmit;

import com.david.demo.database.prototype.User;

/**
 * 权限值传递类
 *
 * @2018-11-29
 * @David
 */
public class AuthorityTransmit {
    private boolean success;
    private String message;

    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void init(boolean success, String message, User user) {
        this.success = success;
        this.message = message;
        this.user = user;
    }
}
