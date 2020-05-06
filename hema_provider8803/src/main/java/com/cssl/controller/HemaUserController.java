package com.cssl.controller;

import com.cssl.entity.Hemauser;
import com.cssl.service.HemaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HemaUserController {

    @Autowired
    private HemaUserService hService;

    @RequestMapping("/hemaUserFall")
    public List<Map<String, Object>> hemaUserFall(){
        return hService.hemaUserFall();
    }

    @RequestMapping("/updateHemaUser")
    public int updateHemaUser(@RequestBody Hemauser hemaUser){
        return hService.updateHemaUser(hemaUser);
    }

    @RequestMapping("/delHemaUser")
    public int delHemaUser(@RequestParam(name = "userid") Integer userid){
        return hService.deleteHemaUser(userid);
    }
}
