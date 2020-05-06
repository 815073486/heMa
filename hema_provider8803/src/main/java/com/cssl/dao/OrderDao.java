package com.cssl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cssl.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDao extends BaseMapper<Order> {
    public List<Map<String,Object>> advancedSelectOrder(Map<String,Object> map);

    public int orderUpdate(Order order);
}
