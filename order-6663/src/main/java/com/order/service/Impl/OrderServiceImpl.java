package com.order.service.Impl;

import com.order.Order;
import com.order.Order_Comm;
import com.order.dao.OrderDao;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/25 12:22
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao od;

    @Override
    public int insertOrder(Order order) {
        return od.insertOrder(order);
    }

    @Override
    public int insert_Order_comm(Order_Comm orderComm) {
        return od.insert_Order_comm(orderComm);
    }

    @Override
    public List<Order> order_FadeAll(String loginname) {
        return od.order_FadeAll(loginname);
    }

    @Override
    public List<Order_Comm> order_Comm_FadeAll(String loginname) {
        return od.order_Comm_FadeAll(loginname);
    }

    @Override
    public int upt_Order_State(Order order) {
        return od.upt_Order_State(order);
    }
}
