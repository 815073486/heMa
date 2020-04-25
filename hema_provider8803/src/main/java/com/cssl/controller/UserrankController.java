package com.cssl.controller;

import com.cssl.entity.Userrank;
import com.cssl.service.UserrankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserrankController {

    @Autowired
    private UserrankService uService;

    /**
     * 查询所有用户状态
     * @return
     */
    @RequestMapping("/UserrankFall")
    public List<Userrank> UserrankFall(){
        return uService.UserrankFall();
    }

}
