package com.management.repos;

import com.management.entry.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Title
 * @ClassName UserRoleRepos
 * @Author jsb_pbk
 * @Date 2019/4/27
 */
public interface UserRoleRepos  extends JpaRepository<UserRole,Integer>{
    UserRole findFirstByUid(Integer uid);
}
