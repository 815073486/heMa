package com.order.controllor;

import com.order.Order;
import com.order.Order_Comm;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/24 19:58
 * @Version 1.0
 **/
@RestController
public class OrderController {
    @Autowired
    private OrderService os;

    @RequestMapping("/insertOrder")
    public int insertOrder(@RequestBody Order order){
        return os.insertOrder(order);
    }

    @RequestMapping("/insert_Order_comm")
    public int insert_Order_comm(@RequestBody Order_Comm orderComm){
        return os.insert_Order_comm(orderComm);
    }

    @RequestMapping("/order_FadeAll")
    public List<Order> order_FadeAll(String loginname){
        return os.order_FadeAll(loginname);
    }

    @RequestMapping("/order_Comm_FadeAll")
    public List<Order_Comm> order_Comm_FadeAll(String loginname){
        return os.order_Comm_FadeAll(loginname);
    }

    @RequestMapping("/upt_Order_State")
    public int upt_Order_State(@RequestBody Order order){
        return os.upt_Order_State(order);
    }
}
