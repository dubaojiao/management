package com.management.repos;

import com.management.entry.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Title
 * @ClassName RoleRepos
 * @Author jsb_pbk
 * @Date 2019/4/26
 */
public interface RoleRepos extends JpaRepository<Role,Integer> {
    Role findFirstByRoleState(Integer state);
}
