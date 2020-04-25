package com.cssl.controller;

import com.cssl.client.AdmininfoClient;
import com.cssl.entity.Admininfo;
import com.cssl.entity.HemaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController
public class AdmininfoController {

    @Autowired
    private AdmininfoClient aClient;

    /**
     *  登录
     */
    @RequestMapping("/consumer/login2")
    public String  findAll(Admininfo admin){
        if(aClient.findAll(admin)!=null)
            return "0";
        return "1";
    }

    /**
     * 前台所有用户
     * @return
     */
    @RequestMapping("/consumer/hemaUserFall")
    public Map<String, Object> hemaUserFall(){
        Map<String,Object> map=new HashMap<>();
        List<Map<String,Object>> list=aClient.hemaUserFall();
        map.put("code",0);
        map.put("count",list.size());
        map.put("data",list);
        return map;
    }

    /**
     * 修改前台用户
     * @param hemaUser
     * @return
     */
    @RequestMapping("/consumer/updateHemaUser")
    public int updateHemaUser(@RequestBody HemaUser hemaUser){
        return aClient.updateHemaUser(hemaUser);
    }

    /**
     * 删除前台用户
     * @param userid
     * @return
     */
    @RequestMapping("/consumer/delHemaUser")
    public int delHemaUser(@RequestParam(name = "userid") Integer userid){
        return aClient.delHemaUser(userid);
    }

}
