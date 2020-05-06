package com.hema.client;

import com.order.Order;
import com.order.Order_Comm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName OrderClient
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/25 11:08
 * @Version 1.0
 **/
@FeignClient("order-provider")
public interface OrderClient {
    @RequestMapping("/insertOrder")
    public int insertOrder(@RequestBody Order order);

    @RequestMapping("/insert_Order_comm")
    public int insert_Order_comm(@RequestBody Order_Comm orderComm);

    @RequestMapping("/order_FadeAll")
    public List<Order> order_FadeAll(@RequestParam String loginname);

    @RequestMapping("/order_Comm_FadeAll")
    public List<Order_Comm> order_Comm_FadeAll(@RequestParam String loginname);

    @RequestMapping("/upt_Order_State")
    public int upt_Order_State(@RequestBody Order order);
}
