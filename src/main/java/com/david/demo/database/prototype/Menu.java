package com.david.demo.database.prototype;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单
 *
 * @2018-12-06
 * @David
 */
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_name", columnNames = {"name"})
        }
)
public class Menu extends Basic {
    private static final long serialVersionUID = -6343681841448737546L;

    // 是否是叶子节点
    private boolean leaf;

    private Menu parentMenu;
    private List<Menu> childrenMenuList = new ArrayList<Menu>();
    private List<UserGroup> userGroupList = new ArrayList<UserGroup>();

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE
            }
    )
    @JoinColumn(name = "parent_menu_id")
    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    @OneToMany(
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE
            },
            mappedBy = "parentMenu"
    )
    @OrderBy("id ASC")
    public List<Menu> getChildrenMenuList() {
        return childrenMenuList;
    }

    public void setChildrenMenuList(List<Menu> childrenMenuList) {
        this.childrenMenuList = childrenMenuList;
    }

    @ManyToMany(
            mappedBy = "menuList",
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE
            }
    )
    public List<UserGroup> getUserGroupList() {
        return userGroupList;
    }

    public void setUserGroupList(List<UserGroup> userGroupList) {
        this.userGroupList = userGroupList;
    }

    public void init(String name, String characterization, String value, String misc, boolean leaf, Menu parentMent) {
        super.init(name, characterization, value, misc);

        this.leaf = leaf;
        this.parentMenu = parentMent;
    }
}
