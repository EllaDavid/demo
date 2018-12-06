package com.david.demo.database.prototype;

import com.alibaba.fastjson.JSON;

import javax.persistence.*;

/**
 * 系统参数
 *
 * @2018-11-28
 * @David
 */
@Entity
@Table(
        indexes = {
                @Index(name = "index_code", columnList = "code"),
                @Index(name = "index_magicCode", columnList = "magic_code")
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_code_magicCode", columnNames = {"code", "magic_code"})
        }
)
public class Parameter extends Basic {
    private static final long serialVersionUID = -8873765697549607439L;

    private String code;
    private String magicCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "magic_code")
    public String getMagicCode() {
        return magicCode;
    }

    public void setMagicCode(String magicCode) {
        this.magicCode = magicCode;
    }

    public void init(String name, String characterization, String value, String misc, String code, String magicCode) {
        super.init(name, characterization, value, misc);

        this.code = code;
        this.magicCode = magicCode;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
