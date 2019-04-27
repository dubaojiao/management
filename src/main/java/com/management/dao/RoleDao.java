package com.management.dao;

import com.management.entry.Role;
import com.management.entry.RoleMenu;
import com.management.repos.RoleMenuRepos;
import com.management.repos.RoleRepos;
import com.management.uitl.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Title
 * @ClassName RoleDao
 * @Author jsb_pbk
 * @Date 2019/4/26
 */
@Service
public class RoleDao {
    @Autowired
    RoleRepos roleRepos;

    @Autowired
    RoleMenuRepos roleMenuRepos;

    public Role findFirstByRoleState(Integer state){
        return roleRepos.findFirstByRoleState(state);
    }

    public Role save(Role role){
        return roleRepos.save(role);
    }

    public List<Role> bathSave(List<Role> roles){
        return roleRepos.saveAll(roles);
    }

    public RoleMenu saveRoleMenu(RoleMenu roleMenu){
        return roleMenuRepos.save(roleMenu);
    }

    public List<RoleMenu> bathSaveRoleMenu(List<RoleMenu> roleMenus){
        return roleMenuRepos.saveAll(roleMenus);
    }

    public Long countAll() {
        return roleRepos.count();
    }

    public void deleteRoleMenuAll() {
        roleMenuRepos.deleteAll();
    }

    public void deleteAll() {
        roleRepos.deleteAll();
    }

    public Role findById(Integer id) {
        if(CheckUtil.integerIsNull(id)){
            return null;
        }
        Optional<Role> role  = roleRepos.findById(id);
        if (role.isPresent()) {
            return role.get();
        }
        return null;
    }

    public List<RoleMenu> findRoleMenuByRoleId(Integer role) {
        return roleMenuRepos.findAllByRoleId(role);
    }
}
