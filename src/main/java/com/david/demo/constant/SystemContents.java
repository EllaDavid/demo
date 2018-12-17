package com.david.demo.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 系统常量
 * @2018-12-17
 * @David
 */
@Component
@ConfigurationProperties(prefix = "com.david.const")
public class SystemContents {
    private String bankCode;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
}
