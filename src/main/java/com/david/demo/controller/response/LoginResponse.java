package com.david.demo.controller.response;

import com.david.demo.server.transmit.AuthorityTransmit;

/**
 * 用户登录响应
 *
 * @2018-11-29
 * @David
 */
public class LoginResponse {
    private boolean success;
    private String message;
    private long groupId;
    private String groupName;
    private long userId;
    private String userName;
    private long departmentId;
    private String departmentName;

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

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void init(AuthorityTransmit authorityTransmit) {
        this.success = authorityTransmit.isSuccess();
        this.message = authorityTransmit.getMessage();
        this.groupId = authorityTransmit.getUser().getUserGroup().getId();
        this.groupName = authorityTransmit.getUser().getUserGroup().getName();
        this.userId = authorityTransmit.getUser().getId();
        this.userName = authorityTransmit.getUser().getName();
        this.departmentId = authorityTransmit.getUser().getDepartment().getId();
        this.departmentName = authorityTransmit.getUser().getDepartment().getName();
    }

    public void init(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
