package com.cssl.service;

import com.cssl.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    public List<Map<String,Object>> advancedSelectOrder(Map<String,Object> map);

    public int orderUpdate(Order order);
}
