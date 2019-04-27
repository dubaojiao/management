package com.management.repos;

import com.management.entry.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleMenuRepos extends JpaRepository<RoleMenu,Integer> {
    List<RoleMenu> findAllByRoleId(Integer roleId);
}
