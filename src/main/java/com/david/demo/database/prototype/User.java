package com.david.demo.database.prototype;

import com.alibaba.fastjson.JSON;

import javax.persistence.*;

/**
 * 用户
 *
 * @2018-11-29
 * @David
 */
@Entity
@Table(
        indexes = {
                @Index(name = "index_mobile", columnList = "mobile"),
                @Index(name = "index_empno", columnList = "empno")
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_mobile", columnNames = {"mobile"}),
                @UniqueConstraint(name = "unique_empno", columnNames = {"empno"})
        }
)
public class User extends Basic {
    private static final long serialVersionUID = 6969528034375414805L;

    private String password;
    private String mobile;
    private String empno;

    private Department department;
    private UserGroup userGroup;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE
            }
    )
    @JoinColumn(name = "department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE
            }
    )
    @JoinColumn(name = "user_group_id")
    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public void init(String name, String characterization, String value, String misc, String password, String mobile,
                     Department department, UserGroup userGroup) {
        super.init(name, characterization, value, misc);

        this.password = password;
        this.mobile = mobile;
        this.department = department;
        this.userGroup = userGroup;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
