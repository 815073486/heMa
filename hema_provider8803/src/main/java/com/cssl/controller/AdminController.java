package com.cssl.controller;

import com.cssl.entity.Admininfo;
import com.cssl.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务的提供者
 */
@RestController
public class AdminController {

    @Autowired
    private AdminService aService;

    /**
     *  登录
     */
    @RequestMapping("/provider/login2")
    public String findAll(@RequestBody Admininfo admin){
        System.out.println("****************");
         if(aService.login(admin)!=null)
             return "0";
         return "1";
    }

}
