package com.management.dao;

import com.google.common.collect.Maps;
import com.management.common.CommonDao;
import com.management.entry.LoginUser;
import com.management.repos.LoginUserRepos;
import com.management.uitl.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Title
 * @ClassName LoginUserDao
 * @Author jsb_pbk
 * @Date 2019/4/27
 */
@Service
public class LoginUserDao {
    @Autowired
    LoginUserRepos loginUserRepos;
    @Autowired
    CommonDao commonDao;
    public LoginUser save(LoginUser loginUser){
        return loginUserRepos.save(loginUser);
    }

    public LoginUser findByToken(String token){
        if(CheckUtil.stringIsNull(token)){
            return null;
        }
        return loginUserRepos.findFirstByToken(token);
    }

    public void deleteByUid(Integer id) {
        String sql = "DELETE FROM login_user WHERE uid = :uid";
        Map map = Maps.newHashMap();
        map.put("uid",id);
        commonDao.deleteOrUpDate(sql,map);
    }
}
