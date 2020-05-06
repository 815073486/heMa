package com.hemauser.controller;

import com.hemauser.Address;
import com.hemauser.HemaUser;
import com.hemauser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/10 19:20
 * @Version 1.0
 **/
@RestController
public class UserController {
    @Autowired
    private UserService us;


    @PostMapping("/phoneVerify")
    public boolean phoneVerify(String phone){
        return us.phoneVerify(phone);
    }

    @PostMapping("/addUser")
    public int addUser(@RequestBody HemaUser user){
      return us.addUser(user);

    }
    @PostMapping("/login")
    public boolean login(@RequestBody HemaUser user){
        return us.login(user);
    }

    @PostMapping("/insert_Address")
    public int insert_Address(@RequestBody Address add){
        return us.insert_Address(add);
    }

    @PostMapping("/addressFadeAll")
    public List<Address> addressFadeAll(String username){
        return us.addressFadeAll(username);
    }

}
