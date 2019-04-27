package com.management.runner;

import com.google.common.collect.Lists;
import com.management.dao.RoleDao;
import com.management.dao.UserDao;
import com.management.entry.Role;
import com.management.entry.RoleMenu;
import com.management.entry.User;
import com.management.entry.UserRole;
import com.management.repos.UserRepos;
import com.management.uitl.MenuUitl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Title 项目启动-最后执行的类
 * @ClassName WebApplicationRunner
 * @Author duke
 * @Date 2018/9/13
 */

@Component
@Order(value = 999)
public class WebApplicationRunner implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger(WebApplicationRunner.class);
    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("检查项目是否需要进行初始化数据");
        Long userNum = userDao.countAll();
        User user;
        Role role;
        if(userNum.intValue() > 0){
            logger.info("无需初始化用户数据");
            user  = userDao.findFirstByState(1);
        }else {
            logger.info("初始化用户数据");
            user = new User();
            user.setCode("15559709268");
            user.setCreateTime(new Date());
            user.setCreateUser(0);
            user.setState(1);
            user.setCreateUserName("系统初始化注册");
            user.setLoginNum(0);
            user.setName("开发01");
            user.setPhone("15559709268");
            user.setPwd("123456");
            user.setRemark("系统初始化注册");
            user.setSource("系统初始化注册");

            user = userDao.save(user);
            userDao.deleteUserRoleAll();
            roleDao.deleteRoleMenuAll();
            roleDao.deleteAll();

        }
        Long roleNum  = roleDao.countAll();
        if(roleNum.intValue() > 0){
            logger.info("无需初始化角色数据");
            role  = roleDao.findFirstByRoleState(1);
        }else {
            logger.info("初始化角色数据");
            role = new Role();
            role.setCreateName("系统");
            role.setCreateTime(new Date());
            role.setCreateUser(0);
            role.setRoleName("管理员");
            role.setRoleRemark("系统初始化");
            role.setRoleState(1);
            role.setUpdateName("系统");
            role.setUpdateTime(new Date());
            role.setUpdateUser(0);
            role = roleDao.save(role);


            List<RoleMenu> roleMenus = Lists.newArrayList();
            RoleMenu roleMenu;
            List<MenuUitl.Menu> menus = MenuUitl.getAll();
            for(MenuUitl.Menu menu:menus){
                roleMenu = new RoleMenu();
                roleMenu.setCreateName("系统");
                roleMenu.setCreateTime(new Date());
                roleMenu.setCreateUser(0);
                roleMenu.setMenuId(menu.getId());
                roleMenu.setRoleId(role.getId());
                roleMenus.add(roleMenu);
            }
            roleDao.bathSaveRoleMenu(roleMenus);

            UserRole  userRole = new UserRole();
            userRole.setRoleId(role.getId());
            userRole.setUid(user.getId());
            userRole.setTime(new Date());
            userDao.saveUserRole(userRole);
        }




        logger.info("项目启动完成");
    }

}
