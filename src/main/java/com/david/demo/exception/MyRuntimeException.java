package com.david.demo.exception;

/**
 * 自定义异常
 *
 * @2018-11-29
 * @David
 */
public class MyRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -2725000258208819707L;

    public MyRuntimeException(String message) {
        super("运行时报错: " + message);
    }

    public MyRuntimeException(String type, String message) {
        super(type + ": " + message);
    }
}
