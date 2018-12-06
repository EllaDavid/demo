package com.david.demo.database.prototype;

import com.alibaba.fastjson.JSON;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 部门
 *
 * @2018-11-29
 * @David
 */
@Entity
public class Department extends Basic {
    private static final long serialVersionUID = 1952338009367230514L;

    private Department supDepartment;
    private List<Department> subDepartmentList = new ArrayList<Department>();

    private List<User> userList = new ArrayList<User>();

    @OneToMany(
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE
            },
            mappedBy = "department"
    )
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE
            }
    )
    @JoinColumn(name = "sup_department_id")
    public Department getSupDepartment() {
        return supDepartment;
    }

    public void setSupDepartment(Department supDepartment) {
        this.supDepartment = supDepartment;
    }

    @OneToMany(
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE
            },
            mappedBy = "supDepartment"
    )
    public List<Department> getSubDepartmentList() {
        return subDepartmentList;
    }

    public void setSubDepartmentList(List<Department> subDepartmentList) {
        this.subDepartmentList = subDepartmentList;
    }

    public void init(String name, String characterization, String value, String misc, Department supDepartment) {
        super.init(name, characterization, value, misc);

        this.supDepartment = supDepartment;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
