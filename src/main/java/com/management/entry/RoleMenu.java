package com.management.entry;

import javax.persistence.*;
import java.util.Date;

/**
 * @Title
 * @ClassName RoleMenu
 * @Author jsb_pbk
 * @Date 2019/4/26
 */
@Entity
public class RoleMenu {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(10) COMMENT'role_id'",nullable = false)
    private Integer id;

    private Integer roleId;

    private Integer menuId;

    /**
     * 添加人
     */
    @Column(columnDefinition="int(10) COMMENT'添加人'",nullable = false)
    private Integer createUser;

    private String createName;
    /**
     * 添加时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
