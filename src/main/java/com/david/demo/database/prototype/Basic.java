package com.david.demo.database.prototype;

import com.alibaba.fastjson.JSON;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 基础类
 *
 * @2018-11-28
 * @David
 */
@MappedSuperclass
@Table(
        indexes = {
                @Index(name = "index_name", columnList = "name")
        }
)
public class Basic implements Serializable {
    private static final long serialVersionUID = -3027627447007160584L;

    private long id;
    private String name;
    private String characterization;
    private String value;
    private String misc;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterization() {
        return characterization;
    }

    public void setCharacterization(String characterization) {
        this.characterization = characterization;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    public void init(String name, String characterization, String value, String misc) {
        this.name = name;
        this.characterization = characterization;
        this.value = value;
        this.misc = misc;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
