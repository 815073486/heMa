package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.OrderstateDao;
import com.cssl.entity.Orderstate;
import com.cssl.service.OrderService;
import com.cssl.service.OrderstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AutoConfigureAfter({OrderstateDao.class})
public class OrderstateServiceImpl extends ServiceImpl<OrderstateDao, Orderstate> implements OrderstateService {

    @Autowired
    private OrderstateDao oDao;

    @Override
    public List<Orderstate> OrderstateFall() {
        return oDao.selectByMap(null);
    }

}
