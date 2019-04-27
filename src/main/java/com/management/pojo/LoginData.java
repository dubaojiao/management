package com.management.pojo;

import com.management.uitl.CheckUtil;

import java.io.Serializable;

/**
 * @Title
 * @ClassName LoginData
 * @Author jsb_pbk
 * @Date 2019/4/26
 */
public class LoginData implements Serializable {
    private String name;
    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean isNull(){
        if(this== null){
            return true;
        }
        if(CheckUtil.stringIsNull(this.name) ||CheckUtil.stringIsNull(this.pwd) ){
            return true;
        }
        return false;
    }

}
