package com.management.common;

import com.management.dao.LoginUserDao;
import com.management.entry.LoginUser;
import com.management.uitl.CheckUtil;
import com.management.uitl.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Title
 * @ClassName UserComponent
 * @Author jsb_pbk
 * @Date 2019/4/27
 */
@Component
public class UserComponent {

    @Autowired
    LoginUserDao loginUserDao;

    @Autowired
    HttpServletRequest request;

    public LoginUser getLoginUser(){
        String token = CookieUtil.getCookie(request);
        if(CheckUtil.stringIsNull(token)){
            return null;
        }
        return loginUserDao.findByToken(token);
    }

}
