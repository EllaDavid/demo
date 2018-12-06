package com.david.demo.controller.request;

/**
 * 用户登录请求
 *
 * @2018-11-29
 * @David
 */
public class LoginRequest {
    private String empno;
    private String password;

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
