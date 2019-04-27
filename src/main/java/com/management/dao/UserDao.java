package com.management.dao;

import com.google.common.collect.Maps;
import com.management.common.CommonDao;
import com.management.entry.User;
import com.management.entry.UserRole;
import com.management.repos.UserRepos;
import com.management.repos.UserRoleRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * @Title
 * @ClassName UserDao
 * @Author jsb_pbk
 * @Date 2019/4/27
 */
@Service
public class UserDao {
    @Autowired
    UserRepos userRepos;

    @Autowired
    UserRoleRepos userRoleRepos;

    @Autowired
    CommonDao commonDao;

    public User findFirstByState(Integer state){
        return userRepos.findFirstByState(state);
    }

    public Long countAll(){
        return userRepos.count();
    }

    public User save(User data){
        return userRepos.save(data);
    }

    public UserRole saveUserRole(UserRole data){
        return userRoleRepos.save(data);
    }

    public User findByCodeOrPhone(String code) {
        String sql = "SELECT * FROM  user WHERE code = :code OR phone = :code";
        Map map = Maps.newHashMap();
        map.put("code",code);
        return  commonDao.queryEntity(sql,map,User.class);

    }

    public UserRole findByUid(Integer uid) {
        return userRoleRepos.findFirstByUid(uid);
    }

    public void deleteUserRoleAll() {
        userRoleRepos.deleteAll();
    }
}
