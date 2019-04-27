package com.management.service;

import com.management.common.UserComponent;
import com.management.dao.LoginUserDao;
import com.management.dao.RoleDao;
import com.management.dao.UserDao;
import com.management.entry.LoginUser;
import com.management.entry.Role;
import com.management.entry.User;
import com.management.entry.UserRole;
import com.management.pojo.ApiResult;
import com.management.pojo.LoginData;
import com.management.uitl.CheckUtil;
import com.management.uitl.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Title
 * @ClassName SysService
 * @Author jsb_pbk
 * @Date 2019/4/26
 */
@Service
public class SysService {

    @Autowired
    UserDao userDao;
    @Autowired
    LoginUserDao loginUserDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    HttpServletRequest request;
    @Autowired
    UserComponent userComponent;

    @Autowired(required = false)
    HttpServletResponse response;
    public ApiResult login(LoginData data) {
        User user = userDao.findByCodeOrPhone(data.getName());
        if(CheckUtil.objectIsNull(user)){
            return ApiResult.returnError("查询无此用户");
        }
        if(!data.getPwd().trim().equals(user.getPwd().trim())){
            return ApiResult.returnError("用户名或者密码错误");
        }
        UserRole userRole = userDao.findByUid(user.getId());
        if (CheckUtil.objectIsNull(userRole)) {
            return ApiResult.returnError("无法获取到用户的角色关系信息");
        }
        Role role = roleDao.findById(userRole.getRoleId());
        if(CheckUtil.objectIsNull(role)){
            return ApiResult.returnError("无法获取到用户的角色信息");
        }
        if(role.getRoleState() != 1){
            return ApiResult.returnError("无法获角色已被停用无法登陆系统");
        }
        String token = UUID.randomUUID().toString().replaceAll("-","");
        loginUserDao.deleteByUid(user.getId());
        LoginUser  loginUser  = new LoginUser();
        loginUser.setCode(user.getCode());
        loginUser.setName(user.getName());
        loginUser.setPhone(user.getPhone());
        loginUser.setRole(role.getId());
        loginUser.setRoleName(role.getRoleName());
        loginUser.setToken(token);
        loginUser.setUid(user.getId());
        loginUser.setLoginTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        loginUserDao.save(loginUser);
        user.setLoginNum(user.getLoginNum()+1);
        user.setLoginTime(new Date());
        userDao.save(user);
        //设置cookice;
        CookieUtil.addCookie(response,token,7*24*60);
        return ApiResult.returnSuccess("登录成功");

    }

}
