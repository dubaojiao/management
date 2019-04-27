package com.management.controller;

import com.management.pojo.ApiResult;
import com.management.pojo.LoginData;
import com.management.service.SysService;
import com.management.uitl.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.management.common.SysConstant.ERROR_500;

/**
 * @Title
 * @ClassName SysController
 * @Author jsb_pbk
 * @Date 2019/4/26
 */
@RestController
@RequestMapping(value = "/sys/")
public class SysController {

    @Autowired
    SysService sysService;

    @PostMapping(value ="login" )
    public ApiResult login(@RequestBody LoginData data){
        try {
            if(data.isNull()){
                return ApiResult.returnParameterError();
            }
            return sysService.login(data);
        }catch (Exception ex){
            ex.printStackTrace();
            return ApiResult.returnError(ERROR_500,ex);
        }
    }

}
