package com.order.dao;

import com.order.Order;
import com.order.Order_Comm;

import java.util.List;

public interface OrderDao {
    public int insertOrder(Order order);
    public int insert_Order_comm(Order_Comm orderComm);
    public List<Order> order_FadeAll(String loginname);
    public List<Order_Comm> order_Comm_FadeAll(String loginname);
    public int upt_Order_State(Order order);
}
