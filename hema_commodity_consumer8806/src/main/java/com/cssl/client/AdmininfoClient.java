package com.cssl.client;


import com.cssl.entity.*;
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
    public int updateHemaUser(@RequestBody Hemauser hemaUser);

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
    @RequestMapping("/userstatusFall")
    public List<Userstatus> userstatusFall();

    /**
     * 查看所有订单
     * @return
     */
    @RequestMapping("/orderFall")
    public List<Map<String,Object>> advancedSelectOrder(@RequestParam Map<String,Object> map);

    /**
     * 修改订单
     * @param order
     * @return
     */
    @RequestMapping("/updateOrder")
    public int updateOrder(@RequestBody Order order);

    /**
     * 修改订单地址
     * @param address
     * @return
     */
    @RequestMapping("/updateAddress")
    public int updateAddress(@RequestBody Address address);

    /**
     * 查看所有订单状态
     * @return
     */
    @RequestMapping("/OrderstateFall")
    public List<Orderstate> OrderstateFall();

}
