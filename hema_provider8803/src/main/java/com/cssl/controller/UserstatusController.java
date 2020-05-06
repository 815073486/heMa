package com.cssl.controller;

import com.cssl.entity.Address;
import com.cssl.entity.Userstatus;
import com.cssl.service.UserstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserstatusController {

    @Autowired
    private UserstatusService uService;


    @RequestMapping("/userstatusFall")
    public List<Userstatus> userstatusFall(){
        return uService.userstatusFall();
    }


}
