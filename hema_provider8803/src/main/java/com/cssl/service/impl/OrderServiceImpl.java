package com.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.OrderDao;
import com.cssl.entity.Order;
import com.cssl.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AutoConfigureAfter({OrderDao.class})
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

    @Autowired
    private OrderDao oDao;

    @Override
    public List<Map<String,Object>> advancedSelectOrder(Map<String,Object> map) {
        return oDao.advancedSelectOrder(map);
    }

    /**
     * 修改订单
     * @param order
     * @return
     */
    @Override
    public int orderUpdate(Order order) {
        order.setOrdernum(null);
        return oDao.orderUpdate(order);
    }
}
