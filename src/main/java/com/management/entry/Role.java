package com.management.entry;

import javax.persistence.*;
import java.util.Date;

/**
 * @Title
 * @ClassName Role
 * @Author jsb_pbk
 * @Date 2019/4/26
 */
@Entity
public class Role {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(10) COMMENT'role_id'",nullable = false)
    private Integer id;

    /**
     * 角色名称
     */
    @Column(columnDefinition="varchar(32) COMMENT'角色名称'",nullable = false)
    private String roleName="";

    /**
     * 备注
     */
    @Column(columnDefinition="varchar(32) COMMENT'备注'")
    private String roleRemark="";

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

    /**
     * 修改人
     */
    @Column(columnDefinition="int(10) COMMENT'修改人'")
    private Integer updateUser;
    private String updateName;
    /**
     * 修改时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    /**
     * 角色状态1 正常 2 停用  默认为1
     */
    @Column(columnDefinition="int(2) COMMENT'角色状态1 正常 2 停用  默认为1'",nullable = false)
    private Integer roleState= 1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark;
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

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getRoleState() {
        return roleState;
    }

    public void setRoleState(Integer roleState) {
        this.roleState = roleState;
    }
}
