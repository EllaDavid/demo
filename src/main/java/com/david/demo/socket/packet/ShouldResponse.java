package com.david.demo.socket.packet;

import com.david.demo.exception.MyRuntimeException;

/**
 * 年度正常缴费应征数查询返回
 * @2018-12-17
 * @David
 */
public class ShouldResponse extends Header{
    private String idCard;  // 20位身份证号码
    private String name;    // 20位姓名
    private String community;   // 50位村（社区）名称
    private String balance; // 16位应该金额
    private String overallPlanning; // 6位统筹区编码（可空）
    private String socialCode;  // 10位社保编号

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getOverallPlanning() {
        return overallPlanning;
    }

    public void setOverallPlanning(String overallPlanning) {
        this.overallPlanning = overallPlanning;
    }

    public String getSocialCode() {
        return socialCode;
    }

    public void setSocialCode(String socialCode) {
        this.socialCode = socialCode;
    }

    public void init(String message) {
        String[] fields = message.split("\\|");

        if(fields.length != 11) {
            throw new MyRuntimeException("socket: " + "报文接收数据格式不正确-报文项数量不对!");
        }

        super.init(fields[0], fields[1], fields[2], fields[3], fields[4]);
        this.idCard = fields[5];
        this.name = fields[6];
        this.community = fields[7];
        this.balance = fields[8];
        this.overallPlanning = fields[9];
        this.socialCode = fields[10];
    }
}
