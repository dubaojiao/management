package com.management.controller;

import com.management.common.UserComponent;
import com.management.dao.RoleDao;
import com.management.entry.LoginUser;
import com.management.entry.Role;
import com.management.entry.RoleMenu;
import com.management.entry.UserRole;
import com.management.service.SysService;
import com.management.uitl.CheckUtil;
import com.management.uitl.MenuUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Title  页面返回控制器
 * @ClassName PageController
 * @Author jsb_pbk
 * @Date 2019/4/26
 */
@Controller
public class PageController {

    @Autowired
    UserComponent userComponent;
    @Autowired
    RoleDao roleDao;


    @GetMapping(value = "login")
    public String login(){
        return "login";
    }

    @GetMapping(value = "index")
    public String index(Model model){
        LoginUser loginUser = userComponent.getLoginUser();
        if (CheckUtil.objectIsNull(loginUser)) {
            return "login";
        }
        List<RoleMenu> roleMenus = roleDao.findRoleMenuByRoleId(loginUser.getRole());
        List<MenuUitl.Menu> menus = MenuUitl.getMenusByIds(roleMenus);
        for(MenuUitl.Menu m:menus){
            if (m.getPath().equals("/index")) {
                m.setChecked(1);
            }
        }
        model.addAttribute("user",loginUser);
        model.addAttribute("menus",menus);
        return "index";
    }


    @GetMapping(value = "role")
    public String role(Model model){
        LoginUser loginUser = userComponent.getLoginUser();
        if (CheckUtil.objectIsNull(loginUser)) {
            return "login";
        }
        List<RoleMenu> roleMenus = roleDao.findRoleMenuByRoleId(loginUser.getRole());
        List<MenuUitl.Menu> menus = MenuUitl.getMenusByIds(roleMenus);
        for(MenuUitl.Menu m:menus){
            if (m.getPath().equals("/role")) {
                m.setChecked(1);
            }
        }
        model.addAttribute("user",loginUser);
        model.addAttribute("menus",menus);
        return "role";
    }

}
