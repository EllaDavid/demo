package com.david.demo.socket.packet;

/**
 * 年度正常缴费应征数查询
 * @2018-12-17
 * @David
 */
public class ShouldRequest extends Header {
    private String idCard;  // 20位社保编码（身份证号码）
    private String paymentGrade;    // 4位缴费档次
    private String bankCode;    // 4位银行编码

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPaymentGrade() {
        return paymentGrade;
    }

    public void setPaymentGrade(String paymentGrade) {
        this.paymentGrade = paymentGrade;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public void init(String code, String result, String serialNumber, String fileLength, String fileName, String idCard,
                     String paymentGrade, String bankCode) {
        super.init(code, result, serialNumber, fileLength, fileName);
        this.idCard = idCard;
        this.paymentGrade = paymentGrade;
        this.bankCode = bankCode;
    }

    @Override
    public String toString() {
        String strHeader = super.toString();
        String strBody = String.format("%20s|%4s|%4s", idCard, paymentGrade, bankCode);

        return strHeader + strBody;
    }
}
