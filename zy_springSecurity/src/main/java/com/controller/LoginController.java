package com.controller;

import com.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangyu on 2017/11/5.
 */
@Controller
public class LoginController {





    @RequestMapping("/login")
    public String toLogin(UserInfo userInfo){

        //逻辑判断
        if("user".equals(userInfo.getUsernmae())&&"user".equals(userInfo.getPwd())){
            return "user";
        }else{
            return "admin";
        }
    }



}
