package com.management.entry;

import javax.persistence.*;
import java.util.Date;

/**
 * @Title
 * @ClassName User
 * @Author jsb_pbk
 * @Date 2019/4/27
 */
@Entity
public class UserRole {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(10) COMMENT'role_id'",nullable = false)
    private Integer id;

    private Integer uid;

    private Integer roleId;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
