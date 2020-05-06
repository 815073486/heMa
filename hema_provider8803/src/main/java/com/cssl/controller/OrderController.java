package com.cssl.controller;

import com.cssl.entity.Address;
import com.cssl.entity.Order;
import com.cssl.entity.Orderstate;
import com.cssl.service.AddressService;
import com.cssl.service.OrderService;
import com.cssl.service.OrderstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private OrderService oService;

    @Autowired
    private AddressService aService;

    @Autowired
    private OrderstateService sService;

    /**
     * 高级查询订单
     * @param map
     * @return
     */
    @RequestMapping("/orderFall")
    public List<Map<String,Object>> advancedSelectOrder(@RequestParam Map<String,Object> map){
        return oService.advancedSelectOrder(map);
    }

    /**
     * 修改订单
     * @param order
     * @return
     */
    @RequestMapping("/updateOrder")
    public int updateOrder(@RequestBody Order order){
        return oService.orderUpdate(order);
    }

    /**
     * 修改订单地址
     * @param address
     * @return
     */
    @RequestMapping("/updateAddress")
    public int updateAddress(@RequestBody Address address){
        System.out.println(address.getConsignee()+"*********************");
        return aService.updateAddress(address);
    }

    /**
     * 订单状态
     */
    @RequestMapping("/OrderstateFall")
    public List<Orderstate> OrderstateFall(){
        return sService.OrderstateFall();
    }
}
