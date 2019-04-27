package com.management.uitl;

import com.google.common.collect.Lists;
import com.management.entry.RoleMenu;

import java.util.List;

/**
 * @Title   所有的菜单
 * @ClassName MenuUitl
 * @Author jsb_pbk
 * @Date 2019/4/26
 */
public class MenuUitl {

    public static class Menu{
        private Integer id;
        private String name;
        private  String path;
        private String icon;
        private Integer checked;

        public Integer getChecked() {
            return checked;
        }

        public void setChecked(Integer checked) {
            this.checked = checked;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }

    private static List<Menu> menus = Lists.newArrayList();

    public static List<Menu> getMenusByIds(List<RoleMenu> roleMenus){
        List<Menu> retMenus  = Lists.newArrayList();
        for(RoleMenu roleMenu:roleMenus){
            for(Menu menu1:menus){
                if(roleMenu.getMenuId().equals(menu1.id)){
                    menu1.setChecked(0);
                    retMenus.add(menu1);
                    break;
                }
            }
        }
        return retMenus;
    }


    static {
        Menu menu1 = new Menu();
        menu1.setId(1);
        menu1.setName("主页");
        menu1.setPath("/index");
        menu1.setIcon("glyphicon glyphicon-home");

        Menu menu2 = new Menu();
        menu2.setId(2);
        menu2.setName("角色管理");
        menu2.setPath("/role");
        menu2.setIcon("glyphicon glyphicon-queen");

        Menu menu3 = new Menu();
        menu3.setId(3);
        menu3.setName("用户管理");
        menu3.setPath("/user");
        menu3.setIcon("glyphicon glyphicon-user");

        Menu menu4 = new Menu();
        menu4.setId(4);
        menu4.setName("系统配置");
        menu4.setPath("/config");
        menu4.setIcon("glyphicon glyphicon-tasks");

        Menu menu5 = new Menu();
        menu5.setId(5);
        menu5.setName("添加记录");
        menu5.setPath("/add");
        menu5.setIcon("glyphicon glyphicon-open-file");

        Menu menu6 = new Menu();
        menu6.setId(6);
        menu6.setName("人员列表");
        menu6.setPath("/users");
        menu6.setIcon("glyphicon glyphicon-baby-formula");

        menus.add(menu1);
        menus.add(menu2);
        menus.add(menu3);
        menus.add(menu4);
        menus.add(menu5);
        menus.add(menu6);
    }

    public static List<Menu> getAll(){
        return menus;
    }

}
