package com.cssl.controller;

import com.cssl.client.AdmininfoClient;
import com.cssl.entity.*;
import com.github.pagehelper.PageHelper;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
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
    public int updateHemaUser(Hemauser hemaUser){
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

    /**
     * 查询所有用户状态
     * @return
     */
    @RequestMapping("/consumer/userstatusFall")
    public List<Userstatus> userstatusFall(){
        return aClient.userstatusFall();
    }

    /**
     * 查看所有订单
     * @return
     */
    @RequestMapping("/consumer/orderFall")
    public Map<String,Object> advancedSelectOrder(@RequestParam Map<String,Object> map,Integer page,Integer pageindex){
        Map<String,Object> map1 = new HashMap<>();
        if(page==null){
            page=1;
        }
        if(pageindex==null){
            pageindex=10;
        }
        PageHelper.startPage((page-1)*pageindex,pageindex);
        map.put("page",(page-1)*pageindex);
        map.put("pageindex",pageindex);
        List<Map<String,Object>> list = aClient.advancedSelectOrder(map);
        map1.put("code",0);
        map1.put("count",list.size());
        map1.put("data",list);
        return map1;
    }

    /**
     * 查看订单状态
     * @return
     */
    @RequestMapping("/consumer/OrderstateFall")
    public List<Orderstate> OrderstateFall(){
        return aClient.OrderstateFall();
    }

    /**
     * 修改订单
     * @param map
     * @return
     */
    @RequestMapping("/consumer/updateOrder")
    public int updateOrder(@RequestParam Map<String,Object> map){
        Order order = new Order();
        order.setOrderid(Integer.parseInt(map.get("orderid").toString()));
        order.setOrdernum(map.get("ordernum").toString());
        order.setStateid(Integer.parseInt(map.get("stateid").toString()));

        Address address = new Address();
        address.setConsignee(map.get("consignee").toString());
        address.setAddressname(map.get("addressname").toString());
        address.setConsigneephone(map.get("consigneephone").toString());
        address.setAdderssid(Integer.parseInt(map.get("addressid").toString()));
        System.out.println(address.getConsignee()+"**************");
        if(aClient.updateOrder(order)>0 && aClient.updateAddress(address)>0)
            return 1;
       return 0;
    }


}
