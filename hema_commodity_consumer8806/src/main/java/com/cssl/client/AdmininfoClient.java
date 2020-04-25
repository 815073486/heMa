package com.cssl.client;


import com.cssl.entity.Admininfo;
import com.cssl.entity.HemaUser;
import com.cssl.entity.Userrank;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name="hema-provider-user")
public interface AdmininfoClient {

    /**
     * 后台登录
     * @param admin
     * @return
     */
    @RequestMapping("/provider/login2")
    public String findAll(Admininfo admin);

    /**
     * 前台所有用户
     * @return
     */
    @RequestMapping("/hemaUserFall")
    public List<Map<String, Object>> hemaUserFall();

    /**
     * 修改前台用户
     * @param hemaUser
     * @return
     */
    @RequestMapping("/updateHemaUser")
    public int updateHemaUser(@RequestBody HemaUser hemaUser);

    /**
     * 删除前台用户
     * @param userid
     * @return
     */
    @RequestMapping("/delHemaUser")
    public int delHemaUser(@RequestParam(name = "userid") Integer userid);

    /**
     * 查询所有用户状态
     * @return
     */
    @RequestMapping("/UserrankFall")
    public List<Userrank> UserrankFall();

}
