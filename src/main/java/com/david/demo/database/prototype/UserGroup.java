package com.david.demo.database.prototype;

import com.alibaba.fastjson.JSON;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户组
 *
 * @2018-11-29
 * @David
 */
@Entity
@Table(name = "user_group")
public class UserGroup extends Basic {
    private static final long serialVersionUID = -7426723090215465382L;

    private List<User> userList = new ArrayList<User>();
    private List<Menu> menuList = new ArrayList<Menu>();

    @OneToMany(
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE
            },
            mappedBy = "userGroup"
    )
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,  CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "user_group_to_menu",
            joinColumns = {
                    @JoinColumn(name = "user_group_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "menu_id")
            }
    )
    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public void init(String name, String characterization, String value, String misc) {
        super.init(name, characterization, value, misc);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
