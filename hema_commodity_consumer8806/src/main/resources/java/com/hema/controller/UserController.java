package com.hema.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.hema.client.UserClient;
import com.hemauser.HemaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/10 17:47
 * @Version 1.0
 **/
@RestController
public class UserController {
    @Autowired
    private UserClient uc;

    @PostMapping("/adduser")
    public void adduser(HemaUser hemaUser){
        System.out.println(hemaUser.getLoginname());
        System.out.println(hemaUser.getIdcare());
        System.out.println(hemaUser.getUseremail());
        System.out.println(hemaUser.getUsername());
        System.out.println(hemaUser.getUserpwd());
        uc.addUser(hemaUser);
    }

    @PostMapping("/userVerify")
    public boolean userVerify(String hemaname){
        System.out.println("进入用户名验证方法!!!!" +uc.userVerify(hemaname));
        return uc.userVerify(hemaname);
    }

    @PostMapping("/phoneVerify")
    public boolean phoneVerify(String phone){
        System.out.println("进入手机号验证方法!!!!" +uc.phoneVerify(phone));
        return uc.phoneVerify(phone);
    }

    @PostMapping("/yzm")
    public void yzm(String phone){
        uc.phoneyzm(phone);
    }

    @PostMapping("/login")
    public boolean login(HemaUser user){
        return uc.login(user);
    }
}
